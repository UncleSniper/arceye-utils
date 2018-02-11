package org.unclesniper.arceye.utils;

import java.util.Map;
import java.util.Iterator;

public class MapValueIterator<KeyT, ValueT> implements Iterator<ValueT> {

	private Iterator<Map.Entry<KeyT, ValueT>> entryIterator;

	public MapValueIterator(Iterator<Map.Entry<KeyT, ValueT>> entryIterator) {
		this.entryIterator = entryIterator;
	}

	public Iterator<Map.Entry<KeyT, ValueT>> getEntryIterator() {
		return entryIterator;
	}

	public void setEntryIterator(Iterator<Map.Entry<KeyT, ValueT>> entryIterator) {
		this.entryIterator = entryIterator;
	}

	public boolean hasNext() {
		return entryIterator == null ? false : entryIterator.hasNext();
	}

	public ValueT next() {
		return entryIterator.next().getValue();
	}

	public void remove() {
		entryIterator.remove();
	}

}
