package test.connect.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login_screen extends AppCompatActivity {
Button button_login;
Button button_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        button_login =(Button)findViewById(R.id.button_login);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(login_screen.this,homeScreen.class);
                startActivity(a);
            }
        });
        button_signup =(Button)findViewById(R.id.button_signup);
        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signup = new Intent(login_screen.this,signUp.class);
                startActivity(signup);
            }
        });
    }
}