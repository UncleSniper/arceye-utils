package org.unclesniper.arceye.utils;

public interface EventFireClosure<ListenerT, EventT> {

	void fireEventForListener(ListenerT listener, EventT event);

}
