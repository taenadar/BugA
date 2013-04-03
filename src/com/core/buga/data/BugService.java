package com.core.buga.data;

import java.util.List;

import com.core.buga.models.Bug;
import com.core.buga.models.BugDetail;

public interface BugService {

	List<Bug> getAllBugs() throws DataException;
	List<Bug> getOpenBugs() throws DataException;
	List<Bug> getClosedBugs() throws DataException;
	List<Bug> getMyBugs() throws DataException;
	BugDetail getBugDetails( String id ) throws DataException;
	
}
