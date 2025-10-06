package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.CartPage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;
import com.qa.utils.ScreenshotUtil;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import java.util.List;

public class CartTest extends BaseTest {

    @Test
    public void verifyAddToCart() {
        // Create a test in ExtentReports
        ExtentTest test = extent.createTest("Verify Add to Cart");

        // Step 1: Login
        test.info("Logging in with standard_user");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        test.pass("Login successful");

        // Step 2: Add item to cart
        test.info("Adding 'Sauce Labs Backpack' to cart");
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addItemToCart("Sauce Labs Backpack");
        test.pass("'Sauce Labs Backpack' added to cart");

        // Step 3: Go to Cart
        test.info("Navigating to Cart page");
        productsPage.goTOCart();
        test.pass("Navigated to Cart page");

        // Step 4: Verify item in cart
        test.info("Verifying item in cart");
        CartPage cartPage = new CartPage(driver);
        List<String> itemNames = cartPage.getCartItemNames();
        boolean found = itemNames.stream().anyMatch(name -> name.contains("Backpack"));
        if (found) {
            test.pass("Item found in cart: 'Backpack'");
        } else {
            test.fail("Item not found in cart!");
        }

        Assert.assertTrue(found, "Item not found in cart!");
        
        try {
            Assert.assertTrue(found, "Item not found in cart!");
            test.pass("Item found in cart: 'Backpack'");
        } catch (AssertionError e) {
            String path = ScreenshotUtil.takeScreenshot(driver, "CartTest_Failure");
            test.fail("Item not found in cart!", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
            throw e; // re-throw to fail the test
        }
    }
}
