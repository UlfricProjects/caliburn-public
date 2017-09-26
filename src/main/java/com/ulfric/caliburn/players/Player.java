package com.ulfric.caliburn.players;

import com.ulfric.caliburn.Bean;
import com.ulfric.caliburn.servers.Server;

import java.util.UUID;

public class Player extends Bean {

	private UUID uniqueId;
	private String name;
	private String nickname;
	private Server online;

	public UUID getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(UUID uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Server getOnline() {
		return online;
	}

	public void setOnline(Server online) {
		this.online = online;
	}

}
