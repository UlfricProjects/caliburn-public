package com.ulfric.caliburn.lives;

import com.ulfric.caliburn.HeadersBuilder;
import com.ulfric.caliburn.HttpMethod;
import com.ulfric.caliburn.Request;

import java.util.UUID;

public class UseLifeRequest extends Request {

	private UUID player;
	private String server;

	public UseLifeRequest() {
		setHeaders(new HeadersBuilder().endpoint("useLife").method(HttpMethod.POST).build());
	}

	public UUID getPlayer() {
		return player;
	}

	public void setPlayer(UUID player) {
		this.player = player;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

}
