package com.adventuroo.fithereum.util;

import android.net.Uri;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
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
		builder.appendQueryParameter("prompt","login");
		return builder.build();
	}

	public static Map<String, String> splitQuery(URL url) throws UnsupportedEncodingException {
		Map<String, String> query_pairs = new LinkedHashMap<String, String>();
		String query = url.getQuery();
		String[] pairs = query.split("&");
		for (String pair : pairs) {
			int idx = pair.indexOf("=");
			query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
		}
		return query_pairs;
	}
}
