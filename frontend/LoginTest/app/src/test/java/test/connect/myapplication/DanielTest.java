package test.connect.myapplication;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import test.connect.myapplication.model.LoginTest;
import test.connect.myapplication.model.Review;
import test.connect.myapplication.model.User;

public class DanielTest {
    @Test
    public void loginTestSuccess() {
        LoginTest logintest = new LoginTest();

        String password = "Password";
        User user = new User();
        user.setUsername("Daniel");
        user.setPassword("Password");
        assertEquals(true, logintest.canLogIn(user, password));

    }
    @Test
    public void loginTestFail() {
        LoginTest logintest = new LoginTest();

        String password = "ThisWorks";
        User user = new User();
        user.setUsername("Chrisman");
        user.setPassword("Password");
        assertEquals(false, logintest.canLogIn(user, password));

    }

    @Test
    public void userInfo(){
        User user = new User();
        user.setId(5);
        user.setPassword("ThisWorks");
        user.setEmail("dc4229@iastate.edu");
        user.setUsername("Daniel");
        assertEquals(true, user.getId()==5);
        assertEquals(false, user.getPassword()=="Wrong");
        assertEquals(true, user.getEmail()=="dc4229@iastate.edu");
        assertEquals(false, user.getUsername()=="daniel");
    }

    @Test
    public void userReview(){
        Review review = new Review();
        review.setText("This was amazing");
        assertEquals(true, review.getText()=="This was amazing");

    }

    @Test
    public void gettingID(){
        Review review = new Review();
        review.setReviewID(12);
        assertEquals(true, review.getReviewID()==12);
    }
}
