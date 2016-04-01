package com.adventuroo.fithereum.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Date;

import com.adventuroo.fithereum.util.FitbitHelper;
import com.adventuroo.fithereum.R;
import com.adventuroo.fithereum.networking.VolleyManager;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.JsonObject;

/**
 * Created by jcailteux on 4/1/16.
 */
public class MainActivity extends AppCompatActivity {

	private TextView mainTV;

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.a_main);
		mainTV = (TextView) findViewById(R.id.main_text);
		VolleyManager.init(this);

		VolleyManager.getActivityForDate(new Date(), FitbitHelper.getUserId(), new Response.Listener<JsonObject>() {
			@Override
			public void onResponse(JsonObject response) {
				mainTV.setText(response.toString());
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				error.printStackTrace();
			}
		});


	}
}
