package test.connect.myapplication.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import test.connect.myapplication.model.Review;



public interface ReviewApi {

    @GET("review/all")
    Call<List<Review>> getAllReviews();

    @GET("trail/getReviews/{trailID}")
    Call<List<Review>> getReviewByTrailID(@Path("trailID") String trailID);

    @GET("trail/getReviewsByUserID/{userID}")
    Call<List<Review>> getReviewByUserID(@Path("userID") int userID);

    @POST("review/post/{rating}/{text}/{trailID}/{userID}")
    Call<Review> PostTrailByPath(@Path("rating") float rating, @Path("text") String text, @Path("trailID") int trailID, @Path("userID") int userID);

    @POST("review/postbyname/{rating}/{text}/{trailName}/{userID}")
    Call<Review> PostTrailWithNameByPath(@Path("rating") float rating, @Path("text") String text, @Path("trailName") String name, @Path("userID") int userID);
}
