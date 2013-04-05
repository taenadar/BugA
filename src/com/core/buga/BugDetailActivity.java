package com.core.buga;

import org.w3c.dom.Text;

import com.core.buga.adapter.BugListAdapter;
import com.core.buga.loader.BugLoader;
import com.core.buga.loader.BugResult;
import com.core.buga.models.Bug;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BugDetailActivity extends FragmentActivity implements LoaderCallbacks<BugResult> {
	
	private String bugId;
	private Context context = this;
	private BugListAdapter adapter;
	private TextView title;
	private TextView state;
	private TextView body;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bug_detail);
		
		title = (TextView) findViewById(R.id.title);
		state = (TextView) findViewById(R.id.state);
		body = (TextView) findViewById(R.id.body);
		
		bugId = getIntent().getStringExtra("itemId");
		getSupportLoaderManager().initLoader( 0, null, this);
	}
	
	@Override
	public Loader<BugResult> onCreateLoader(int id, Bundle args) {
		return new BugLoader(getApplicationContext(), id);
	}
	
	@Override
	public void onLoadFinished(Loader<BugResult> loader, BugResult result) {
		if(result.getException() == null) {
			
			final Bug bug = (Bug)adapter.getItem(bugId.toString());
			state.setText( bug.getState() );
			title.setText(bug.getTitle());
			body.setText( bug.getBody() );
			
		} else {
			Toast.makeText(context, result.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onLoaderReset(Loader<BugResult> arg0) {
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bug_detail, menu);
		Button editIssueBtn = (Button) findViewById(R.id.button_close_bug);
		editIssueBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				
			}
		});
		return true;
	}
}
