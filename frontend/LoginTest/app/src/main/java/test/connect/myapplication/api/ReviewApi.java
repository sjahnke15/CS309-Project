package test.connect.myapplication.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import test.connect.myapplication.model.Review;


/**
 * @author Elijah Hanson
 *
 * Class for managing GET and POST requests related to the Review table
 */
public interface ReviewApi {

    /**
     * Method to get all review objects from review table
     * @return all trail objects
     */
    @GET("review/all")
    Call<List<Review>> getAllReviews();

    /**
     * Method to get all reviews of a given trail
     * @param trailID single ID to search for
     * @return all reviews associated with given ID
     */
    @GET("trail/getReviews/{trailID}")
    Call<List<Review>> getReviewByTrailID(@Path("trailID") String trailID);

    /**
     * Method to get all reviews associated with a user
     * @param userID single ID to search for
     * @return all reviews associated with given ID
     */
    @GET("trail/getReviewsByUserID/{userID}")
    Call<List<Review>> getReviewByUserID(@Path("userID") int userID);

    /**
     * Method to Post a new review based on trailID
     * @param rating user entered rating value
     * @param text user entered description
     * @param trailID specified trailID
     * @param userID ID of user posting review
     */
    @POST("review/post/{rating}/{text}/{trailID}/{userID}")
    Call<Review> PostTrailByPath(@Path("rating") float rating, @Path("text") String text, @Path("trailID") int trailID, @Path("userID") int userID);

    /**
     * Method to Post a new review based on the name of the trail
     * @param rating user entered rating value
     * @param text user entered description
     * @param name specified trail name
     * @param userID ID of user posting review
     */
    @POST("review/postbyname/{rating}/{text}/{trailName}/{userID}")
    Call<Review> PostTrailWithNameByPath(@Path("rating") float rating, @Path("text") String text, @Path("trailName") String name, @Path("userID") int userID);
}
