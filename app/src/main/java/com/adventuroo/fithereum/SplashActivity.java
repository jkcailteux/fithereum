package com.adventuroo.fithereum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jcailteux on 4/1/16.
 */
public class SplashActivity extends AppCompatActivity {


	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.a_splash);


		startActivity(new Intent(this, LoginActivity.class));

	}
}
