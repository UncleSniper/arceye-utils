package org.unclesniper.arceye.utils;

public abstract class ConsumableEvent {

	private boolean consumed;

	public ConsumableEvent() {}

	public void consume() {
		consumed = true;
	}

	public void unconsume() {
		consumed = false;
	}

	public boolean isConsumed() {
		return consumed;
	}

}
