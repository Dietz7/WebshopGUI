package com.webshop.tests;

import com.webshop.data.UserData;
import com.webshop.models.User;
import com.webshop.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod()
    public void ensurePrecondition() {
        if (app.getUser().isLoggedIn()) {
            app.getUser().logout();
        }
    }
    //User user = new User().setEmail("juli777@gmail.com").setPassword("Qwerty1!$");
    //app.getUser().login(user);


    @Test()
    public void loginPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginFields(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().confirmLogin();
        Assert.assertTrue(app.getUser().isAccountPresent());
        // Log out :)
        //click(By.cssSelector("a.ico-logout[href='/logout"));
    }

    @Test(groups = "negative")
    public void loginNegativeWithoutEmailTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginFields(new User().setPassword(UserData.PASSWORD));
        app.getUser().confirmLogin();
        Assert.assertFalse(app.getUser().isAccountPresent());

    }

}

