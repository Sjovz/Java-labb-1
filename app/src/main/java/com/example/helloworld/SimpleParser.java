package com.example.helloworld;

import android.util.Log;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.util.Optional;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class SimpleParser {
    private static Optional<String> parseLastValue(String xmlData) {
        // https://www.geeksforgeeks.org/java/read-and-write-xml-files-in-java/
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            var buffer = new StringReader(xmlData);
            Document document = builder.parse(new InputSource(buffer));
            var values = document.getElementsByTagName("value");
            if (values.getLength() == 0) return Optional.empty();
            var value = values.item(values.getLength()-1);
            return Optional.of(value.getTextContent());
        } catch (ParserConfigurationException | IOException | SAXException e) {
            Log.e("SimpleParser", Optional.ofNullable(e.getMessage()).orElse("missingno"));
            return Optional.empty();
        }
    }

    private static double asDoubleOrThrow(String value) {
        return Double.parseDouble(value);
    }

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