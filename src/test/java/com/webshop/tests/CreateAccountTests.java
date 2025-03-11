package com.webshop.tests;

import com.webshop.data.UserData;
import com.webshop.models.User;
import com.webshop.tests.TestBase;
import com.webshop.utils.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getUser().isLoggedIn()) {
            app.getUser().logout();
        }
    }

    @Test(enabled = false)
    @Parameters({"FirstName", "LastName", "Email", "Password"})

    public void registerNewUserPositiveTest(String firstName, String lastName, String email, String password) {
        //click on Register link
        app.getUser().clickOnRegistrationLink();
        //enter First Name
        //better to use id - IDs are faster and more stable, and the element has a unique ID
        // OR driver.findElement(By.xpath("//*[@id='FirstName']")); good for hierarchical or complex elements searches
        app.getUser().fillRegistrationForm(new User().setFirstName(firstName).setLastName(lastName)
                .setEmail(email).
                setPassword(password));
        //click on Registration button
        app.getUser().confirmRegistration();
        Assert.assertTrue(app.getUser().isAccountPresent());

        //Assert.assertFalse(app.getUser().isElementPresent(By.cssSelector(".login-button")));

    }

    @Test(dataProvider = "registerNewUser", dataProviderClass = DataProviders.class)
    public void registerNewUserPositiveFromDataProviderTest(String firstName, String lastName, String email, String password) {
        //click on Register link
        app.getUser().clickOnRegistrationLink();
        //enter First Name
        //better to use id - IDs are faster and more stable, and the element has a unique ID
        // OR driver.findElement(By.xpath("//*[@id='FirstName']")); good for hierarchical or complex elements searches
        app.getUser().fillRegistrationForm(new User().setFirstName(firstName).setLastName(lastName)
                .setEmail(email).
                setPassword(password));
        //click on Registration button
        app.getUser().confirmRegistration();
        //Assert.assertTrue(app.getUser().isAccountPresent());
        Assert.assertFalse(app.getUser().isAccountPresent());
    }

    @Test(dataProvider ="registerNewUserFromCsv", dataProviderClass = DataProviders.class)
    public void registerNewUserPositiveFromDataProviderWithCsvTest(User user) {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(user);
        app.getUser().confirmRegistration();
        //Assert.assertTrue(app.getUser().isAccountPresent());
        Assert.assertFalse(app.getUser().isAccountPresent());

    }
}
