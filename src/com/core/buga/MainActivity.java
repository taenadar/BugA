package com.core.buga;

import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.core.buga.adapter.BugListAdapter;
import com.core.buga.loader.BugLoader;
import com.core.buga.loader.BugResult;
import com.core.buga.models.Bug;

public class MainActivity extends FragmentActivity implements
		ActionBar.TabListener {

	SectionsPagerAdapter mSectionsPagerAdapter;
	final Context context = this;

	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_createbug:
			Intent createBugIntent = new Intent(this, CreateBugActivity.class);
			this.startActivity(createBugIntent);
			return true;
		case R.id.action_help:
			Intent helpIntent = new Intent(this, HelpActivity.class);
			this.startActivity(helpIntent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment = new BugSectionFramgent();
			Bundle args = new Bundle();
			args.putInt(BugSectionFramgent.ARG_SECTION_NUMBER, position + 1);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			return 4;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			case 3:
				return getString(R.string.title_section4).toUpperCase(l);
			}
			return null;
		}
	}

	@SuppressLint("ValidFragment")
	public class BugSectionFramgent extends Fragment implements
			LoaderCallbacks<BugResult>, OnItemClickListener {

		private BugListAdapter adapter;
		public TextView title;
		public static final String ARG_SECTION_NUMBER = "section_number";
		public View rootView;

		public BugSectionFramgent() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			rootView = inflater.inflate(R.layout.list_bugs, container, false);

			title = (TextView) findViewById(R.id.title);

			adapter = new BugListAdapter(context);
			ListView listView = (ListView) rootView.findViewById(R.id.listBugs);
			listView.setOnItemClickListener(this);
			listView.setAdapter(adapter);

			getLoaderManager().initLoader(
					getArguments().getInt(ARG_SECTION_NUMBER), null, this);
			return rootView;
		}

		@Override
		public Loader<BugResult> onCreateLoader(int id, Bundle args) {
			return new BugLoader(getApplicationContext(), id);
		}

		@Override
		public void onLoadFinished(Loader<BugResult> loader, BugResult result) {
			if (result.getException() == null) {
				adapter.setList(result.getItems());
			} else {
				Toast.makeText(context,
						result.getException().getLocalizedMessage(),
						Toast.LENGTH_SHORT).show();
			}
		}

		@Override
		public void onLoaderReset(Loader<BugResult> arg0) {

		}

		@Override
		public void onItemClick(AdapterView<?> AdapterView, View clickedView,
				int position, long id) {

			final Bug bug = (Bug) adapter.getItem(position);
			Intent intent = new Intent(context, BugDetailActivity.class);

			intent.putExtra("itemId", bug.getNumber());
			startActivity(intent);
		}
	}
}
