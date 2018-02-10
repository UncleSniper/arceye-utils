package org.unclesniper.arceye.utils;

import java.util.Iterator;

public class ObjectArrayIterable<ElementT> implements Iterable<ElementT> {

	public static class ObjectArrayIterator<ElementT> implements Iterator<ElementT> {

		private int pointer;

		private final ElementT[] array;

		public ObjectArrayIterator(ElementT[] array) {
			this.array = array;
		}

		public boolean hasNext() {
			return pointer < array.length;
		}

		public ElementT next() {
			return array[pointer++];
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	private final ElementT[] array;

	public ObjectArrayIterable(ElementT[] array) {
		this.array = array;
	}

	public ElementT[] getArray() {
		return array;
	}

	public Iterator<ElementT> iterator() {
		return new ObjectArrayIterator<ElementT>(array);
	}

}
