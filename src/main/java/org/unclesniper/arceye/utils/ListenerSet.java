package org.unclesniper.arceye.utils;

import java.util.List;
import java.util.LinkedList;
import java.util.IdentityHashMap;

public class ListenerSet<ListenerT> {

	private final IdentityHashMap<ListenerT, Boolean> listeners = new IdentityHashMap<>();

	private List<ListenerT> cache;

	public ListenerSet() {}

	public boolean addListener(ListenerT listener) {
		if(listener == null || listeners.put(listener, Boolean.TRUE) != null)
			return false;
		cache = null;
		return true;
	}

	public boolean removeListener(ListenerT listener) {
		if(listener == null || listeners.remove(listener) == null)
			return false;
		cache = null;
		return true;
	}

	public Iterable<ListenerT> getListeners() {
		if(cache == null) {
			cache = new LinkedList<ListenerT>();
			cache.addAll(listeners.keySet());
		}
		return cache;
	}

}
