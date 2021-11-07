package test.connect.myapplication.api;
import com.google.gson.annotations.SerializedName;

public class weather {

    @SerializedName("main")
    private Main main;

    /**
     * Daniel
     * getMain() is taking all the information from the Main.java class and allows for teh information to be used.
     * @return returns all inforamtion from Main.java
     */
    public Main getMain() {
        return main;
    }

    /**
     * Daniel
     * setMain will make sure than Main.java is always consistent and information aligns the way we need
     * @param main
     */
    public void setMain(Main main) {
        this.main = main;
    }
}
