package test.connect.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

import test.connect.myapplication.model.User;
import test.connect.myapplication.model.LoginTest;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void loginTestSuccess() {
        LoginTest logintest = new LoginTest();

        String password = "Password";
        User user = new User();
        user.setUsername("Eijah Hanson");
        user.setPassword("Password");
        assertEquals(true, logintest.canLogIn(user, password));

    }
    @Test
    public void loginTestFail() {
        LoginTest logintest = new LoginTest();

        String password = "BadPassword";
        User user = new User();
        user.setUsername("Eijah Hanson");
        user.setPassword("Password");
        assertEquals(true, logintest.canLogIn(user, password));

    }
}