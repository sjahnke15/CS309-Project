package test.connect.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class Map extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
Button toHome;
Button toWildlife;
Button toTrailList;
Button toTrailInfo;
    boolean isPermissionGranted;
    GoogleMap mGoogleMap;
    FloatingActionButton fab;
    private FusedLocationProviderClient mlocationClient;
    private int GPS_REQUEST_CODE = 9001;

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
        fab = findViewById(R.id.fab);

        checkMyPermission();

        initMap();
        mlocationClient = new FusedLocationProviderClient(this);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCurrentLoc();
            }
        });

    }

    @SuppressLint("MissingPermission")
    private void getCurrentLoc() {
        mlocationClient.getLastLocation().addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                Location location = task.getResult();
                gotoLocation(location.getLatitude(), location.getLongitude());
            }
        })
    }

    private void gotoLocation(double latitude, double longitude) {
        LatLng LatLong = new LatLng(latitude, longitude);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(LatLong, 18);
        mGoogleMap.moveCamera(cameraUpdate);
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    private void initMap() {
        if (isPermissionGranted){
            if(isGPSenable()){
                SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.frag);
                supportMapFragment.getMapAsync(this);
            }
        }
    }

    private boolean isGPSenable(){
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        boolean enable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if(enable){
            return true;
        }
        else{
            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setTitle("GPS Permission")
                    .setMessage("GPS must be enabled to use this app. Please enable GPS")
                    .setPositiveButton("Yes", (dialogInterface, i) -> {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            //BELOW IS THE OLD WAY OF CODING THAT NO LONGER WORKS - NEEDS TO BE UPDATED (I DO NOT KNOW HOW THE NEW WAY WORKS)
                        startActivityForResult(intent, GPS_REQUEST_CODE);

                    })
                    .setCancelable(false)
                    .show();
        }
        return false;
    }

    private void checkMyPermission(){
        Dexter.withContext(this).withPermission(Manifest.permission.ACCESS_FINE_LOCATION).withListener(new PermissionListener(){

            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                Toast.makeText(Map.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                isPermissionGranted = true;
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

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        //mGoogleMap.setMyLocationEnabled(true);
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}