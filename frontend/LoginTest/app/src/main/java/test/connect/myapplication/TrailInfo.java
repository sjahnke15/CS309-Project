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

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        int userID = intent.getIntExtra("userID", 0);

        backToMap = (Button)findViewById(R.id.btnBackToMapFromTrailInfo);
        backToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(TrailInfo.this, Map.class);
                back.putExtra("username", username);
                back.putExtra("email", email);
                back.putExtra("password", password);
                back.putExtra("userID", userID);
                startActivity(back);
            }
        });

        addReview = (Button)findViewById(R.id.btnAddReviewFromTrailInfo);
        addReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add = new Intent(TrailInfo.this, ReviewRating.class);
                add.putExtra("username", username);
                add.putExtra("email", email);
                add.putExtra("password", password);
                add.putExtra("userID", userID);
                startActivity(add);
            }
        });
    }
}