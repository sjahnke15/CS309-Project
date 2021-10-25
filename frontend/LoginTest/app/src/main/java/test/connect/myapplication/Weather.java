package test.connect.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Weather extends AppCompatActivity {
Button toHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        toHome = (Button)findViewById(R.id.btnBackHomeFromWeather);
        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(Weather.this, homeScreen.class);
                startActivity(back);
            }
        });
    }
}