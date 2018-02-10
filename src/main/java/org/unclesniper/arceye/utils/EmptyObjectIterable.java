package org.unclesniper.arceye.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EmptyObjectIterable<ElementT> implements Iterable<ElementT> {

	public static class EmptyObjectIterator<ElementT> implements Iterator<ElementT> {

		public boolean hasNext() {
			return false;
		}

		public ElementT next() {
			throw new NoSuchElementException();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	public Iterator<ElementT> iterator() {
		return new EmptyObjectIterator<ElementT>();
	}

}
