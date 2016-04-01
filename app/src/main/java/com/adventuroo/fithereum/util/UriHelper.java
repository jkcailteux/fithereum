package com.adventuroo.fithereum.util;

import android.net.Uri;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jcailteux on 4/1/16.
 */
public class UriHelper {

	public static Uri buildURI() {
		Uri.Builder builder = Uri.parse("https://www.fitbit.com/oauth2/authorize").buildUpon();
		builder.appendQueryParameter("client_id", "227PXG");
		builder.appendQueryParameter("response_type", "token");
		builder.appendQueryParameter("scope", "activity");
		builder.appendQueryParameter("redirect_uri", "fithereum://app/auth_callback/login/fitbit");
		builder.appendQueryParameter("expires_in", "2592000");
		builder.appendQueryParameter("prompt", "login");
		return builder.build();
	}

	public static Map<String, String> getParams(Uri uri) {
		Map<String, String> map = new HashMap<>();
		String all = uri.toString();
		all = all.split("#")[1];

		String[] params = all.split("&");
		for(String s:params){
			map.put(s.split("=")[0],s.split("=")[1]);
		}
		return map;
	}

}
