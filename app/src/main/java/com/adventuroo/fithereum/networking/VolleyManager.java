package com.adventuroo.fithereum.networking;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.adventuroo.fithereum.util.FitbitHelper;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

/**
 * Created by jcailteux on 4/1/16.
 */
public class VolleyManager {

	private static RequestQueue requestQueue;
	private static Map<String, String> headers;
	private static final Integer timeout = 10000;

	public static void init(Context context) {
		requestQueue = Volley.newRequestQueue(context);
	}


	public static void getActivityForDate(Date date, String userId, Response.Listener<JsonObject> listener, Response.ErrorListener errorListener) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String url = "https://api.fitbit.com/1/user/";
		url += userId;
		url += "/activities/date/" + dateFormat.format(date);
		url += ".json";

		GsonRequest<JsonObject> request = new GsonRequest<>(Request.Method.GET, url, JsonObject.class, getHeaders(), listener, errorListener, timeout);
		requestQueue.add(request);
		requestQueue.start();

	}

	private static Map<String, String> getHeaders() {
		if (headers == null) {
			headers = new HashMap<>();
			headers.put("Content-Type", "application/json; charset=utf-8;");
			headers.put("Accept-Language", "en_US");
			headers.put("Authorization", "Bearer " + FitbitHelper.getAccessToken());
		}
		return headers;
	}

}
