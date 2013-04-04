package com.core.buga.data.impl;

import java.lang.reflect.Type;
import java.util.List;

import android.util.Log;

import com.core.buga.data.BugService;
import com.core.buga.data.Connector;
import com.core.buga.data.DataException;
import com.core.buga.data.ServiceFactory;
import com.core.buga.models.Bug;
import com.core.buga.models.BugDetail;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RESTBugService implements BugService {
	
	private final static String URL_ITEMS = "https://api.github.com/repos/taenadar/BugA/issues";

	@Override
	public List<Bug> getAllBugs() throws DataException {
		Type bugsListType = new TypeToken<List<Bug>>(){}.getType();
		Connector connector = ServiceFactory.getConnectorInstance();
		String response = connector.performGetRequest(URL_ITEMS);
		Log.d("getAllBugs", response);
		Gson gson = new Gson();
		return gson.fromJson(response, bugsListType);
	}

	@Override
	public List<Bug> getOpenBugs() throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bug> getClosedBugs() throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bug> getMyBugs() throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BugDetail getBugDetails(String id) throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

}
