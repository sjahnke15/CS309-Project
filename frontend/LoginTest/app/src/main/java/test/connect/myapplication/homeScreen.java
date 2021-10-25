package test.connect.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class homeScreen extends AppCompatActivity {
Button btnBack;
Button btnUserInfo;
TextView testingText;
Button map;
Button weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Intent intent = getIntent();
        String str = intent.getStringExtra("username");

        testingText = findViewById(R.id.activity_home_screen_testTextView);
        testingText.setText(str);

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