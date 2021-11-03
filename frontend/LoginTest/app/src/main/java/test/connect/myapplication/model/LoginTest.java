package test.connect.myapplication.model;

public class LoginTest{


    public boolean canLogIn(User u, String userEnteredPass){
        String passwordfromDatabase = u.getPassword();
        if(passwordfromDatabase.equals(userEnteredPass)){
            return true;
        }
        return false;
    }
}
