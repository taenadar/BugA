package com.core.buga.loader;

import java.util.List;

import com.core.buga.data.DataException;
import com.core.buga.models.Bug;

public class BugResult {
	
	private DataException exception;
	private List<Bug> items;

	public DataException getException() {
		return exception;
	}

	public void setException(DataException exception) {
		this.exception = exception;
	}

	public String getTitle(){
		return items.get(location)
	}
	
	public List<Bug> getItems() {
		return items;

	}

	public void setItems(List<Bug> items) {
		this.items = items;
	}

}
