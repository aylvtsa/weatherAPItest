package org.example;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main {

    public static void main(String[] args) {

        String apiKey = "bc591c731e4e48928b4113552262408";

        String[] cities = {
                "Chisinau",
                "Madrid",
                "Kyiv",
                "Amsterdam"
        };

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.weatherapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApi weatherApi = retrofit.create(WeatherApi.class);

        System.out.println(
                "City | Date | Min temp | Max temp | Humidity | Wind speed | Wind direction"
        );

        System.out.println("-*".repeat(30));

        for (String city : cities) {

            try {
                Response<response> response =
                        weatherApi.getForecast(apiKey, city, 2).execute();

                if (response.isSuccessful() && response.body() != null) {

                    response data = response.body();

                    ForecastDay tomorrow =
                            data.getForecast()
                                    .getForecastday()
                                    .get(1);

                    Day day = tomorrow.getDay();

                    Hour noonWeather =
                            tomorrow.getHour().get(12);

                    System.out.println(
                            data.getLocation().getName() + " | " +
                                    tomorrow.getDate() + " | " +
                                    day.getMinTemp() + "°C | " +
                                    day.getMaxTemp() + "°C | " +
                                    day.getHumidity() + "% | " +
                                    noonWeather.getWindKph() + " kph | " +
                                    noonWeather.getWindDirection()
                    );

                } else {
                    System.out.println(
                            "Request failed for " + city +
                                    ". HTTP code: " + response.code()
                    );
                }

            } catch (Exception e) {
                System.out.println(
                        "Error getting weather for " + city
                );
            }
        }
    }
}