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

public class signUp extends AppCompatActivity {
Button btnBackToLogin;
Button btn_signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnBackToLogin = (Button)findViewById(R.id.btnBackToLogin);
        btnBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(signUp.this,login_screen.class);
                startActivity(back);
            }
        });

        EditText appearanceName = findViewById(R.id.txt_appearanceName);
        EditText email = findViewById(R.id.txt_email_In);
        EditText password = findViewById(R.id.txt_password_In);


        btn_signUp = (Button)findViewById(R.id.btn_signUp);
        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetUserApi().PostUserByPath(email.getText().toString(), appearanceName.getText().toString(), password.getText().toString()).enqueue(new SlimCallback<User>(user ->{}));
                appearanceName.setText("");
                email.setText("");
                password.setText("");
                Intent backToLogin = new Intent(signUp.this,login_screen.class);
                startActivity(backToLogin);
            }
        });
    }
}