package com.webshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartHelper extends BaseHelper{
    public CartHelper(WebDriver driver) {
        super(driver);
    }

    public void navigateToShoppingCart() {
        click(By.cssSelector("a.ico-cart"));
    }

    public void addSelectedItemToCart() {
        click(By.xpath("//input[contains(@onclick, '/catalog/31/')]"));
    }

    public void removeItem() {
        click(By.cssSelector("input[name='removefromcart']"));
        click(By.cssSelector("input[name='updatecart']"));
    }

    public boolean isItemAddedByText(String text) {
        List<WebElement> items = driver.findElements(By.cssSelector("td.product a"));
        for (WebElement element : items) {
            if (element.getText().contains(text)) return true;
        }
        return false;
    }

    public int sizeOfItems(){
        if(isElementPresent(By.cssSelector("input[name='removefromcart']"))){
            return driver.findElements(By.cssSelector("tr.cart-item")).size();
        }
        return 0;
    }

    public boolean isLoggedIn() {
        return isElementPresent(By.cssSelector(".ico-logout"));
    }

    public void logout() {
        click(By.cssSelector(".ico-logout"));
    }
}
