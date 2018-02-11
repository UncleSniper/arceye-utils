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

	public <ForwardEventT, BackwardEventT> void fireRevocableEvent(
		EventFireClosure<ListenerT, ForwardEventT> forward,
		ForwardEventT forwardEvent,
		Runnable undo,
		EventFireClosure<ListenerT, BackwardEventT> backward,
		BackwardEventT backwardEvent
	) {
		ListenerSet.fireRevocableEvent(getListeners(), forward, forwardEvent, undo, backward, backwardEvent);
	}

	public static <ListenerT, ForwardEventT, BackwardEventT> void fireRevocableEvent(
		Iterable<ListenerT> listeners,
		EventFireClosure<ListenerT, ForwardEventT> forward,
		ForwardEventT forwardEvent,
		Runnable undo,
		EventFireClosure<ListenerT, BackwardEventT> backward,
		BackwardEventT backwardEvent
	) {
		ListenerT stop = null;
		RuntimeException exception = null;
		Error error = null;
		for(ListenerT listener : listeners) {
			if(listener == null)
				continue;
			stop = listener;
			try {
				forward.fireEventForListener(listener, forwardEvent);
			}
			catch(RuntimeException re) {
				exception = re;
				break;
			}
			catch(Error e) {
				error = e;
				break;
			}
		}
		if(exception == null && error == null)
			return;
		undo.run();
		try {
			for(ListenerT listener : listeners) {
				if(listener == stop)
					break;
				try {
					backward.fireEventForListener(listener, backwardEvent);
				}
				catch(RuntimeException re) {}
				catch(Error e) {}
			}
		}
		finally {
			if(exception != null)
				throw exception;
			else
				throw error;
		}
	}

}
