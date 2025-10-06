package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
	private WebDriver driver;
	private By productTitles = By.className("inventory_item_name");
	private By AddToCartbuttons = By.xpath("//button[contains(@id,'add-to-cart')]");
	private By cartIcon = By.className("shopping_cart_link");
	
	public ProductsPage(WebDriver driver) {
		this.driver= driver;
	}
	//get all product names
	public List<WebElement>getAllProducts()
	{
		return driver.findElements(productTitles);
	}
	//get all products to cart
	public void addAllProductsTOCart()
	{
	    List<WebElement>addButtons = driver.findElements(AddToCartbuttons);
		System.out.println("Number of Products : "+addButtons.size());
		for(WebElement element : addButtons)
		{
			element.click();
		}
		System.out.println("All proucts added to cart");
	}
	public void goTOCart()
	{
		driver.findElement(cartIcon).click();
	}
	public void addItemToCart(String itemName) {
	    // Locate all products on the page
	    List<WebElement> items = driver.findElements(By.className("inventory_item"));

	    for (WebElement item : items) {
	        String name = item.findElement(By.className("inventory_item_name")).getText();
	        if (name.equalsIgnoreCase(itemName)) {
	            // Find and click the "Add to cart" button for this item
	            WebElement addButton = item.findElement(By.tagName("button"));
	            addButton.click();
	            System.out.println(itemName + " added to the cart.");
	            return;
	        }
	    }

	    System.out.println("Item not found: " + itemName);
	}

}