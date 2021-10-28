package test.connect.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReviewRating extends AppCompatActivity {
Button back;
Button toTrailInfo;

Button Difficulty1 = findViewById(R.id.btnDifficultyOne);
Button Difficulty2 = findViewById(R.id.btnDifficultyTwo);
Button Difficulty3 = findViewById(R.id.btnDifficultyThree);
Button Difficulty4 = findViewById(R.id.btnDifficultyFour);
Button Difficulty5 = findViewById(R.id.btnDifficultyFive);

Button Rating1 = findViewById(R.id.btnRatingOne);
Button Rating2 = findViewById(R.id.btnRatingTwo);
Button Rating3 = findViewById(R.id.btnRatingThree);
Button Rating4 = findViewById(R.id.btnRatingFour);
Button Rating5 = findViewById(R.id.btnRatingFive);

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