package org.unclesniper.arceye.utils;

public class NumberFormatting {

	private NumberFormatting() {}

	public static String pad(int value, int width, char padding) {
		String digits = String.valueOf(value);
		int length = digits.length();
		if(length >= width)
			return digits;
		StringBuilder build = new StringBuilder();
		for(; length < width; ++length)
			build.append(padding);
		build.append(digits);
		return build.toString();
	}

	public static String zpad(int value, int width) {
		return NumberFormatting.pad(value, width, '0');
	}

}
