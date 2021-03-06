package com.adventuroo.fithereum.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Map;

import com.adventuroo.fithereum.util.FitbitHelper;
import com.adventuroo.fithereum.R;
import com.adventuroo.fithereum.util.UriHelper;

/**
 * Created by jcailteux on 4/1/16.
 */
public class LoginActivity extends AppCompatActivity {

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.a_splash);
	}

	public void loginWithFitbit(View v) {
		CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
		builder.setToolbarColor(0);
		builder.enableUrlBarHiding();
		CustomTabsIntent intent = builder.build();
		intent.intent.setPackage("com.android.chrome");
		intent.intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);

		intent.launchUrl(this, UriHelper.buildURI());

	}


	@Override
	public void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		Map<String, String> params = UriHelper.getParams(intent.getData());
		FitbitHelper.setUserId(params.get("user_id"));
		FitbitHelper.setAccessToken(params.get("access_token"));
		if (FitbitHelper.haveValidFitbitCredentials()) {
			startActivity(new Intent(this, MainActivity.class));
		}

	}
}
