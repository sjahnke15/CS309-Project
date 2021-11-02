package test.connect.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

public class ReviewRating extends AppCompatActivity {
Button back;
Button toTrailInfo;
RatingBar ratingBar;
TextView leaveReview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_rating);


        ratingBar = findViewById(R.id.ratingBar);
        leaveReview = findViewById(R.id.txtLeaveReview);
        

        Spinner spinner = findViewById(R.id.trailSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Trails, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);




        back = (Button)findViewById(R.id.btnBackToTrailHistory);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(ReviewRating.this, TrailHistory.class);
                startActivity(back);
            }
        });

        toTrailInfo = (Button)findViewById(R.id.btnTrailInfo);
        toTrailInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent trailInfo = new Intent(ReviewRating.this, TrailInfo.class);
                startActivity(trailInfo);
            }
        });
    }
}