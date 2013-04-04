package com.core.buga.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.core.buga.data.BugService;
import com.core.buga.data.DataException;
import com.core.buga.data.ServiceFactory;

public class BugLoader extends AsyncTaskLoader<BugResult> {
	private BugResult result;

	public BugLoader(Context context) {
		super(context);
	}

	@Override
	public BugResult loadInBackground() {
		BugService service = ServiceFactory.getNewsServiceInstance();
		BugResult result = new BugResult();
		try {
			result.setItems(service.getAllBugs());
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
	public void deliverResult(BugResult result) {
		if (this.result == null) {
			this.result = result;
		}
		if (isStarted()) {
			super.deliverResult(result);
		}
	}
}
