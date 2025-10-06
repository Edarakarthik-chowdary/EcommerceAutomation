package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	public WebDriver driver;
	
	private By usernameField = By.id("user-name");
	private By PasswordField = By.id("password");
	private By LoginBtn = By.id("login-button");
	private By errorMsg = By.cssSelector("h3[data-test='error']");
	public LoginPage(WebDriver driver) {
		this.driver= driver;
	}
		
		public void login(String username,String password)
		{
			driver.findElement(usernameField).sendKeys(username);
			driver.findElement(PasswordField).sendKeys(password);
			driver.findElement(LoginBtn).click();
		}
		public String getErrorMsg()
		{
			return driver.findElement(errorMsg).getText();
		}
}