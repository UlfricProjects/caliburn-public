package com.ulfric.caliburn.servers;

import com.ulfric.caliburn.Response;

import java.util.List;
import java.util.Map;

public class ServersResponse extends Response {

	private Map<String, List<Server>> servers;

	/**
	 * Map of server game type to servers
	 *
	 * @return
	 */
	public Map<String, List<Server>> getServers() {
		return servers;
	}

	public void setServers(Map<String, List<Server>> servers) {
		this.servers = servers;
	}

}
