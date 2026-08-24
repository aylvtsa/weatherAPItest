package org.example;

import com.google.gson.annotations.SerializedName;

public class Day {

    @SerializedName("mintemp_c")
    private double minTemp;

    @SerializedName("maxtemp_c")
    private double maxTemp;

    @SerializedName("avghumidity")
    private double humidity;

    @SerializedName("maxwind_kph")
    private double maxWindKph;

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getMaxWindKph() {
        return maxWindKph;
    }
}