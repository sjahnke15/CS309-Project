package test.connect.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class UserInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        TextView userText = findViewById(R.id.activity_user_info_text);
        userText.setText("");
        userText.setMovementMethod(new ScrollingMovementMethod());

        Intent intent = getIntent();
        String str = intent.getStringExtra("username");

        userText.setText(str);

    }
}