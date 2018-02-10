package org.unclesniper.arceye.utils;

import java.util.Iterator;

public class ByteArrayIterable implements Iterable<Byte> {

	public static  class ByteArrayIterator implements Iterator<Byte> {

		private int pointer;

		private final byte[] array;

		public ByteArrayIterator(byte[] array) {
			this.array = array;
		}

		public boolean hasNext() {
			return pointer < array.length;
		}

		public Byte next() {
			return array[pointer++];
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	private final byte[] array;

	public ByteArrayIterable(byte[] array) {
		this.array = array;
	}

	public byte[] getArray() {
		return array;
	}

	public Iterator<Byte> iterator() {
		return new ByteArrayIterator(array);
	}

}
