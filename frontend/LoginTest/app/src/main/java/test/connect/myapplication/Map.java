package test.connect.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class Map extends AppCompatActivity {
Button toHome;
Button toWildlife;
Button toTrailList;
Button toTrailInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        int userID = intent.getIntExtra("userID", 0);

        toHome = (Button)findViewById(R.id.btnBackToHomeFromMap);
        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(Map.this, homeScreen.class);
                back.putExtra("username", username);
                back.putExtra("email", email);
                back.putExtra("password", password);
                back.putExtra("userID", userID);
                startActivity(back);
            }
        });

        toWildlife = (Button)findViewById(R.id.btnToWildlife);
        toWildlife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wildlife = new Intent(Map.this, Wildlife.class);
                wildlife.putExtra("username", username);
                wildlife.putExtra("email", email);
                wildlife.putExtra("password", password);
                wildlife.putExtra("userID", userID);
                startActivity(wildlife);
            }
        });

        toTrailList = (Button)findViewById(R.id.btnToTrailList);
        toTrailList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toTrailList = new Intent(Map.this, TrailList.class);
                toTrailList.putExtra("username", username);
                toTrailList.putExtra("email", email);
                toTrailList.putExtra("password", password);
                toTrailList.putExtra("userID", userID);
                startActivity(toTrailList);
            }
        });

        toTrailInfo = (Button)findViewById(R.id.btnToTrailInfo);
        toTrailInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toTrailInfo = new Intent(Map.this, TrailInfo.class);
                toTrailInfo.putExtra("username", username);
                toTrailInfo.putExtra("email", email);
                toTrailInfo.putExtra("password", password);
                toTrailInfo.putExtra("userID", userID);
                startActivity(toTrailInfo);
            }
        });

        checkMyPermission();
    }
    private void checkMyPermission(){
        Dexter.withContext(this).withPermission(Manifest.permission.ACCESS_FINE_LOCATION).withListener(new PermissionListener(){

            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                Toast.makeText(Map.this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", getPackageName(),"");
                intent.setData(uri);
                startActivity(intent);
            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }
        }).check();
    }
}