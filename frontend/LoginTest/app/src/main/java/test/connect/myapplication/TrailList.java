package test.connect.myapplication;

import static test.connect.myapplication.api.ApiClientFactory.GetTrailApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import test.connect.myapplication.api.SlimCallback;
import test.connect.myapplication.model.Review;
import test.connect.myapplication.model.Trail;

public class TrailList extends AppCompatActivity {
Button backToMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail_list2);
        Button ToReview = findViewById(R.id.btnReviewTrail);
        Button Refresh = findViewById(R.id.btnRefresh);

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
                        if(i == 0){
                            TrailName1.setText(trails.get(i).getName());
                            TrailDist1.setText("Placeholder");
                            TrailDiff1.setText(String.valueOf(trails.get(i).getDifficulty()));
                            TrailRating1.setText("Placeholder");
                        }
                        else if(i == 1){
                            TrailName2.setText(trails.get(i).getName());
                            TrailDiff2.setText(String.valueOf(trails.get(i).getDifficulty()));
                        }
                    }

                }, "multipleTrailsApi"));
            }
        });


        backToMap = (Button)findViewById(R.id.btnBackToMap);
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