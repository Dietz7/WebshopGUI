package com.webshop.tests;

import com.webshop.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getHomePage().isWelcomeComponentPresent()){
            app.getHomePage().clickOnLogo();
        }
    }
    @Test
    public void isWelcomeComponentPresentTest() {
        //System.out.println("WelcomeComponent " +isWelcomeComponentPresent());
        // driver.findElement(By.xpath("//h2")); we do not need this line because we call the method
        //isWelcomeComponentPresent();
        Assert.assertTrue(app.getHomePage().isWelcomeComponentPresent());
    }
}


