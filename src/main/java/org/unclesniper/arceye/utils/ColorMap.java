package org.unclesniper.arceye.utils;

public class ColorMap {

	// renditions of high colors as per xterm default
	private static final int[] SPEC256 = new int[] {
		// 0..7
		0x000000, 0xcd0000, 0x00cd00, 0xcdcd00, 0x0000ff, 0xcd00cd, 0xcd00cd, 0xe5e5e5,
		// 8..15
		0x7f7f7f, 0xff0000, 0x00ff00, 0xffff00, 0x5c5cff, 0xff00ff, 0x00ffff, 0xffffff,
		// 16..255, V..ygtpqq..239@q'd from 256colres.h
		0x000000, 0x00005f, 0x000087, 0x0000af, 0x0000d7, 0x0000ff, 0x005f00, 0x005f5f,
		0x005f87, 0x005faf, 0x005fd7, 0x005fff, 0x008700, 0x00875f, 0x008787, 0x0087af,
		0x0087d7, 0x0087ff, 0x00af00, 0x00af5f, 0x00af87, 0x00afaf, 0x00afd7, 0x00afff,
		0x00d700, 0x00d75f, 0x00d787, 0x00d7af, 0x00d7d7, 0x00d7ff, 0x00ff00, 0x00ff5f,
		0x00ff87, 0x00ffaf, 0x00ffd7, 0x00ffff, 0x5f0000, 0x5f005f, 0x5f0087, 0x5f00af,
		0x5f00d7, 0x5f00ff, 0x5f5f00, 0x5f5f5f, 0x5f5f87, 0x5f5faf, 0x5f5fd7, 0x5f5fff,
		0x5f8700, 0x5f875f, 0x5f8787, 0x5f87af, 0x5f87d7, 0x5f87ff, 0x5faf00, 0x5faf5f,
		0x5faf87, 0x5fafaf, 0x5fafd7, 0x5fafff, 0x5fd700, 0x5fd75f, 0x5fd787, 0x5fd7af,
		0x5fd7d7, 0x5fd7ff, 0x5fff00, 0x5fff5f, 0x5fff87, 0x5fffaf, 0x5fffd7, 0x5fffff,
		0x870000, 0x87005f, 0x870087, 0x8700af, 0x8700d7, 0x8700ff, 0x875f00, 0x875f5f,
		0x875f87, 0x875faf, 0x875fd7, 0x875fff, 0x878700, 0x87875f, 0x878787, 0x8787af,
		0x8787d7, 0x8787ff, 0x87af00, 0x87af5f, 0x87af87, 0x87afaf, 0x87afd7, 0x87afff,
		0x87d700, 0x87d75f, 0x87d787, 0x87d7af, 0x87d7d7, 0x87d7ff, 0x87ff00, 0x87ff5f,
		0x87ff87, 0x87ffaf, 0x87ffd7, 0x87ffff, 0xaf0000, 0xaf005f, 0xaf0087, 0xaf00af,
		0xaf00d7, 0xaf00ff, 0xaf5f00, 0xaf5f5f, 0xaf5f87, 0xaf5faf, 0xaf5fd7, 0xaf5fff,
		0xaf8700, 0xaf875f, 0xaf8787, 0xaf87af, 0xaf87d7, 0xaf87ff, 0xafaf00, 0xafaf5f,
		0xafaf87, 0xafafaf, 0xafafd7, 0xafafff, 0xafd700, 0xafd75f, 0xafd787, 0xafd7af,
		0xafd7d7, 0xafd7ff, 0xafff00, 0xafff5f, 0xafff87, 0xafffaf, 0xafffd7, 0xafffff,
		0xd70000, 0xd7005f, 0xd70087, 0xd700af, 0xd700d7, 0xd700ff, 0xd75f00, 0xd75f5f,
		0xd75f87, 0xd75faf, 0xd75fd7, 0xd75fff, 0xd78700, 0xd7875f, 0xd78787, 0xd787af,
		0xd787d7, 0xd787ff, 0xd7af00, 0xd7af5f, 0xd7af87, 0xd7afaf, 0xd7afd7, 0xd7afff,
		0xd7d700, 0xd7d75f, 0xd7d787, 0xd7d7af, 0xd7d7d7, 0xd7d7ff, 0xd7ff00, 0xd7ff5f,
		0xd7ff87, 0xd7ffaf, 0xd7ffd7, 0xd7ffff, 0xff0000, 0xff005f, 0xff0087, 0xff00af,
		0xff00d7, 0xff00ff, 0xff5f00, 0xff5f5f, 0xff5f87, 0xff5faf, 0xff5fd7, 0xff5fff,
		0xff8700, 0xff875f, 0xff8787, 0xff87af, 0xff87d7, 0xff87ff, 0xffaf00, 0xffaf5f,
		0xffaf87, 0xffafaf, 0xffafd7, 0xffafff, 0xffd700, 0xffd75f, 0xffd787, 0xffd7af,
		0xffd7d7, 0xffd7ff, 0xffff00, 0xffff5f, 0xffff87, 0xffffaf, 0xffffd7, 0xffffff,
		0x080808, 0x121212, 0x1c1c1c, 0x262626, 0x303030, 0x3a3a3a, 0x444444, 0x4e4e4e,
		0x585858, 0x626262, 0x6c6c6c, 0x767676, 0x808080, 0x8a8a8a, 0x949494, 0x9e9e9e,
		0xa8a8a8, 0xb2b2b2, 0xbcbcbc, 0xc6c6c6, 0xd0d0d0, 0xdadada, 0xe4e4e4, 0xeeeeee,
	};

	private static final int[] MAP2568 = new int[256];
	private static final int[] MAP25616 = new int[256];

	private static final int[] CONTRAST2568 = new int[256];
	private static final int[] CONTRAST25616 = new int[256];

	static {
		int i;
		double[] triple = new double[3];
		double[][] base = new double[16][];
		for(i = 0; i < 16; ++i) {
			ColorMap.MAP2568[i] = i;
			ColorMap.MAP25616[i] = i;
			base[i] = new double[3];
			ColorMap.rgb2lab(ColorMap.SPEC256[i], base[i]);
		}
		for(i = 0; i < 8; ++i)
			ColorMap.makeContrast(i, base[i], base);
		for(i = 8; i < 256; ++i) {
			ColorMap.rgb2lab(ColorMap.SPEC256[i], triple);
			int bestBase8 = -1, bestBase16 = -1;
			double shortestDistance8 = 0.0, shortestDistance16 = 0.0;
			for(int j = 0; j < 16; ++j) {
				double delta = ColorMap.labDistance(triple, base[j]);
				if(j < 8 && (bestBase8 < 0 || delta < shortestDistance8)) {
					bestBase8 = j;
					shortestDistance8 = delta;
				}
				if(bestBase16 < 0 || delta < shortestDistance16) {
					bestBase16 = j;
					shortestDistance16 = delta;
				}
			}
			ColorMap.MAP2568[i] = bestBase8;
			if(i >= 8)
				ColorMap.MAP25616[i] = bestBase16;
			ColorMap.makeContrast(i, triple, base);
		}
	}

	private static void makeContrast(int index, double[] triple, double[][] base) {
		double dBlack = ColorMap.labDistance(triple, base[0]);
		double dWhite = ColorMap.labDistance(triple, base[7]);
		ColorMap.CONTRAST2568[index] = dBlack < dWhite ? 0 : 7;
		dWhite = ColorMap.labDistance(triple, base[15]);
		ColorMap.CONTRAST25616[index] = dBlack < dWhite ? 0 : 15;
	}

	public static int highColorTo8Color(int color) {
		return ColorMap.MAP2568[color];
	}

	public static int highColorTo16Color(int color) {
		return ColorMap.MAP25616[color];
	}

	public static int contrast8To(int color) {
		return ColorMap.CONTRAST2568[color];
	}

	public static int contrast16To(int color) {
		return ColorMap.CONTRAST25616[color];
	}

	private static void rgb2xyz(double r, double g, double b, double[] xyz) {
		// Thank you, http://www.easyrgb.com/index.php?X=MATH&H=02#text2
		r = ColorMap.rgb2xyz_sanitize(r) * 100.0;
		g = ColorMap.rgb2xyz_sanitize(g) * 100.0;
		b = ColorMap.rgb2xyz_sanitize(b) * 100.0;
		xyz[0] = r * 0.4124 + g * 0.3576 + b * 0.1805;
		xyz[1] = r * 0.2126 + g * 0.7152 + b * 0.0722;
		xyz[2] = r * 0.0193 + g * 0.1192 + b * 0.9505;
	}

	private static double rgb2xyz_sanitize(double rgb) {
		if(rgb > 0.04045)
			return Math.pow((rgb + 0.055) / 1.055, 2.4);
		else
			return rgb / 12.92;
	}

	private static void xyz2lab(double x, double y, double z, double[] lab) {
		// Thank you, http://www.easyrgb.com/index.php?X=MATH&H=07#text7
		x = ColorMap.xyz2lab_sanitize(x / 95.047);
		y = ColorMap.xyz2lab_sanitize(y / 100.0);
		z = ColorMap.xyz2lab_sanitize(z / 108.883);
		lab[0] = 116.0 * y - 16.0;
		lab[1] = 500.0 * (x - y);
		lab[2] = 200.0 * (y - z);
	}

	private static double xyz2lab_sanitize(double xyz) {
		if(xyz > 0.008856)
			return Math.pow(xyz, 1.0 / 3.0);
		else
			return 7.787 * xyz + 16.0 / 116.0;
	}

	private static void rgb2lab(int rgb, double[] lab) {
		double r = (double)((rgb & 0xFF0000) >> 16) / 255.0;
		double g = (double)((rgb & 0x00FF00) >> 8) / 255.0;
		double b = (double)(rgb & 0x0000FF) / 255.0;
		ColorMap.rgb2xyz(r, g, b, lab);
		ColorMap.xyz2lab(lab[0], lab[1], lab[2], lab);
	}

	private static double labDistance(double[] a, double[] b) {
		double dL = a[0] - b[0];
		double da = a[1] - b[1];
		double db = a[2] - b[2];
		return Math.sqrt(dL * dL + da * da + db * db);
	}

}
