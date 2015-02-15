package com.patterns.davidshalom.rxjavaexample;

/**
 * Created by davidshalom on 15/02/15.
 */
public class WeatherResponse {
	private int cod;
	private String base;
	private Weather[] weather;

	public WeatherResponse() {
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Weather[] getWeather() {
		return weather;
	}

	public void setWeather(Weather[] weather) {
		this.weather = weather;
	}
}
