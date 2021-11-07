package test.connect.myapplication.model;

/**
 * Daniel
 * The user class consists of getter and setter methods to get all the information related to the user such as email, username, password and user ID
 */
public class User {
    private String email;
    private String username;
    private String password;
    private int id;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Daniel
     * printable() will display all the users information that was taken from above getter and setter methods.
     * @return returns all information taken in
     */
    public String printable(){
        return "\nUsername: " + this.username
                + "\nEmail: " + this.email
                + "\nPassword: "+ this.password
                + "\nID: " + this.id;
    }
}


