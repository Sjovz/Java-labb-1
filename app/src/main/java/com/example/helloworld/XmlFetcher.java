package com.example.helloworld;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class XmlFetcher {
    public static String getXml(String urlString) {
        try {

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
}
