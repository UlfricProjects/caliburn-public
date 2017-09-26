package com.ulfric.caliburn.servers;

import com.ulfric.caliburn.HeadersBuilder;
import com.ulfric.caliburn.HttpMethod;
import com.ulfric.caliburn.Request;

/**
 * Teleports the user linked to your api key to the requested server.
 * The user must be on the network already.
 *
 * @author adam
 */
public class JoinRequest extends Request {

	private String server;

	public JoinRequest() {
		setHeaders(new HeadersBuilder().endpoint("join").method(HttpMethod.POST).build());
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

}
