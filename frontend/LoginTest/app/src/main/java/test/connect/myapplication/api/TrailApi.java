package test.connect.myapplication.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import test.connect.myapplication.model.Trail;

/**
 * Elijah Hanson - Class for managing GET and POST requests related to the Trail table
 */
public interface TrailApi {
    /**
     * Method to get all trail objects from trail table
     * @return all trail objects
     */
    @GET("trail/all")
    Call<List<Trail>> getAllTrails();

    /**
     * Method to post a new Trail object to the database
     * @param name entered trail name
     * @param difficulty entered trail difficulty
     */
    @POST("trail/post/{n}/{d}/{l}")
    Call<Trail> PostTrailByPath(@Path("n") String name, @Path("d") int difficulty, @Path("l") int distance);

    @GET("trail/averageRating/{trailName}")
    Call<Trail> getAverageTrailRating(@Path("trailName") String trailName);

    @GET("trail/id/{id}")
    Call<List<Trail>> getTrailByID();

    @GET("trail/name/{name}")
    Call<List<Trail>> getTrailByName();

    @GET("trail/difficulty/{difficulty}")
    Call<List<Trail>> getTrailListByDifficulty();

}
