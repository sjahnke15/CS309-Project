package test.connect.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TrailHistory extends AppCompatActivity {
Button back;
Button review;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail_history);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        int userID = intent.getIntExtra("userID", 0);

        back = (Button)findViewById(R.id.btnBackToUserInfo);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(TrailHistory.this, UserInfo.class);
                startActivity(back);
            }
        });

        review = (Button)findViewById(R.id.btnReviewRating);
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