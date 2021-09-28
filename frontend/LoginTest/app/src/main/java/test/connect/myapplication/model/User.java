package test.connect.myapplication.model;

public class User {
    private String username;
    private String password;

    public User() {
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

    public String printable(){
        return "\nUsername: " + this.username
                + "\nPassword: "+ this.password;
    }
}


