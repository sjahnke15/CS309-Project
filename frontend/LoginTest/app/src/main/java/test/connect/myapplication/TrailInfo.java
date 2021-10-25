package test.connect.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TrailInfo extends AppCompatActivity {
Button backToMap;
Button addReview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail_info2);

        backToMap = (Button)findViewById(R.id.btnBackToMapFromTrailInfo);
        backToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(TrailInfo.this, Map.class);
                startActivity(back);
            }
        });

        addReview = (Button)findViewById(R.id.btnAddReviewFromTrailInfo);
        addReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add = new Intent(TrailInfo.this, ReviewRating.class);
                startActivity(add);
            }
        });
    }
}