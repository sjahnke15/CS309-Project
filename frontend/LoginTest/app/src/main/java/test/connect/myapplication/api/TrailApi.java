package test.connect.myapplication.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import test.connect.myapplication.model.Trail;


public interface TrailApi {

    @GET("trail/all")
    Call<List<Trail>> getAllTrails();

    @POST("trail/post/{n}/{d}")
    Call<Trail> PostTrailByPath(@Path("n") String name, @Path("d") int difficulty);

}
