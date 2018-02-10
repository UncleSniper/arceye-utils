package org.unclesniper.arceye.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleObjectIterable<ElementT> implements Iterable<ElementT> {

	public static class SingleObjectIterator<ElementT> implements Iterator<ElementT> {

		private boolean more = true;

		private final ElementT object;

		public SingleObjectIterator(ElementT object) {
			this.object = object;
		}

		public boolean hasNext() {
			return more;
		}

		public ElementT next() {
			if(!more)
				throw new NoSuchElementException();
			more = false;
			return object;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	private final ElementT object;

	public SingleObjectIterable(ElementT object) {
		this.object = object;
	}

	public ElementT getObject() {
		return object;
	}

	public Iterator<ElementT> iterator() {
		return new SingleObjectIterator<ElementT>(object);
	}

}
