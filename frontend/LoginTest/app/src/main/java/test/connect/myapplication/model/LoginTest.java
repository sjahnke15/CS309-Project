package test.connect.myapplication.model;

/**
 * Elijah Hanson - Class containing a helper method for user login
 */
public class LoginTest{

    /**
     * Helper method for checking if a user can log in
     *
     * @param u user object based email or username
     * @param userEnteredPass password client entered into textbox
     * @return boolean output based on string comparison
     */
    public boolean canLogIn(User u, String userEnteredPass){
        String passwordfromDatabase = u.getPassword();
        if(passwordfromDatabase.equals(userEnteredPass)){
            return true;
        }
        return false;
    }
}
