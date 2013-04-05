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
	
	private final static String URL_OPEN_ITEMS = "https://api.github.com/repos/taenadar/BugA/issues?state=open";
	private final static String URL_CLOSED_ITEMS = "https://api.github.com/repos/taenadar/BugA/issues?state=closed";
	private final static String URL_MY_ITEMS = "https://api.github.com/repos/taenadar/BugA/issues?assignee=rickvschalkwijk";
	private final static String URL_ONE_ITEM = "https://api.github.com/repos/taenadar/BugA/issues/";

	@Override
	public List<Bug> getAllBugs() throws DataException {
		Type bugsListType = new TypeToken<List<Bug>>(){}.getType();
		Connector connector = ServiceFactory.getConnectorInstance();
		String responseOpen = connector.performGetRequest(URL_OPEN_ITEMS);
		Gson gson = new Gson();
		List<Bug> tempList = gson.fromJson(responseOpen, bugsListType);
		String reponseClosed = connector.performGetRequest(URL_CLOSED_ITEMS);
		List<Bug> tempList2 = gson.fromJson(reponseClosed, bugsListType );
		tempList.addAll( tempList2 );
		return tempList;
	}

	@Override
	public List<Bug> getOpenBugs() throws DataException {
		Type bugsListType = new TypeToken<List<Bug>>(){}.getType();
		Connector connector = ServiceFactory.getConnectorInstance();
		String response = connector.performGetRequest(URL_OPEN_ITEMS);
		Gson gson = new Gson();
		return gson.fromJson(response, bugsListType);
	}

	@Override
	public List<Bug> getClosedBugs() throws DataException {
		Type bugsListType = new TypeToken<List<Bug>>(){}.getType();
		Connector connector = ServiceFactory.getConnectorInstance();
		String response = connector.performGetRequest(URL_CLOSED_ITEMS);
		Gson gson = new Gson();
		return gson.fromJson(response, bugsListType);
	}

	@Override
	public List<Bug> getMyBugs() throws DataException {
		Type bugsListType = new TypeToken<List<Bug>>(){}.getType();
		Connector connector = ServiceFactory.getConnectorInstance();
		String response = connector.performGetRequest(URL_MY_ITEMS);
		Gson gson = new Gson();
		return gson.fromJson(response, bugsListType);
	}

	@Override
	public BugDetail getBugDetails(String id) throws DataException {
		Connector connector = ServiceFactory.getConnectorInstance();
		String response = connector.performGetRequest(URL_ONE_ITEM + id);
		Gson gson = new Gson();
		return gson.fromJson(response, BugDetail.class);
	}

}
