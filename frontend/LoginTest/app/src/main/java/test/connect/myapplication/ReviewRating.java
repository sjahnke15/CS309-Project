package test.connect.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReviewRating extends AppCompatActivity {
Button back;
Button toTrailInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_rating);

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