package org.example;

import com.google.gson.annotations.SerializedName;

public class Hour {

    @SerializedName("wind_kph")
    private double windKph;

    @SerializedName("wind_dir")
    private String windDirection;

    public double getWindKph() {
        return windKph;
    }

    public String getWindDirection() {
        return windDirection;
    }
}