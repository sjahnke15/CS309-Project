package test.connect.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class homeScreen extends AppCompatActivity {
    Button btnBack;
    Button btnUserInfo;
    Button map;
    Button weather;
    TextView testingText;
    TextView userTemp;
    private static final String TAG = "GoogleMaps";
    private static final int ERROR_DIALOG_REQUEST = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        String temp = getIntent().getStringExtra("Message_key");
        userTemp = (TextView)findViewById(R.id.txtUserTemp);
        userTemp.setText(temp);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        int userID = intent.getIntExtra("userID", 0);



        testingText = findViewById(R.id.activity_home_screen_testTextView);
//        GetReviewApi().getReviewByUserID(userID).enqueue(new SlimCallback<List<Review>>(reviews->{
//            testingText.setText("");
//            for (int i = 0; i < reviews.size(); i++){
//                testingText.append(reviews.get(i).printable());
//            }
//
//        }, "multipleUsersApi"));



        btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(homeScreen.this,login_screen.class);
                back.putExtra("username", username);
                back.putExtra("email", email);
                back.putExtra("password", password);
                back.putExtra("userID", userID);
                startActivity(back);
            }
        });

        btnUserInfo = (Button)findViewById(R.id.activity_home_screen_toUser);
        btnUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userInfo = new Intent(homeScreen.this,UserInfo.class);
                userInfo.putExtra("username", username);
                userInfo.putExtra("email", email);
                userInfo.putExtra("password", password);
                userInfo.putExtra("userID", userID);
                startActivity(userInfo);
            }
        });

        map = (Button)findViewById(R.id.btnToMap);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMap = new Intent(homeScreen.this, GoogleMaps.class);
                toMap.putExtra("username", username);
                toMap.putExtra("email", email);
                toMap.putExtra("password", password);
                toMap.putExtra("userID", userID);
                startActivity(toMap);
            }
        });

        weather = (Button)findViewById(R.id.btnToWeather);
        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toWeather = new Intent(homeScreen.this, Weather.class);
                toWeather.putExtra("username", username);
                toWeather.putExtra("email", email);
                toWeather.putExtra("password", password);
                toWeather.putExtra("userID", userID);
                startActivity(toWeather);

            }
        });

       // imgAccount.setOnClickListener(new View.OnClickListener() {
       //     @Override
       //     public void onClick(View view) {
       //         Intent user = new Intent(homeScreen.this, userInfo.class);
       //         startActivity(user);
        //    }
       // });

       // map.setOnClickListener(new View.OnClickListener() {
       //     @Override
       //     public void onClick(View view) {
       //         Intent toMap = new Intent(homeScreen.this,map.class);
        //        startActivity(toMap);
        //    }
        //});

        if (isServicesOk()){
            init();
        }
    }
    private void init(){
        map = (Button) findViewById(R.id.btnToMap);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homeScreen.this, GoogleMaps.class);
                startActivity(intent);
            }
        });
    }

    public boolean isServicesOk(){
        Log.d(TAG, "isServicesOK: checking google maps availability");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(homeScreen.this);

        if(available == ConnectionResult.SUCCESS){
            Log.d(TAG, "isServiceOk: Google Maps is working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            Log.d(TAG, "isServiceOk: An error caused Google Maps to stop working, but we resolved it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(homeScreen.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }
        else{
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}