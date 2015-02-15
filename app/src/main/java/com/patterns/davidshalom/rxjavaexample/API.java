package com.patterns.davidshalom.rxjavaexample;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by davidshalom on 15/02/15.
 */
public interface API {
	@GET("/weather")
	Observable<WeatherResponse> getWeather(@Query("q") String cityName);

}

