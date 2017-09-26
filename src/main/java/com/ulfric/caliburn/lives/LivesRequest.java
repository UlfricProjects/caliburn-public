package com.ulfric.caliburn.lives;

import com.ulfric.caliburn.HeadersBuilder;
import com.ulfric.caliburn.HttpMethod;
import com.ulfric.caliburn.Request;

public class LivesRequest extends Request {

	private String server;

	public LivesRequest() {
		setHeaders(new HeadersBuilder().endpoint("lives").method(HttpMethod.GET).build());
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

}
