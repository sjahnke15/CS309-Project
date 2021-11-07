package test.connect.myapplication.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import test.connect.myapplication.model.User;

/**
 * Elijah Hanson - Class for managing GET and POST requests related to the User table
 */
public interface UserApi {

    /**
     * Method to get all user objects from user table
     * @return all user objects
     */
    @GET("user/all")
    Call<List<User>> getAllUsers();

    /**
     * Method to get a user by username
     * @return user object with matching username as specified path
     */
    @GET("user/username/{username}")
    Call<User> getUserByUsername(@Path("username") String username);

    /**
     * Method to get a user by email
     * @return user object with matching email as specified path
     */
    @GET("user/email/{email}")
    Call<User> getUserByEmail(@Path("email") String email);

    /**
     * Method to post a new user object to the database
     * @param email entered email column value
     * @param username entered username column value
     * @param password entered password column value
     */
    @POST("user/post/{e}/{n}/{p}")
    Call<User> PostUserByPath(@Path("e") String email, @Path("n") String username, @Path("p") String password);

}


