package com.adventuroo.fithereum.networking;

import android.content.Context;

import java.util.Date;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by jcailteux on 4/1/16.
 */
public class VolleyManager {

	private static RequestQueue requestQueue;

	public static void init(Context context) {
		requestQueue = Volley.newRequestQueue(context);
	}


	public static void getActivityForDate(Date date, String userId){

	}

}
