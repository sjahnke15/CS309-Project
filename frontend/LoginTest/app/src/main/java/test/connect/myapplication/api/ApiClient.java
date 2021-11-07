package test.connect.myapplication.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Daniel - This method will direct you to the url needed for the weather screen to work.
 */
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

    /**
     * Daniel - This method is grabbing the weather API for it to be used.
     * @return creates the ability to use the weather api
     */
    public static WeatherApi GetWeatherApi(){
        return getClient().create(WeatherApi.class);
    }

}
