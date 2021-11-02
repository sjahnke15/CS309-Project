package test.connect.myapplication.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    //https://api.openweathermap.org/data/2.5/weather?q=Chicago&appid=7594454438ad0063a4bb8d84958849d5&units=imperial
    private static Retrofit retrofit = null;
    public static Retrofit getClient(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.openweathermap.org/data/2.5/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }
    public static WeatherApi GetWeatherApi(){
        return getClient().create(WeatherApi.class);
    }

}
