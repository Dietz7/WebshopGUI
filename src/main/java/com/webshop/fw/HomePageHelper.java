package com.webshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper{
    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isWelcomeComponentPresent() {
        //return driver.findElements(By.xpath("//h2")).size() > 0;
        return isElementPresent(By.xpath("//h2"));
    }


    public void clickOnLogo() {
        click(By.cssSelector(".header-logo a"));
    }
}
