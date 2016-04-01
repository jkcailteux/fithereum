package com.adventuroo.fithereum.util;

/**
 * Created by jcailteux on 4/1/16.
 */
public class FitbitHelper {

	public static final String clientId = "227PXG";
	public static final String clientSecret = "35b025b3dd3e979daa5dc3e1e2e6b26b";

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
