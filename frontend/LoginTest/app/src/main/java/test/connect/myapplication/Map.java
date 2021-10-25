package test.connect.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Map extends AppCompatActivity {
Button toHome;
Button toWildlife;
Button toTrailList;
Button toTrailInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2);

        toHome = (Button)findViewById(R.id.btnBackToHomeFromMap);
        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(Map.this, homeScreen.class);
                startActivity(back);
            }
        });

        toWildlife = (Button)findViewById(R.id.btnToWildlife);
        toWildlife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wildlife = new Intent(Map.this, Wildlife.class);
                startActivity(wildlife);
            }
        });

        toTrailList = (Button)findViewById(R.id.btnToTrailList);
        toTrailList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toTrailList = new Intent(Map.this, TrailList.class);
                startActivity(toTrailList);
            }
        });

        toTrailInfo = (Button)findViewById(R.id.btnToTrailInfo);
        toTrailInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toTrailInfo = new Intent(Map.this, TrailInfo.class);
                startActivity(toTrailInfo);
            }
        });
    }
}