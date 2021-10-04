package test.connect.myapplication.model;

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

    public String printable(){
        return "\nUsername: " + this.username
                + "\nEmail: " + this.email
                + "\nPassword: "+ this.password
                + "\nID: " + this.id;
    }
}


