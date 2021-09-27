package sjahnke.iastate.edu.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button pressme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pressme = (Button) findViewById(R.id.pressme);

        pressme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHelloWorld();
            }
        });
    }

    public void openHelloWorld() {
        Intent i = new Intent(MainActivity.this, MessageActivity.class);
        startActivity(i);
    }
}