package com.core.buga;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

	public static final String PREFS_LOGIN = "loginPrefs";
	
	private Button loginButton;
	private EditText username;
	private EditText repository;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		
		loginButton = (Button) findViewById(R.id.buttonLogin);
		username = (EditText) findViewById(R.id.editTextUsername);
		repository = (EditText) findViewById(R.id.editTextRepository);
		
		SharedPreferences settings = getSharedPreferences(PREFS_LOGIN, 0);
		username.setText( settings.getString("username", ""));
		repository.setText( settings.getString("repository", ""));
		
		loginButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				saveCredentials();
			}
		});
	}
	
	private void saveCredentials() {
		SharedPreferences settings = getSharedPreferences(PREFS_LOGIN, 0);
		SharedPreferences.Editor editor = settings.edit();
		
		editor.putString("username", username.getText().toString() );
		editor.putString("repository", repository.getText().toString() );
		editor.commit();
		
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
