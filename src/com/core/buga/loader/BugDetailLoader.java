package com.core.buga.loader;

import com.core.buga.data.BugService;
import com.core.buga.data.DataException;
import com.core.buga.data.ServiceFactory;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;



public class BugDetailLoader extends AsyncTaskLoader<BugDetailResult>  {

	private String id; 
	
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

}
