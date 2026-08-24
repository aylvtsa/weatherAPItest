package org.example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("v1/forecast.json")
    Call<response> getForecast(
            @Query("key") String apiKey,
            @Query("q") String city,
            @Query("days") int days
    );
}