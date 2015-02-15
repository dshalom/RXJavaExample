package com.patterns.davidshalom.rxjavaexample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;


public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		doStuff1();

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	private void doStuff1() {

		Subscriber<WeatherResponse> mySubscriber = new Subscriber<WeatherResponse>() {
			@Override
			public void onNext(WeatherResponse weatherResponse) {

				Log.e("DSDS", weatherResponse.getBase());
				Log.e("DSDS", weatherResponse.getWeather()[0].getMain());
				Log.e("DSDS", weatherResponse.getWeather()[0].getDescription());

			}

			@Override
			public void onCompleted() {
			}

			@Override
			public void onError(Throwable e) {
			}
		};

		RestClient.get().getWeather("California").map(new Func1<WeatherResponse, WeatherResponse>() {
			@Override
			public WeatherResponse call(WeatherResponse weatherResponse) {
				return weatherResponse;
			}
		}).subscribe(mySubscriber);

	}

	private void doStuff2() {

		Observable<String> myObservable = Observable.create(
				new Observable.OnSubscribe<String>() {
					@Override
					public void call(Subscriber<? super String> sub) {
						sub.onNext("Hello, world!");
						sub.onCompleted();
					}
				}
		).map(new Func1<String, Dog>() {
			@Override
			public Dog call(String s) {
				return new Dog();
			}
		}).map(new Func1<Dog, String>() {
			@Override
			public String call(Dog dog) {
				return "Hello";
			}
		});

		Subscriber<String> mySubscriber = new Subscriber<String>() {
			@Override
			public void onNext(String s) {
				Log.e("DSDS", s);
			}

			@Override
			public void onCompleted() {
			}

			@Override
			public void onError(Throwable e) {
			}
		};

		myObservable.subscribe(mySubscriber);

	}

	class Dog {
		String getNoise() {
			return "bark";
		}

	}


}
