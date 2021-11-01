package test.connect.myapplication.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientFactory {

    static Retrofit apiClientSeed = null;

    static Retrofit GetApiClientSeed() {

        if (apiClientSeed == null) {
            apiClientSeed = new Retrofit.Builder()
                    //.baseUrl("https://jsonplaceholder.typicode.com/")
                    .baseUrl("http://10.0.2.2:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return apiClientSeed;
    }
    

    public static UserApi GetUserApi(){
        return GetApiClientSeed().create(UserApi.class);
    }

    public static ReviewApi GetReviewApi(){
        return GetApiClientSeed().create(ReviewApi.class);
    }

    public static TrailApi GetTrailApi(){
        return GetApiClientSeed().create(TrailApi.class);
    }

}
