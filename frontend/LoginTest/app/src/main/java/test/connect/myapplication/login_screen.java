package test.connect.myapplication;

import static test.connect.myapplication.api.ApiClientFactory.GetUserApi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        //login Error TextView
        TextView loginError = findViewById(R.id.activity_login_screen_error);
        loginError.setText("");

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        int userID = intent.getIntExtra("userID", 0);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetUserApi().getUserByUsername(userLoginInput.getText().toString()).enqueue(new SlimCallback<User>(user ->{
                    if(userLoginInput.getText().toString().equals(user.getUsername())) {
                        if (userPassInput.getText().toString().equals(user.getPassword())) {
                            //Intent intent = new Intent(login_screen.this, UserInfo.class);
                            //intent.putExtra("username", user.getUsername());
                            //intent.putExtra("email", user.getEmail());
                            //intent.putExtra("password", user.getPassword());
                            //intent.putExtra("userId", user.getId());


                            Intent i = new Intent(login_screen.this, homeScreen.class);
                            i.putExtra("username", user.getUsername());
                            i.putExtra("email", user.getEmail());
                            i.putExtra("password", user.getPassword());
                            i.putExtra("userID", user.getId());
                            startActivity(i);
                        }
                    }
                    loginError.setText("Invalid Username or Password. Please Try Again.");
                    userLoginInput.setText("");
                    userPassInput.setText("");


                }));


                GetUserApi().getUserByEmail(userLoginInput.getText().toString()).enqueue(new SlimCallback<User>(user -> {
                    if(userLoginInput.getText().toString().equals(user.getEmail())) {
                        if (userPassInput.getText().toString().equals(user.getPassword())) {
                            Intent i = new Intent(login_screen.this, homeScreen.class);
                            startActivity(i);
                        }
                    }
                    loginError.setText("Invalid Username or Password. Please Try Again.");
                    userLoginInput.setText("");
                    userPassInput.setText("");


                }));
            }
        });



//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GetUserApi().getUserByEmail(userLoginInput.getText().toString()).enqueue(new SlimCallback<User>(user ->{
//                    if(userPassInput.getText().toString().equals(user.getPassword())){
//                        Intent i = new Intent(login_screen.this,homeScreen.class);
//                        startActivity(i);
//                    }
//                    else{
//                        loginError.setText("Invalid Username or Password. Please Try Again.");
//                    }
//
//                }));
//            }
//        });

        button_signup =(Button)findViewById(R.id.button_signup);
        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signup = new Intent(login_screen.this,signUp.class);
                signup.putExtra("username", username);
                signup.putExtra("email", email);
                signup.putExtra("password", password);
                signup.putExtra("userID", userID);
                startActivity(signup);
            }
        });
    }
}