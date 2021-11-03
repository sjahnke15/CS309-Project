package test.connect.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import static test.connect.myapplication.api.ApiClientFactory.GetTrailApi;
import static test.connect.myapplication.api.ApiClientFactory.GetReviewApi;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import test.connect.myapplication.api.SlimCallback;
import test.connect.myapplication.model.Review;
import test.connect.myapplication.model.Trail;

public class homeScreen extends AppCompatActivity {
Button btnBack;
Button btnUserInfo;
Button map;
Button weather;
TextView testingText;
TextView userTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        String temp = getIntent().getStringExtra("Message_key");
        userTemp = (TextView)findViewById(R.id.txtUserTemp);
        userTemp.setText(temp);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        int userID = intent.getIntExtra("userID", 0);



        testingText = findViewById(R.id.activity_home_screen_testTextView);
//        GetReviewApi().getReviewByUserID(userID).enqueue(new SlimCallback<List<Review>>(reviews->{
//            testingText.setText("");
//            for (int i = 0; i < reviews.size(); i++){
//                testingText.append(reviews.get(i).printable());
//            }
//
//        }, "multipleUsersApi"));



        btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(homeScreen.this,login_screen.class);
                back.putExtra("username", username);
                back.putExtra("email", email);
                back.putExtra("password", password);
                back.putExtra("userID", userID);
                startActivity(back);
            }
        });

        btnUserInfo = (Button)findViewById(R.id.activity_home_screen_toUser);
        btnUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userInfo = new Intent(homeScreen.this,UserInfo.class);
                userInfo.putExtra("username", username);
                userInfo.putExtra("email", email);
                userInfo.putExtra("password", password);
                userInfo.putExtra("userID", userID);
                startActivity(userInfo);
            }
        });

        map = (Button)findViewById(R.id.btnToMap);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMap = new Intent(homeScreen.this, Map.class);
                toMap.putExtra("username", username);
                toMap.putExtra("email", email);
                toMap.putExtra("password", password);
                toMap.putExtra("userID", userID);
                startActivity(toMap);
            }
        });

        weather = (Button)findViewById(R.id.btnToWeather);
        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toWeather = new Intent(homeScreen.this, Weather.class);
                toWeather.putExtra("username", username);
                toWeather.putExtra("email", email);
                toWeather.putExtra("password", password);
                toWeather.putExtra("userID", userID);
                startActivity(toWeather);

            }
        });

       // imgAccount.setOnClickListener(new View.OnClickListener() {
       //     @Override
       //     public void onClick(View view) {
       //         Intent user = new Intent(homeScreen.this, userInfo.class);
       //         startActivity(user);
        //    }
       // });

       // map.setOnClickListener(new View.OnClickListener() {
       //     @Override
       //     public void onClick(View view) {
       //         Intent toMap = new Intent(homeScreen.this,map.class);
        //        startActivity(toMap);
        //    }
        //});


    }
}