package com.ulfric.caliburn.players;

import com.ulfric.caliburn.HeadersBuilder;
import com.ulfric.caliburn.HttpMethod;
import com.ulfric.caliburn.Request;

import java.util.UUID;

public class FindRequest extends Request {

	private UUID player;

	public FindRequest() {
		setHeaders(new HeadersBuilder().endpoint("find").method(HttpMethod.GET).build());
	}

	public UUID getPlayer() {
		return player;
	}

	/**
	 * The player to find. If null, this will be the player linked to the api key.
	 * If using the player linked to the api key, this will search for the player
	 * even if they are offline - otherwise the request will return the sender
	 * with the online (Server) attribute set to null.
	 *
	 * @param player
	 */
	public void setPlayer(UUID player) {
		this.player = player;
	}

}
