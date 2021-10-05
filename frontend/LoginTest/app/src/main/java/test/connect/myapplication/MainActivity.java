package test.connect.myapplication;

import static test.connect.myapplication.api.ApiClientFactory.GetUserApi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import test.connect.myapplication.api.SlimCallback;
import test.connect.myapplication.model.User;

public class MainActivity extends AppCompatActivity {
Button btnTemp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView apiText1 = findViewById(R.id.activity_main_textView1);
        TextView apiText2 = findViewById(R.id.activity_main_validate_input);
        apiText1.setMovementMethod(new ScrollingMovementMethod());


        Button submitButton = findViewById(R.id.activity_main_button_for_photo);


        EditText userNameInput = findViewById(R.id.activity_main_photoNum_input);



        btnTemp =(Button)findViewById(R.id.btnTemp);
        btnTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,login_screen.class);
                startActivity(i);
            }
        });




//        GetUserApi().getAllUsers().enqueue(new SlimCallback<List<User>>(users->{
//            apiText1.setText("");
//            for (int i = 0; i < users.size(); i++){
//                apiText1.append(users.get(i).printable());
//            }
//
//        }, "multipleUsersApi"));


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetUserApi().getUserByUsername(userNameInput.getText().toString()).enqueue(new SlimCallback<User>(user ->{
                    apiText1.setText(user.printable());
                }));
            }
        });

        

    }
}

