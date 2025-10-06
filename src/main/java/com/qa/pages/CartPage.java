package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	 private WebDriver driver;
	    private By cartItems = By.className("inventory_item_name");

	    public CartPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public int getCartItemCount() {
	        List<WebElement> items = driver.findElements(cartItems);
	        return items.size();
	    }

	    public void printCartItems() {
	        List<WebElement> items = driver.findElements(cartItems);
	        System.out.println("Items in Cart:");
	        for (WebElement item : items) {
	            System.out.println(" - " + item.getText());
	        }
	    }

	    public List<String> getCartItemNames() {
	        List<WebElement> items = driver.findElements(cartItems);
	        List<String> itemNames = new ArrayList<>();
	        for (WebElement item : items) {
	            itemNames.add(item.getText());
	        }

	        return itemNames;
	    }

}