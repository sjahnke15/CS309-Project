package test.connect.myapplication.api;

import retrofit2.Call;
import retrofit2.http.GET;
import test.connect.myapplication.model.User;

public interface UserApi {

    @GET("posts/1")
    Call<User> getFirstUser();
}
