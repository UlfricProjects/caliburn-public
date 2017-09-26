package com.ulfric.caliburn;

public final class HeadersBuilder extends Bean {

	private String endpoint;
	private HttpMethod method;

	public Headers build() {
		Headers headers = new Headers();
		headers.setEndpoint(endpoint);
		headers.setMethod(method);
		return headers;
	}

	public HeadersBuilder endpoint(String endpoint) {
		this.endpoint = endpoint;
		return this;
	}

	public HeadersBuilder method(HttpMethod method) {
		this.method = method;
		return this;
	}

}
