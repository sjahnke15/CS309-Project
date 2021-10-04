package test.connect.myapplication.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import test.connect.myapplication.model.Photo;
import test.connect.myapplication.model.User;

public interface UserApi {

//    @GET("user/1")
//    Call<User> getFirstUser();

    @GET("user/all")
    Call<List<User>> getAllUsers();
}
