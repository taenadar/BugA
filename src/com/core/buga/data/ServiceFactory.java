package com.core.buga.data;

import com.core.buga.data.impl.HTTPConnector;
import com.core.buga.data.impl.RESTBugService;

public class ServiceFactory {
	private static final Connector connector = new HTTPConnector();
	private static final BugService bugService = new RESTBugService();

	public static Connector getConnectorInstance() {
		return connector;
	}

	public static BugService getNewsServiceInstance() {
		return bugService;
	}
}
