package com.core.buga.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.core.buga.data.BugService;
import com.core.buga.data.DataException;
import com.core.buga.data.ServiceFactory;



public class BugDetailLoader extends AsyncTaskLoader<BugDetailResult>  {

	private String id; 
	private BugDetailResult result;
	
	public BugDetailLoader(Context context, String id) {
		super(context);
		this.id = id;
	}

	@Override
	public BugDetailResult loadInBackground() {
		BugService service = ServiceFactory.getNewsServiceInstance();
		BugDetailResult result = new BugDetailResult();
		try {
			result.setDetailItem(service.getBugDetails(id));
		} catch (DataException exception) {
			result.setException(exception);
		}
		return result;
	}
	

	@Override
	protected void onStartLoading() {
		if (this.result != null) {
			deliverResult(this.result);
		}

		if (takeContentChanged() || this.result == null) {
			forceLoad();
		}

	}

	@Override
	public void deliverResult(BugDetailResult result) {
		if (this.result == null) {
			this.result = result;
		}
		if (isStarted()) {
			super.deliverResult(result);
		}
	}


}
