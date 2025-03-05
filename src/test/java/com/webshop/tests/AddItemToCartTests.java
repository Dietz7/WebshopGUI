package com.webshop.tests;

import com.webshop.models.User;
import com.webshop.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

    @BeforeMethod()
    public void ensurePrecondition() {
        if (!app.getUser().isLoggedIn()) {
            app.getUser().clickOnLoginLink();
            app.getUser().fillLoginFields(new User().setEmail("juli777@gmail.com").setPassword("Qwerty1!$"));
            app.getUser().confirmLogin();
        }
    }

    @Test
    public void addItemPositiveTest() {
        app.getItem().addSelectedItemToCart();
        app.getItem().navigateToShoppingCart();
        Assert.assertTrue(app.getItem().isItemAddedByText("14.1-inch Laptop"));

        //Assert.assertTrue(isElementPresent(By.xpath("//td[@class='product']/a[contains(text(), '14.1-inch Laptop')]")),
        //  "Product was not found in the cart");

    }

    @AfterMethod
    public void postCondition() {
        app.getItem().removeItem();

    }

}