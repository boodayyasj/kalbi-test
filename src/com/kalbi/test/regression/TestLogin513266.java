package com.kalbi.test.regression;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kalbi.lib.ui.LoginPage;
import com.kalbi.lib.util.DataHandlers;
import com.kalbi.test.config.CreateDriver;

public class TestLogin513266 {
	WebDriver driver;
	LoginPage login;
	HomePage home;
	@BeforeMethod
	public void preCondition()
	{
	driver=CreateDriver.getDriverInstance();
	login=new LoginPage(driver);
	home=new HomePage(driver);
	}
	@AfterMethod 
	public void postCondition()
	{
		driver.close();
	}
	@Test
	public void testvalidLoginTC135467()
	{
		String un=DataHandlers.getDataFromExcel("data","TC135467",1,0);
		String pwd=DataHandlers.getDataFromExcel("data","TC135467",1,1);
		login.WaitForLoginPagetoLoad();
		login.getUsernameTextbox().sendKeys(un);
		login.getPasswordTextbox().sendKeys(pwd);
		login.getLoginButton().click();
		home.WaitForHomePageToLoad();
		boolean actualStatus=home.getLogoutButton().isDisplayed();
		Assert.assertEquals(actualStatus, true);
		home.getLogoutButton().click();
		login.WaitForLoginPagetoLoad();
		
	}

}
