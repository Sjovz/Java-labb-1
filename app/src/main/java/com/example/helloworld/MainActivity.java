package com.example.helloworld;

import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "SMHI";
    /*
     *   declare the references to view references here.
     */
    private TextView textViewRain;
    private TextView textViewWind;
    private TextView textViewTemp;
    private TextView textViewHumidity;


    // do the findViewById here to initalize the things above...

    /**
     * Initializes all view referencess by linking them to the XML parts
     */
    private void initializeViews()
    {
        textViewRain = findViewById(R.id.textViewRain);
        textViewWind = findViewById(R.id.textViewWind);
        textViewTemp = findViewById(R.id.textViewTemp);
        textViewHumidity = findViewById(R.id.textViewHumidity);
    }

    // set the fields using the references

    /**
     * Updates the UI with data from SMHI
     * @param data the weather data to display
     */
    private void updateWeatherData(WeatherData data)
    {
        runOnUiThread(() -> {
            if(data != null)
            {
                textViewRain.setText(data.getRainfall().toString());
                textViewWind.setText(data.getWindSpeed().toString());
                textViewTemp.setText(Double.toString(data.getTempurature()));
                textViewHumidity.setText(data.getHumidity());
            }else{
                Log.e(TAG, "error");
            }

        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        new Thread(() -> {
            // TODO: implement geolocating class to get the propper url later
            String urlString = "https://opendata-download-metobs.smhi.se/api/version/latest/parameter/1/station/127310/period/latest-day/data.xml";
            String data = XmlFetcher.getXml(urlString);
            WeatherData weatherData = SimpleParser.parseXml(data);
            updateWeatherData(weatherData);
        }).start();
    }
}

