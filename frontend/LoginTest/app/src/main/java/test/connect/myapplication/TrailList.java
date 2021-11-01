package test.connect.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TrailList extends AppCompatActivity {
Button backToMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail_list2);
        Button Trail1 = findViewById(R.id.btnTrail1);
        Button Trail2 = findViewById(R.id.btnTrail2);
        Button Trail3 = findViewById(R.id.btnTrail3);
        Button Trail4 = findViewById(R.id.btnTrail4);
        Button Trail5 = findViewById(R.id.btnTrail5);
        Button start = findViewById(R.id.btnStartTrail);

        backToMap = (Button)findViewById(R.id.btnBackToMap);
        backToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(TrailList.this, Map.class);
                startActivity(back);
            }
        });
    }
}