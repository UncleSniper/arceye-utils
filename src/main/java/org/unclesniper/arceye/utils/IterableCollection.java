package org.unclesniper.arceye.utils;

import java.util.Iterator;
import java.util.Collection;
import java.lang.reflect.Array;

public class IterableCollection<ElementT> implements Collection<ElementT> {

	private Iterable<ElementT> iterable;

	public IterableCollection(Iterable<ElementT> iterable) {
		this.iterable = iterable;
	}

	public Iterable<ElementT> getIterable() {
		return iterable;
	}

	public void setIterable(Iterable<ElementT> iterable) {
		this.iterable = iterable;
	}

	public boolean add(ElementT element) {
		throw new UnsupportedOperationException();
	}

	public boolean addAll(Collection<? extends ElementT> collection) {
		throw new UnsupportedOperationException();
	}

	public void clear() {
		throw new UnsupportedOperationException();
	}

	public boolean contains(Object o) {
		if(iterable == null)
			return false;
		for(ElementT e : iterable) {
			if(o == null ? e == null : o.equals(e))
				return true;
		}
		return false;
	}

	public boolean containsAll(Collection<?> c) {
		if(c == null)
			return true;
		for(Object o : c) {
			if(!contains(o))
				return false;
		}
		return true;
	}

	public boolean isEmpty() {
		return iterable == null || !iterable.iterator().hasNext();
	}

	public Iterator<ElementT> iterator() {
		return iterable.iterator();
	}

	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	public int size() {
		if(iterable == null)
			return 0;
		int s = 0;
		for(ElementT element : iterable)
			++s;
		return s;
	}

	public Object[] toArray() {
		if(iterable == null)
			return new Object[0];
		Object[] a = new Object[size()];
		int index = 0;
		for(ElementT element : iterable)
			a[index++] = element;
		return a;
	}

	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] desiredType) {
		T[] a = (T[])Array.newInstance(desiredType.getClass().getComponentType(), size());
		if(iterable == null)
			return a;
		int index = 0;
		for(ElementT element : iterable)
			a[index++] = (T)element;
		return a;
	}

}
