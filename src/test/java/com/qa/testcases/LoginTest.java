package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.LoginPage;

public class LoginTest extends BaseTest {
	@Test
	public void verifyvalidLogin()
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user","secret_sauce");
	}
  @Test
  public void verifyInvalidLogin() {
      LoginPage loginPage = new LoginPage(driver);
      loginPage.login("wrong_user", "wrong_pass");

      String error = loginPage.getErrorMsg();
      Assert.assertTrue(error.contains("Epic sadface"), "Error message not displayed!");
  }


}
