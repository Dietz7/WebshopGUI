package com.webshop.fw;

import com.webshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountPresent() {
        return isElementPresent(By.xpath("//a[@class='account' and contains(text(), '@')]"));
    }

    public void confirmRegistration() {
        click(By.cssSelector("[name='register-button']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.cssSelector("#FirstName"), user.getFirstName());
        type(By.cssSelector("#LastName"), user.getLastName());
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.cssSelector("#Password"), user.getPassword());
        type(By.cssSelector("#ConfirmPassword"), user.getPassword());
    }

    public void clickOnRegistrationLink() {
        click(By.cssSelector("[href='/register']"));
    }

    //New overloaded login method
    //public void login() {
       // User defaultUser = new User().setEmail("juli777@gmail.com").setPassword("Qwerty1!$");
      //  login(defaultUser); // Calls existing login(User user) method
    //}

   // public void login(User user) {
       // clickOnLoginLink();

       // fillLoginFields(user);
   // }

    public void fillLoginFields(User user) {
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.cssSelector("#Password"), user.getPassword());
    }


    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void confirmLogin() {
        click(By.cssSelector(".login-button"));
    }

    public boolean isLoggedIn() {
        return isElementPresent(By.cssSelector(".ico-logout"));
    }

    public void logout() {
        click(By.cssSelector(".ico-logout"));
    }

}