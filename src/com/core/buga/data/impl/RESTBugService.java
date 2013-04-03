package com.core.buga.data.impl;

import java.util.List;

import com.core.buga.data.BugService;
import com.core.buga.data.DataException;
import com.core.buga.models.Bug;
import com.core.buga.models.BugDetail;

public class RESTBugService implements BugService {
	
	private final static String URL_ITEMS = "https://api.github.com/repos/taenadar/BugA/issues";

	@Override
	public List<Bug> getAllBugs() throws DataException {
		// TODO Auto-generated method stub
		return null;
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
