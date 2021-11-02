package test.connect.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserInfo extends AppCompatActivity {
Button back;
Button TrailHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        TextView userText = findViewById(R.id.txtUserName);
        userText.setText("");
        userText.setMovementMethod(new ScrollingMovementMethod());

        Intent intent = getIntent();
        String str = intent.getStringExtra("username");
        userText.setText(str);



        TextView userEmail = findViewById(R.id.txtEmailUsedByUser);
        userEmail.setText("");
        userEmail.setMovementMethod(new ScrollingMovementMethod());
        Intent email = getIntent();
        String emailUsed = email.getStringExtra("email");
        userEmail.setText(emailUsed);

        back = (Button)findViewById(R.id.btnBackToHomeFromUserInfo);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(UserInfo.this, homeScreen.class);
                startActivity(back);
            }
        });

        TrailHistory = (Button)findViewById(R.id.btnToTrailHistory);
        TrailHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent trailHistory = new Intent(UserInfo.this, TrailHistory.class);
                startActivity(trailHistory);
            }
        });

    }
}