package test.connect.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class TrailHistory extends AppCompatActivity {
    ImageView back;
    ImageView review;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail_history);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        int userID = intent.getIntExtra("userID", 0);

        back = (ImageView)findViewById(R.id.btnBackToUserInfo);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(TrailHistory.this, UserInfo.class);
                back.putExtra("username", username);
                back.putExtra("email", email);
                back.putExtra("password", password);
                back.putExtra("userID", userID);
                startActivity(back);
            }
        });

        review = (ImageView)findViewById(R.id.btnReviewRating);
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent leaveReview = new Intent(TrailHistory.this, ReviewRating.class);
                leaveReview.putExtra("username", username);
                leaveReview.putExtra("email", email);
                leaveReview.putExtra("password", password);
                leaveReview.putExtra("userID", userID);
                startActivity(leaveReview);
            }
        });
    }
}