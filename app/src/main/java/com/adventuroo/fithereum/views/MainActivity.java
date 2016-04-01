package com.adventuroo.fithereum.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.adventuroo.fithereum.R;

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
	}
}
