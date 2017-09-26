package com.ulfric.caliburn.servers;

import com.ulfric.caliburn.HeadersBuilder;
import com.ulfric.caliburn.HttpMethod;
import com.ulfric.caliburn.Request;

public class ServersRequest extends Request {

	private String game;

	public ServersRequest() {
		setHeaders(new HeadersBuilder().endpoint("/servers").method(HttpMethod.GET).build());
	}

	public String getGame() {
		return game;
	}

	/**
	 * The game for which to perform a servers lookup.
	 * Not required. Examples: hub, hcf, uhc
	 *
	 * @param game
	 */
	public void setGame(String game) {
		this.game = game;
	}

}
