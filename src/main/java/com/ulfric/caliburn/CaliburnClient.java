package com.ulfric.caliburn;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

public class CaliburnClient {

	private static final MediaType JSON = MediaType.parse("application/json");

	public static CaliburnClient defaultsWithSecret(String secret) {
		return builder().secret(secret).build();
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String scheme = "https";
		private String host = "api.caliburn.io";
		private String secret;
		private OkHttpClient httpClient;

		Builder() {
		}

		public CaliburnClient build() {
			Objects.requireNonNull(scheme, "scheme");
			Objects.requireNonNull(host, "host");
			Objects.requireNonNull(secret, "secret");

			OkHttpClient httpClient = this.httpClient;
			if (httpClient == null) {
				httpClient = new OkHttpClient();
			}

			return new CaliburnClient(scheme, host, secret, httpClient);
		}

		public Builder scheme(String scheme) {
			this.scheme = scheme;
			return this;
		}

		public Builder host(String host) {
			this.host = host;
			return this;
		}

		public Builder secret(String secret) {
			this.secret = secret;
			return this;
		}

		public Builder httpClient(OkHttpClient httpClient) {
			this.httpClient = httpClient;
			return this;
		}
	}

	protected final String scheme;
	protected final String host;
	protected final String secret;
	protected final OkHttpClient httpClient;

	protected CaliburnClient(String scheme, String host, String secret, OkHttpClient httpClient) {
		this.scheme = scheme;
		this.host = host;
		this.secret = secret;
		this.httpClient = httpClient;
	}

	public <T extends Response> T send(Request request, Class<T> response) {
		validate(request);

		okhttp3.Request.Builder builder = new okhttp3.Request.Builder()
				.addHeader("CALIBURN-SECRET", secret)
				.url(url(request));

		HttpMethod method = request.getHeaders().getMethod();
		if (method == HttpMethod.POST) {
			RequestBody body = body(request);
			builder = builder.post(body);
		} else if (method == HttpMethod.GET) {
			builder = builder.get();
		}

		return call(builder.build(), response);
	}

	private void validate(Request request) {
		Objects.requireNonNull(request, "request");

		Headers headers = request.getHeaders();
		Objects.requireNonNull(headers, "request.headers");
		Objects.requireNonNull(headers.getEndpoint(), "request.headers.endpoint");
		Objects.requireNonNull(headers.getMethod(), "request.headers.method");
	}

	private HttpUrl url(Request request) {
		HttpUrl.Builder builder = new HttpUrl.Builder();
		builder.scheme(scheme);
		builder.host(host);

		Headers headers = request.getHeaders();
		builder.addPathSegment(headers.getEndpoint());

		if (headers.getMethod() == HttpMethod.GET) {
			parameters(request).forEach(builder::addQueryParameter);
		}

		return builder.build();
	}

	private Map<String, String> parameters(Request request) {
		return withoutHeaders(request, value ->
			value.transform(TypeToken.getParameterized(Map.class, String.class, String.class).getType()));
	}

	private RequestBody body(Request request) {
		return withoutHeaders(request, value -> RequestBody.create(JSON, value.toJson()));
	}

	private <T> T withoutHeaders(Request request, Function<Request, T> function) {
		Headers oldHeaders = request.getHeaders();
		request.setHeaders(null);

		try {
			return function.apply(request);
		} finally {
			request.setHeaders(oldHeaders);
		}
	}

	private <T> T call(okhttp3.Request request, Class<T> response) {
		try {
			okhttp3.Response okResponse = httpClient.newCall(request).execute();
			return Bean.GSON.fromJson(okResponse.body().string(), response);
		} catch (IOException exception) {
			throw new UncheckedIOException(exception);
		}
	}

}
