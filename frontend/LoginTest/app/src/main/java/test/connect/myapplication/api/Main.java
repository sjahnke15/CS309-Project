package test.connect.myapplication.api;
import com.google.gson.annotations.SerializedName;

/**
 * Daniel - The main method consists of getter and setter methods for the parts needed of the current weather.
 * This is used to make sure that the information is grabbed correctly from the API and can then further be used in code.
 */
public class Main {


    @SerializedName("temp")
    String temp;

    public Main() {
    }

    @SerializedName("humidity")
    String humidity;

    @SerializedName("feels_like")
    String feels_like;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(String feels_like) {
        this.feels_like = feels_like;
    }
}