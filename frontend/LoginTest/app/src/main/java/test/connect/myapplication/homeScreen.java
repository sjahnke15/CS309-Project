package test.connect.myapplication;

import static test.connect.myapplication.api.ApiClientFactory.GetUserApi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import test.connect.myapplication.api.SlimCallback;
import test.connect.myapplication.model.User;

public class homeScreen extends AppCompatActivity {
Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(homeScreen.this,login_screen.class);
                startActivity(back);
            }
        });


    }
}