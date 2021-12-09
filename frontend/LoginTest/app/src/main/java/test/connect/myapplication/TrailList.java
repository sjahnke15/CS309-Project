package test.connect.myapplication;

import static test.connect.myapplication.api.ApiClientFactory.GetTrailApi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import test.connect.myapplication.api.SlimCallback;
import test.connect.myapplication.model.Trail;

public class TrailList extends AppCompatActivity {
    ImageView backToMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail_list2);
        Button ToReview = findViewById(R.id.btnReviewTrail);
        ImageView Refresh = findViewById(R.id.btnRefresh);

        TextView TrailName1 = findViewById(R.id.txtTrail1);
        TextView TrailName2 = findViewById(R.id.txtTrail2);
        TextView TrailName3 = findViewById(R.id.txtTrail3);
        TextView TrailName4 = findViewById(R.id.txtTrail4);
        TextView TrailName5 = findViewById(R.id.txtTrail5);

        TextView TrailDist1 = findViewById(R.id.txtDistanceTrail1);
        TextView TrailDiff1 = findViewById(R.id.txtDifficultyTrail1);
        TextView TrailRating1 = findViewById(R.id.txtRatingTrail1);

        TextView TrailDist2 = findViewById(R.id.txtDistanceTrail2);
        TextView TrailDiff2 = findViewById(R.id.txtDifficultyTrail2);
        TextView TrailRating2 = findViewById(R.id.txtRatingTrail2);

        TextView TrailDist3 = findViewById(R.id.txtDistanceTrail3);
        TextView TrailDiff3 = findViewById(R.id.txtDifficultyTrail3);
        TextView TrailRating3 = findViewById(R.id.txtRatingTrail3);

        TextView TrailDist4 = findViewById(R.id.txtDistanceTrail4);
        TextView TrailDiff4 = findViewById(R.id.txtDifficultyTrail4);
        TextView TrailRating4 = findViewById(R.id.txtRatingTrail4);

        TextView TrailDist5 = findViewById(R.id.txtDistanceTrail5);
        TextView TrailDiff5 = findViewById(R.id.txtDifficultyTrail5);
        TextView TrailRating5 = findViewById(R.id.txtRatingTrail5);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        int userID = intent.getIntExtra("userID", 0);

        Refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetTrailApi().getAllTrails().enqueue(new SlimCallback<List<Trail>>(trails->{
                    TrailName1.setText("");
                    for (int i = 0; i < trails.size(); i++){
                        if(i == 3){
                            TrailName1.setText(trails.get(i).getName());
                            TrailDist1.setText(String.valueOf(trails.get(i).getDistance()));
                            TrailDiff1.setText(String.valueOf(trails.get(i).getDifficulty()));
                            TrailRating1.setText(String.valueOf(trails.get(i).getTrailRating()));
                        }
                        else if(i == 4){
                            TrailName2.setText(trails.get(i).getName());
                            TrailDist2.setText(String.valueOf(trails.get(i).getDistance()));
                            TrailDiff2.setText(String.valueOf(trails.get(i).getDifficulty()));
                            TrailRating2.setText(String.valueOf(trails.get(i).getTrailRating()));
                        }
                        else if(i == 5){
                            TrailName3.setText(trails.get(i).getName());
                            TrailDist3.setText(String.valueOf(trails.get(i).getDistance()));
                            TrailDiff3.setText(String.valueOf(trails.get(i).getDifficulty()));
                            TrailRating3.setText(String.valueOf(trails.get(i).getTrailRating()));
                        }
                        else if(i == 6){
                            TrailName4.setText(trails.get(i).getName());
                            TrailDist4.setText(String.valueOf(trails.get(i).getDistance()));
                            TrailDiff4.setText(String.valueOf(trails.get(i).getDifficulty()));
                            TrailRating4.setText(String.valueOf(trails.get(i).getTrailRating()));
                        }
                        else if(i == 7){
                            TrailName5.setText(trails.get(i).getName());
                            TrailDist5.setText(String.valueOf(trails.get(i).getDistance()));
                            TrailDiff5.setText(String.valueOf(trails.get(i).getDifficulty()));
                            TrailRating5.setText(String.valueOf(trails.get(i).getTrailRating()));
                        }
                    }

                }, "multipleTrailsApi"));

            }
        });


        backToMap = (ImageView)findViewById(R.id.btnBackToMap);
        backToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(TrailList.this, GoogleMaps.class);
                back.putExtra("username", username);
                back.putExtra("email", email);
                back.putExtra("password", password);
                back.putExtra("userID", userID);
                startActivity(back);
            }
        });

        ToReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent review = new Intent(TrailList.this, ReviewRating.class);
                review.putExtra("username", username);
                review.putExtra("email", email);
                review.putExtra("password", password);
                review.putExtra("userID", userID);
                startActivity(review);
            }
        });
    }
}