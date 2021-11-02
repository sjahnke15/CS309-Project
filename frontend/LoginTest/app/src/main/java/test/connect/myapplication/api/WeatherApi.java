package test.connect.myapplication.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET("weather?appid=7594454438ad0063a4bb8d84958849d5&units=imperial")
    Call<weather> getWeatherData(@Query("q") String name);
}