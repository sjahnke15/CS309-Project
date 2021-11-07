package test.connect.myapplication.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Daniel
 * WeatherApi directs the user to the correct web address desired to their location typed in.
 * Users can type any city in the world and be given back data specific to the city.
 */
public interface WeatherApi {
    @GET("weather?appid=7594454438ad0063a4bb8d84958849d5&units=imperial")
    Call<weather> getWeatherData(@Query("q") String name);
}