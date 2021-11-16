package test.connect.myapplication;

import static test.connect.myapplication.api.ApiClientFactory.GetTrailApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import test.connect.myapplication.api.SlimCallback;
import test.connect.myapplication.model.Trail;

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

        TextView TrailDist1 = findViewById(R.id.txtDistanceTrail1);
        TextView TrailDiff1 = findViewById(R.id.txtDifficultyTrail1);
        TextView TrailRating1 = findViewById(R.id.txtRatingTrail1);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        int userID = intent.getIntExtra("userID", 0);

        GetTrailApi().getAllTrails().enqueue(new SlimCallback<List<Trail>>(trails->{
            Trail1.setText("");
            for (int i = 0; i < trails.size(); i++){
                if(i == 0){
                    Trail1.setText(trails.get(i).getName());
                    TrailDist1.setText("Placeholder");
                    TrailDiff1.setText(String.valueOf(trails.get(i).getDifficulty()));
                    TrailRating1.setText("Placeholder");
                }
                else if(i == 1){
                    Trail2.setText(trails.get(i).getName());
                }
            }

        }, "multipleUsersApi"));

        backToMap = (Button)findViewById(R.id.btnBackToMap);
        backToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(TrailList.this, Map.class);
                back.putExtra("username", username);
                back.putExtra("email", email);
                back.putExtra("password", password);
                back.putExtra("userID", userID);
                startActivity(back);
            }
        });
    }
}