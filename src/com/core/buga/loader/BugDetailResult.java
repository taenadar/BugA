package com.core.buga.loader;

import com.core.buga.data.DataException;
import com.core.buga.models.BugDetail;


public class BugDetailResult {
	private DataException exception;
	private BugDetail detailItem;

	public DataException getException() {
		return exception;
	}

	public void setException(DataException exception) {
		this.exception = exception;
	}

	public BugDetail getDetailItem() {
		return detailItem;
	}

	public void setDetailItem(BugDetail detailItem) {
		this.detailItem = detailItem;
	}
}
