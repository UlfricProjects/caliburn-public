package com.ulfric.caliburn.servers;

import com.ulfric.caliburn.Response;

public class JoinResponse extends Response {

	private QueuePosition queuePosition;

	public QueuePosition getQueuePosition() {
		return queuePosition;
	}

	public void setQueuePosition(QueuePosition queuePosition) {
		this.queuePosition = queuePosition;
	}

}
