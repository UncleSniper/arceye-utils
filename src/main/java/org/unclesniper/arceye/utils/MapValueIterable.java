package org.unclesniper.arceye.utils;

import java.util.Map;

public class MapValueIterable<KeyT, ValueT> implements Iterable<ValueT> {

	private Map<KeyT, ValueT> map;

	public MapValueIterable(Map<KeyT, ValueT> map) {
		this.map = map;
	}

	public Map<KeyT, ValueT> getMap() {
		return map;
	}

	public void setMap(Map<KeyT, ValueT> map) {
		this.map = map;
	}

	public MapValueIterator<KeyT, ValueT> iterator() {
		return new MapValueIterator<KeyT, ValueT>(map.entrySet().iterator());
	}

}
