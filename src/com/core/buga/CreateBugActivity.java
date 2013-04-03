package com.core.buga;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.gsm.SmsMessage.SubmitPdu;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateBugActivity extends Activity implements android.view.View.OnClickListener  {
	
	private EditText bugTitle;
	private EditText bugDescription;
	private EditText projectTitle;
	private Button	 submitBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_bug);
		
		bugTitle = (EditText) findViewById(R.id.edit_text_title);
		bugDescription = (EditText) findViewById(R.id.edittext_bugdescription);
		projectTitle = (EditText) findViewById(R.id.edit_text_project_title);
		submitBtn = (Button) findViewById(R.id.button_bugsubmit);
		
		submitBtn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_bug, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if(v.equals(submitBtn)){
			if(bugTitle.getText().toString().length() > 0 &&
				bugDescription.getText().toString().length() > 0 &&
				projectTitle.getText().toString().length() > 0
				){
				//save content
			}else{
				Toast.makeText(this, R.string.bugform_fail, Toast.LENGTH_LONG).show();
			}
		}
		
	}
}
