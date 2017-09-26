package com.ulfric.caliburn.servers;

import com.ulfric.caliburn.Bean;

public class Server extends Bean {

	private String name;
	private String region;
	private Address directConnect;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Address getDirectConnect() {
		return directConnect;
	}

	public void setDirectConnect(Address directConnect) {
		this.directConnect = directConnect;
	}

}
