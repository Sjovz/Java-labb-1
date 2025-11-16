package com.example.helloworld;

public final class WeatherData {
    private final String humidity;
    private final double rainfall;

    private final double windSpeed;

    private final int tempurature;

    public String getHumidity() {
        return humidity;
    }

    public double getRainfall() {
        return rainfall;
    }

    public int getTempurature() {
        return tempurature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public WeatherData(String humidity, double rainfall, int temp, double wind) {
        this.humidity = humidity;
        this.rainfall = rainfall;
        this.windSpeed = wind;
        this.tempurature = temp;
    }
}

