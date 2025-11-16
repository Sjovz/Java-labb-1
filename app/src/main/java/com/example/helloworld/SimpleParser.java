package com.example.helloworld;

public class SimpleParser {
    public static WeatherData parseXml(String tempXml, String windXml, String rainXml, String cloudXml) {

        // parse the xml here
        // return it
        int temp = 5;            // empXml
        double wind = 3.2;       // windXml
        double rain = 0.0;       // rainXml
        String clouds = "Mulet"; // cloudXml

        return new WeatherData(clouds, rain, temp, wind);
    }
}