package com.adventuroo.fithereum;

import android.net.Uri;

/**
 * Created by jcailteux on 4/1/16.
 */
public class UriBuilder {

	public static Uri buildURI() {
		Uri.Builder builder = Uri.parse("https://www.fitbit.com/oauth2/authorize").buildUpon();
		builder.appendQueryParameter("client_id", "227PXG");
		builder.appendQueryParameter("response_type", "token");
		builder.appendQueryParameter("scope", "activity");
		builder.appendQueryParameter("redirect_uri", "fithereum://app/authorize");
		builder.appendQueryParameter("expires_in", "2592000");
		builder.appendQueryParameter("prompt","login");
		return builder.build();
	}
}
