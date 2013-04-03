package com.core.buga;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.core.buga.models.Bug;

public class CreateBugActivity extends Activity implements android.view.View.OnClickListener  {
	
	private EditText bugTitle;
	private EditText bugDescription;
	private EditText projectTitle;
	private Button	 submitBtn;
	private RatingBar priorityRatingBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_bug);
		
		bugTitle = (EditText) findViewById(R.id.edit_text_title);
		bugDescription = (EditText) findViewById(R.id.edittext_bugdescription);
		projectTitle = (EditText) findViewById(R.id.edit_text_project_title);
		submitBtn = (Button) findViewById(R.id.button_bugsubmit);
		priorityRatingBar = (RatingBar) findViewById(R.id.ratingBar_priority);
		
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
					Bug bug = new Bug();
					bug.setTitle( bugTitle.getText().toString() );
					bug.setDescription( bugDescription.getText().toString() );
					bug.setProjectName( projectTitle.getText().toString() );
					bug.setRating( (int) priorityRatingBar.getRating() );
			}else{
				Toast.makeText(this, R.string.bugform_fail, Toast.LENGTH_LONG).show();
			}
		}
		
	}
}
