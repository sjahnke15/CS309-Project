package test.connect.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import static test.connect.myapplication.api.ApiClientFactory.GetTrailApi;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import test.connect.myapplication.api.SlimCallback;
import test.connect.myapplication.model.Trail;

public class homeScreen extends AppCompatActivity {
Button btnBack;
Button btnUserInfo;
Button map;
Button weather;
TextView testingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Intent intent = getIntent();
        String str = intent.getStringExtra("username");

        testingText = findViewById(R.id.activity_home_screen_testTextView);
        GetTrailApi().getAllTrails().enqueue(new SlimCallback<List<Trail>>(trails->{
            testingText.setText("");
            for (int i = 0; i < trails.size(); i++){
                testingText.append(trails.get(i).getName());
            }

        }, "multipleUsersApi"));



        btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(homeScreen.this,login_screen.class);
                startActivity(back);
            }
        });

        btnUserInfo = (Button)findViewById(R.id.activity_home_screen_toUser);
        btnUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userInfo = new Intent(homeScreen.this,UserInfo.class);
                userInfo.putExtra("username", str);
                startActivity(userInfo);
            }
        });

        map = (Button)findViewById(R.id.btnToMap);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMap = new Intent(homeScreen.this, Map.class);
                startActivity(toMap);
            }
        });

        weather = (Button)findViewById(R.id.btnToWeather);
        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toWeather = new Intent(homeScreen.this, Weather.class);
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