package test.connect.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class userInfo extends AppCompatActivity {
    ImageView imgBack = (ImageView) findViewById(R.id.imgBack);
    ImageView next = (ImageView) findViewById(R.id.imgToTrailHistory);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToHome = new Intent(userInfo.this, homeScreen.class);
                startActivity(backToHome);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHistory = new Intent(userInfo.this, trailHistory.class);
                startActivity(toHistory);
            }
        });
    }
}