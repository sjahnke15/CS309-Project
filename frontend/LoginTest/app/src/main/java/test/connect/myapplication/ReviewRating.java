package test.connect.myapplication;

import static test.connect.myapplication.api.ApiClientFactory.GetReviewApi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import test.connect.myapplication.api.SlimCallback;
import test.connect.myapplication.model.Review;

public class ReviewRating extends AppCompatActivity {
    ImageView back;
    ImageView toTrailInfo;
    RatingBar ratingBar;
    TextView leaveReview;
    Button submit;
    EditText reviewText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_rating);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        int userID = intent.getIntExtra("userID", 0);




        ratingBar = findViewById(R.id.ratingBar);
        leaveReview = findViewById(R.id.txtLeaveReview);
        submit = findViewById(R.id.reviewPostButton);
        reviewText = findViewById(R.id.txtUserReview);


        Spinner spinner = findViewById(R.id.trailSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Trails, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = spinner.getSelectedItem().toString();
                GetReviewApi().PostTrailWithNameByPath(ratingBar.getRating(), reviewText.getText().toString(), name, userID).enqueue(new SlimCallback<Review>(review ->{
                    reviewText.setText("");
                    Intent back = new Intent(ReviewRating.this, TrailHistory.class);
                    back.putExtra("username", username);
                    back.putExtra("email", email);
                    back.putExtra("password", password);
                    back.putExtra("userID", userID);
                    startActivity(back);
                }));
            }
        });


        back = (ImageView)findViewById(R.id.btnBackToTrailHistory);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(ReviewRating.this, TrailHistory.class);
                back.putExtra("username", username);
                back.putExtra("email", email);
                back.putExtra("password", password);
                back.putExtra("userID", userID);
                startActivity(back);
            }
        });

        toTrailInfo = (ImageView)findViewById(R.id.btnTrailInfo);
        toTrailInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent trailInfo = new Intent(ReviewRating.this, TrailInfo.class);
                trailInfo.putExtra("username", username);
                trailInfo.putExtra("email", email);
                trailInfo.putExtra("password", password);
                trailInfo.putExtra("userID", userID);
                startActivity(trailInfo);
            }
        });
    }
}