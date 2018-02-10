package org.unclesniper.arceye.utils;

public class TextFormatting {

	private TextFormatting() {}

	public static String pad(String value, int width, char padding) {
		int length = value.length();
		if(length >= width)
			return value;
		StringBuilder build = new StringBuilder();
		for(; length < width; ++length)
			build.append(padding);
		build.append(value);
		return build.toString();
	}

}
