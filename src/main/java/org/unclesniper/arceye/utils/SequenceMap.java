package org.unclesniper.arceye.utils;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;

public class SequenceMap<KeyT, ValueT> {

	public static class Node<KeyT, ValueT> {

		private final SequenceMap<KeyT, ValueT> map;

		private final Node<KeyT, ValueT> parent;

		private final KeyT key;

		private ValueT value;

		private String name;

		private final Map<KeyT, Node<KeyT, ValueT>> children = new HashMap<KeyT, Node<KeyT, ValueT>>();

		public Node(SequenceMap<KeyT, ValueT> map, Node<KeyT, ValueT> parent, KeyT key, ValueT value, String name) {
			this.map = map;
			this.parent = parent;
			this.key = key;
			this.value = value;
			this.name = name;
		}

		public Node(SequenceMap<KeyT, ValueT> map, Node<KeyT, ValueT> parent, KeyT key, ValueT value) {
			this(map, parent, key, value, null);
		}

		public SequenceMap<KeyT, ValueT> getMap() {
			return map;
		}

		public Node<KeyT, ValueT> getParent() {
			return parent;
		}

		public KeyT getKey() {
			return key;
		}

		public ValueT getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Set<KeyT> getKeys() {
			return children.keySet();
		}

		public Node<KeyT, ValueT> getChild(KeyT key) {
			return children.get(key);
		}

		public boolean isLeaf() {
			return children.isEmpty();
		}

		public void remove() {
			if(value == null)
				return;
			value = null;
			--map.size;
			Node<KeyT, ValueT> collapse = this;
			for(;;) {
				if(!collapse.isLeaf() || collapse.value != null || collapse.parent == null)
					break;
				collapse.parent.children.remove(collapse.key);
				collapse = collapse.parent;
			}
		}

		public List<KeyT> getKeyPath() {
			LinkedList<KeyT> keys = new LinkedList<KeyT>();
			Node<KeyT, ValueT> node = this;
			do {
				keys.addFirst(key);
				node = node.parent;
			} while(node != null);
			return keys;
		}

	}

	private final Node<KeyT, ValueT> root = new Node<KeyT, ValueT>(this, null, null, null);

	private int size;

	public int getSize() {
		return size;
	}

	public Node<KeyT, ValueT> getRoot() {
		return root;
	}

	public Node<KeyT, ValueT> put(ValueT value, Iterable<KeyT> keys) {
		Node<KeyT, ValueT> prev = root;
		for(KeyT key : keys) {
			Node<KeyT, ValueT> next = prev.getChild(key);
			if(next == null) {
				if(value == null)
					return null;
				next = new Node<KeyT, ValueT>(this, prev, key, null);
				prev.children.put(key, next);
			}
			prev = next;
		}
		if(value == null)
			prev.remove();
		else {
			if(prev.value == null)
				++size;
			prev.value = value;
		}
		return prev;
	}

	public Node<KeyT, ValueT> remove(Iterable<KeyT> keys) {
		return put(null, keys);
	}

	public Node<KeyT, ValueT> get(Iterable<KeyT> keys) {
		Node<KeyT, ValueT> node = root;
		for(KeyT key : keys) {
			node = node.getChild(key);
			if(node == null)
				break;
		}
		return node;
	}

	public void clear() {
		root.value = null;
		root.name = null;
		root.children.clear();
		size = 0;
	}

}
