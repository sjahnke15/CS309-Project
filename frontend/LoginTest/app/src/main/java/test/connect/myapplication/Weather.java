package test.connect.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.connect.myapplication.api.ApiClient;
import test.connect.myapplication.api.WeatherApi;
import test.connect.myapplication.api.weather;


public class Weather extends AppCompatActivity {
    ImageView toHome;
    ImageView search;
    TextView tempText, descText, humidityText;
    EditText textField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        tempText = findViewById(R.id.tempText);
        descText = findViewById(R.id.descText);
        humidityText = findViewById(R.id.humidityText);
        toHome = (ImageView)findViewById(R.id.btnBackHomeFromWeather);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        int userID = intent.getIntExtra("userID", 0);

        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(Weather.this, homeScreen.class);
                back.putExtra("username", username);
                back.putExtra("email", email);
                back.putExtra("password", password);
                back.putExtra("userID", userID);
                String temp = tempText.getText().toString();
                back.putExtra("Message_key", temp);
                startActivity(back);
            }
        });
        search = findViewById(R.id.search);
        textField = findViewById(R.id.textField);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                getWeather(textField.getText().toString().trim());

            }
        });
    }
    private void getWeather(String name) {

        WeatherApi apiInterface = ApiClient.getClient().create(WeatherApi.class);
        //GetWeatherApi().getWeatherData(textField.getText().toString()).enqueue(new SlimCallback<Main>(weather ->{
            //tempText.setText("Temp" + " " + weather.getTemp() + " F");
            //descText.setText("Feels Like" + " " + response.body().getMain().getFeels_like()+ " F");
            //humidityText.setText("Humidity" + " " + response.body().getMain().getHumidity()+ "%");
        //}
        Call<weather> call = apiInterface.getWeatherData(name);

        call.enqueue(new Callback<weather>() {
            @Override
            public void onResponse(Call<weather> call, Response<weather> response) {
                //tempText = findViewById(R.id.tempText);
                //descText = findViewById(R.id.descText);
                //humidityText = findViewById(R.id.humidityText);
                try {
                    tempText.setText("Temp" + " " + response.body().getMain().getTemp() + " F");
                    descText.setText("Feels Like" + " " + response.body().getMain().getFeels_like()+ " F");
                    humidityText.setText("Humidity" + " " + response.body().getMain().getHumidity()+ "%");
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<weather> call, Throwable t) {

            }
        });

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}