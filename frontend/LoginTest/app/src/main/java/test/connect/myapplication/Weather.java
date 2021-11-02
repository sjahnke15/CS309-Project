package test.connect.myapplication;

import static test.connect.myapplication.api.ApiClient.GetWeatherApi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.connect.myapplication.api.ApiClient;
import test.connect.myapplication.api.ApiClientFactory;
import test.connect.myapplication.api.Main;
import test.connect.myapplication.api.SlimCallback;
import test.connect.myapplication.api.UserApi;
import test.connect.myapplication.api.WeatherApi;
import test.connect.myapplication.api.weather;
import test.connect.myapplication.model.User;


public class Weather extends AppCompatActivity {
Button toHome;
ImageView search;
TextView tempText, descText, humidityText;
EditText textField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        toHome = (Button)findViewById(R.id.btnBackHomeFromWeather);
        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(Weather.this, homeScreen.class);
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
         //   tempText.setText("Temp" + " " + weather.getTemp() + " F");
         //   descText.setText("Feels Like" + " " + response.body().getMain().getFeels_like()+ " F");
         //   humidityText.setText("Humidity" + " " + response.body().getMain().getHumidity()+ "%");
        //}
        Call<weather> call = WeatherApi.getWeatherData(name);

        call.enqueue(new Callback<weather>() {
            @Override
            public void onResponse(Call<weather> call, Response<weather> response) {
                tempText = findViewById(R.id.tempText);
                descText = findViewById(R.id.descText);
                humidityText = findViewById(R.id.humidityText);
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