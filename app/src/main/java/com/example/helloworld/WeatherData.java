package com.example.helloworld;

public final class WeatherData {
    private final String humidity;
    private final Double rainfall;

    private final Double windSpeed;

    private final double tempurature;

    public String getHumidity() {
        return humidity;
    }

    public Double getRainfall() {
        return rainfall;
    }

    public double getTempurature() {
        return tempurature;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public WeatherData(String humidity, Double rainfall, double temp, Double wind) {
        this.humidity = humidity;
        this.rainfall = rainfall;
        this.windSpeed = wind;
        this.tempurature = temp;
    }
}

