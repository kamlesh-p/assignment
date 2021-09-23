package com.kam.common;

import java.security.SecureRandom;
import java.util.Random;

public class CommonUtils {

	private static final Random random = new SecureRandom();

	private CommonUtils() {
		// No init
	}

	public static String getCardNumber() {
		StringBuilder builder = new StringBuilder();
		builder.append(random.nextInt(100000000));
		builder.append(random.nextInt(100000000));
		return builder.toString();
	}
}
