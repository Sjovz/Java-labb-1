package com.example.helloworld;

public final class WeatherData {
    private final String humidity;
    private final String rainfall;

    private final String windSpeed;

    private final String tempurature;

    public String getHumidity() {
        return humidity;
    }

    public String getRainfall() {
        return rainfall;
    }

    public String getTempurature() {
        return tempurature;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public WeatherData(String humidity, String rainfall, String temp, String wind) {
        this.humidity = humidity;
        this.rainfall = rainfall;
        this.windSpeed = wind;
        this.tempurature = temp;
    }
}

