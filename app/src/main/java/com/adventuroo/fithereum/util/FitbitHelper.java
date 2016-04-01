package com.adventuroo.fithereum.util;

/**
 * Created by jcailteux on 4/1/16.
 */
public class FitbitHelper {


	private static String accessToken = null;
	private static String userId = null;

	public static String getAccessToken() {
		return accessToken;
	}

	public static void setAccessToken(String accessToken) {
		FitbitHelper.accessToken = accessToken;
	}

	public static String getUserId() {
		return userId;
	}

	public static void setUserId(String userId) {
		FitbitHelper.userId = userId;
	}

	public static boolean haveValidFitbitCredentials() {
		return accessToken != null && userId != null;
	}

}
