package com.example.helloworld;

public final class WeatherData {
    private final String humidity;
    private final Double rainfall;

    private final Double windSpeed;

    private final int tempurature;

    public String getHumidity() {
        return humidity;
    }

    public Double getRainfall() {
        return rainfall;
    }

    public int getTempurature() {
        return tempurature;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public WeatherData(String humidity, Double rainfall, int temp, Double wind) {
        this.humidity = humidity;
        this.rainfall = rainfall;
        this.windSpeed = wind;
        this.tempurature = temp;
    }
}

