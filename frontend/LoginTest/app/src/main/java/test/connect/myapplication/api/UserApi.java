package test.connect.myapplication.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import test.connect.myapplication.model.Photo;
import test.connect.myapplication.model.User;

public interface UserApi {

//    @GET("user/1")
//    Call<User> getFirstUser();

    @GET("user/all")
    Call<List<User>> getAllUsers();

    @GET("user/username/{username}")
    Call<User> getUserByUsername(@Path("username") String username);

    @GET("user/email/{email}")
    Call<User> getUserByEmail(@Path("email") String email);

    @POST("user/post/{e}/{n}/{p}")
    Call<User> PostUserByPath(@Path("e") String email, @Path("n") String username, @Path("p") String password);

}


