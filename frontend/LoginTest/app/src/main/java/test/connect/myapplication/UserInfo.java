package test.connect.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import static test.connect.myapplication.api.ApiClientFactory.GetReviewApi;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import test.connect.myapplication.api.SlimCallback;
import test.connect.myapplication.model.Review;

public class UserInfo extends AppCompatActivity {
Button back;
Button TrailHistory;
TextView userReviews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        TextView userIDText = findViewById(R.id.txtID);
        //userIDText.setMovementMethod(new ScrollingMovementMethod());
        TextView usernameText = findViewById(R.id.txtUserName);
        //usernameText.setMovementMethod(new ScrollingMovementMethod());
        TextView userEmail = findViewById(R.id.txtEmailUsedByUser);
        //userEmail.setMovementMethod(new ScrollingMovementMethod());
        TextView userPassword = findViewById(R.id.txtPassword);
        //userPassword.setMovementMethod(new ScrollingMovementMethod());


        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        int userID = intent.getIntExtra("userID", 0);

        usernameText.append(username);
        userEmail.append(email);
        userIDText.append(String.valueOf(userID));
        userPassword.append(password);

        userReviews = findViewById(R.id.txtUserReviews);
        userReviews.setMovementMethod(new ScrollingMovementMethod());
        GetReviewApi().getReviewByUserID(userID).enqueue(new SlimCallback<List<Review>>(reviews->{
            userReviews.setText("");
            for (int i = 0; i < reviews.size(); i++){
                userReviews.append(reviews.get(i).printable());
            }

        }, "multipleReviewsApi"));


        back = (Button)findViewById(R.id.btnBackToHomeFromUserInfo);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(UserInfo.this, homeScreen.class);
                back.putExtra("username", username);
                back.putExtra("email", email);
                back.putExtra("password", password);
                back.putExtra("userID", userID);
                startActivity(back);
            }
        });

        TrailHistory = (Button)findViewById(R.id.btnToTrailHistory);
        TrailHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent trailHistory = new Intent(UserInfo.this, TrailHistory.class);
                trailHistory.putExtra("username", username);
                trailHistory.putExtra("email", email);
                trailHistory.putExtra("password", password);
                trailHistory.putExtra("userID", userID);
                startActivity(trailHistory);
            }
        });

    }
}