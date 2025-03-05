package com.webshop.tests;

import com.webshop.models.User;
import com.webshop.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if(app.getUser().isLoggedIn()){
            app.getUser().logout();
        }
    }

    @Test(enabled = false)
    public void registerNewUserPositiveTest() {
        //click on Register link
        app.getUser().clickOnRegistrationLink();
        //enter First Name
        //better to use id - IDs are faster and more stable, and the element has a unique ID
        // OR driver.findElement(By.xpath("//*[@id='FirstName']")); good for hierarchical or complex elements searches
        app.getUser().fillRegistrationForm(new User().setFirstName("Juli").setLastName("Tester").setEmail("juli777@gmail.com").
                setPassword("Qwerty1!$"));
        //click on Registration button
        app.getUser().confirmRegistration();

        Assert.assertFalse(app.getUser().isElementPresent(By.cssSelector(".login-button")));
        // Assert.assertFalse(app.getUser().isAccountPresent());
    }
}
