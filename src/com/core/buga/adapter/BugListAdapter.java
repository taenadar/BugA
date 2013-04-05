package com.core.buga.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.core.buga.models.*;
import com.core.buga.R;

public class BugListAdapter extends BaseAdapter implements ListAdapter {

	private List<Bug> bugitems = new ArrayList<Bug>(); 
	private Context context;
	
	public BugListAdapter(final Context context) {
		this.context = context;
	}
	
	public void setList(final List<Bug> bugItems) {
		this.bugitems = bugItems;
		notifyDataSetChanged();
	}
	
	@Override
	public int getCount() {
		if(bugitems != null){
			return bugitems.size();
		}
		
		return 0;
	}

	@Override
	public Object getItem(int position) {
		if(bugitems != null){
			return bugitems.get(position);
		}
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int postion, View convertView, final ViewGroup parent) {
		if(convertView == null){
			convertView = View.inflate(context, R.layout.bug_list_row, null);
		}
		
		TextView title = (TextView) convertView.findViewById(R.id.title);
		TextView status = (TextView) convertView.findViewById(R.id.status);
		TextView body = (TextView) convertView.findViewById(R.id.body);
		
		final Bug bug = (Bug)getItem(postion);
		String bugState  = bug.getState();
		
		if(bugState.equals("open")){
			convertView.setBackgroundColor(Color.rgb(160, 255, 115));
		}else{
			convertView.setBackgroundColor(Color.rgb(255, 60, 60));
		}
		status.setText( bugState );
		title.setText(bug.getTitle());
		body.setText( bug.getBody() );
		
		return convertView;
	}

}
