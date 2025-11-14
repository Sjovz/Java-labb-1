package com.example.helloworld;

import android.os.Bundle;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "SMHI";
    /*
     *   declare the references to view references here.
     */

    // do the findViewById here to initalize the things above...
    private void initializeViews() {

    }

    // set the fields using the references
    private void updateWeatherData(WeatherData data) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeViews();
        setContentView(R.layout.activity_main);
        new Thread(() -> {
            // TODO: implement geolocating class to get the propper url later
            String urlString = "https://opendata-download-metobs.smhi.se/api/version/latest/parameter/1/station/127310/period/latest-day/data.xml";
            String data = XmlFetcher.getXml(urlString);
            WeatherData weatherData = SimpleParser.parseXml(data);
            updateWeatherData(weatherData);
        }).start();
    }
}

