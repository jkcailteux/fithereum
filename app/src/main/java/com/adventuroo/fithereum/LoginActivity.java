package com.adventuroo.fithereum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by jcailteux on 4/1/16.
 */
public class LoginActivity extends AppCompatActivity {

	private static final int LOGINCODE = 1042;

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.a_splash);
	}

	public void loginWithFitbit(View v) {
		Intent intent = new Intent(Intent.ACTION_VIEW, UriBuilder.buildURI());
		Bundle bundle = new Bundle();
		bundle.putBinder("android.support.customtabs.extra.SESSION", null);
		bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", 0);
		intent.putExtras(bundle);

		startActivityForResult(intent, LOGINCODE);

	}


	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);

		if (LOGINCODE == requestCode) {

		}

	}

	@Override
	public void onNewIntent(Intent intent){
		super.onNewIntent(intent);


	}

}
