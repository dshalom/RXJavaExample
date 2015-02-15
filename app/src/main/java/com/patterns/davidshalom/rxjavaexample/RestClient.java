package com.patterns.davidshalom.rxjavaexample;

import com.squareup.okhttp.OkHttpClient;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by davidshalom on 15/02/15.
 */
public class RestClient {

	private static API REST_CLIENT;
	private static String ROOT =
			"http://api.openweathermap.org/data/2.5";

	static {
		setupRestClient();
	}

	private RestClient() {
	}

	public static API get() {
		return REST_CLIENT;
	}

	private static void setupRestClient() {
		RestAdapter.Builder builder = new RestAdapter.Builder()
				.setEndpoint(ROOT)
				.setClient(new OkClient(new OkHttpClient()))
				.setLogLevel(RestAdapter.LogLevel.FULL);

		RestAdapter restAdapter = builder.build();
		REST_CLIENT = restAdapter.create(API.class);
	}
}

