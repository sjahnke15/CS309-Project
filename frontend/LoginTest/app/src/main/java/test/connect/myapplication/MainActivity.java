package test.connect.myapplication;

import static test.connect.myapplication.api.ApiClientFactory.GetPhotoApi;
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
import test.connect.myapplication.model.Photo;
import test.connect.myapplication.model.User;

public class MainActivity extends AppCompatActivity {
Button btnTemp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView apiText1 = findViewById(R.id.activity_main_textView1);
        apiText1.setMovementMethod(new ScrollingMovementMethod());

        Button submitButton = findViewById(R.id.activity_main_button_for_photo);
        EditText userNumInput = findViewById(R.id.activity_main_photoNum_input);

        btnTemp =(Button)findViewById(R.id.btnTemp);
        btnTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,login_screen.class);
                startActivity(i);
            }
        });

//        GetPhotoApi().getFirstPhoto().enqueue(new SlimCallback<Photo>(responsePhoto -> {
//            apiText1.setText(responsePhoto.printable());
//        }));

//        GetPhotoApi().getAllPhoto().enqueue(new SlimCallback<List<Photo>>(photos->{
//            apiText1.setText("");
//            for (int i = 0; i < photos.size(); i++){
//                apiText1.append(photos.get(i).printable());
//            }
//
//        }, "multiplePhotosApi"));


//        photoButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GetPhotoApi().getPhotoByNum(photoNumInput.getText().toString()).enqueue(new SlimCallback<Photo>(photo ->{
//                    apiText1.setText(photo.printable());
//                }));
//            }
//        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetPhotoApi().getPhotoByNum(userNumInput.getText().toString()).enqueue(new SlimCallback<Photo>(photo ->{
                    apiText1.setText(photo.printable());

                }));
            }
        });

    }
}

