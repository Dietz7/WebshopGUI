package com.webshop.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteItemTests extends TestBase {
    @BeforeMethod()
    public void ensurePrecondition() {
        if (app.getUser().isLoggedIn()) {
            app.getUser().logout();
        }
    }

    @Test
    public void deleteItemPositiveTest(){
        // app.getUser().confirmLogin();
        //select the second product on the page and add to the cart
        app.getItem().addSelectedItemToCart();

        app.getItem().navigateToShoppingCart();

        int sizeBefore = app.getItem().sizeOfItems();
        app.getItem().removeItem();
        app.getItem().pause(1000);
        int sizeAfter = app.getItem().sizeOfItems();

        Assert.assertEquals(sizeAfter, sizeBefore);

    }

}
