package com.core.buga.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.core.buga.data.BugService;
import com.core.buga.data.DataException;
import com.core.buga.data.ServiceFactory;

public class BugLoader extends AsyncTaskLoader<BugResult> {
	private BugResult result;
	private int listType = 0;

	public BugLoader(Context context, int listType ) {
		super(context);
		this.listType = listType;
	}

	@Override
	public BugResult loadInBackground() {
		BugService service = ServiceFactory.getNewsServiceInstance();
		BugResult result = new BugResult();
		try {
			switch (listType) {
			case 1:
				result.setItems(service.getAllBugs());
				break;
			case 2:
				result.setItems(service.getMyBugs());
				break;
			case 3:
				result.setItems(service.getOpenBugs());
				break;
			case 4:
				result.setItems(service.getClosedBugs() );
				break;
			default:
				result.setItems(service.getAllBugs());
				break;
			}
			
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
