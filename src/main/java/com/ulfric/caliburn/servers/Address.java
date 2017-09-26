package com.ulfric.caliburn.servers;

import com.ulfric.caliburn.Bean;

public class Address extends Bean {

	private String ipAddress;
	private Integer port;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

}
