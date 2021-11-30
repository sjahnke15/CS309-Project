package test.connect.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Wildlife extends AppCompatActivity {
    Button back;
    Spinner trailChats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wildlife2);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        int userID = intent.getIntExtra("userID", 0);

        back = (Button)findViewById(R.id.btnMapFromWildlife);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(Wildlife.this, Map.class);
                back.putExtra("username", username);
                back.putExtra("email", email);
                back.putExtra("password", password);
                back.putExtra("userID", userID);
                startActivity(back);
            }
        });

        trailChats = (Spinner)findViewById(R.id.trailChats);
        List<String> trails = new ArrayList<String>();

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_wildlife2, trails);
        //trailChats.setAdapter(adapter);
    }
}