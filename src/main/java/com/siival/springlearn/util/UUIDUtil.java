package com.siival.springlearn.util;

import java.util.UUID;

public class UUIDUtil {

	public static String getRandomUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
