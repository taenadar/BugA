package com.core.buga;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.core.buga.loader.BugDetailLoader;
import com.core.buga.loader.BugDetailResult;
import com.core.buga.models.BugDetail;

public class BugDetailActivity extends FragmentActivity implements LoaderCallbacks<BugDetailResult> {
	
	private String bugId;
	private Context context = this;
	private BugDetail bugDetail;
	private TextView title;
	private TextView state;
	private TextView body;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bug_detail);
		
		title = (TextView) findViewById(R.id.detail_title);
		state = (TextView) findViewById(R.id.detail_state);
		body = (TextView) findViewById(R.id.detail_body);
		
		bugId = getIntent().getStringExtra("itemId");
		getSupportLoaderManager().initLoader( 0, null, this);
	}
	
	@Override
	public Loader<BugDetailResult> onCreateLoader(int id, Bundle args) {
		return new BugDetailLoader(getApplicationContext(), bugId);
	}
	
	@Override
	public void onLoadFinished(Loader<BugDetailResult> loader, BugDetailResult result) {
		if(result.getException() == null) {
			this.bugDetail = result.getDetailItem();
			state.setText( bugDetail.getState() );
			title.setText(bugDetail.getTitle());
			body.setText( bugDetail.getBody() );
		} else {
			Toast.makeText(context, result.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onLoaderReset(Loader<BugDetailResult> arg0) {
		
	}
}
