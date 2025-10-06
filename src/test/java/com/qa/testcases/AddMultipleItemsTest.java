package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.CartPage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;

public class AddMultipleItemsTest extends BaseTest {
	@Test
    public void verifyAddingAllItemsToCart() {
        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Add all products
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addAllProductsTOCart();
        productsPage.goTOCart();

        // Verify cart
        CartPage cartPage = new CartPage(driver);
        cartPage.printCartItems();

        int totalItems = cartPage.getCartItemCount();
        System.out.println("Total items added to cart: " + totalItems);

        Assert.assertEquals(totalItems, 6, "All products were not added to the cart!");
    }
}