package com.example.helloworld;

import android.os.Bundle;

import android.util.Log;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class MainActivity extends AppCompatActivity {
    private static final String TAG = "SMHI";
    private String fetchSmhiXml() {
            try {
                String urlString = "https://opendata-download-metobs.smhi.se/api/version/latest/parameter/1/station/127310/period/latest-day/data.xml";

                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuilder xml = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    xml.append(line).append("\n");
                }

                reader.close();
                conn.disconnect();

                return xml.toString();
            } catch (Exception e) {
                Log.e("SMHI", e.toString());
            }
        return "";
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(() -> {
            String data = fetchSmhiXml();
            Log.v(TAG, data);
        }).start();
    }
}

