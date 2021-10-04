package test.connect.myapplication;

import static test.connect.myapplication.api.ApiClientFactory.GetUserApi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import test.connect.myapplication.api.SlimCallback;
import test.connect.myapplication.model.User;

public class login_screen extends AppCompatActivity {
Button button_login;
Button button_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        Button loginButton = (Button)findViewById(R.id.button_login);

        //Login EditTexts
        EditText userLoginInput= findViewById(R.id.activity_login_screen_usernameText);
        EditText userPassInput = findViewById(R.id.activity_login_passwordText);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetUserApi().getUserByUsername(userLoginInput.getText().toString()).enqueue(new SlimCallback<User>(user ->{
                    if(userPassInput.getText().toString().equals(user.getPassword())){
                        Intent i = new Intent(login_screen.this,homeScreen.class);
                        startActivity(i);
                    }

                }));
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