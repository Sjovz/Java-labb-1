package com.example.helloworld;

public class SimpleParser {

    public static WeatherData parseXml(String tempXml, String windXml, String windDirXml, String cloudXml) {

        // parse the xml here
        // return it
        int temp = 5;                 // från tempXml
        double windSpeed = 3.2;       // från windXml
        double windDirDeg = 180.0;    // från windDirXml
        String clouds = "Mulet";      // från cloudXml

        return new WeatherData(clouds, windDirDeg, temp, windSpeed);
    }
}