package com.kalbi.test.smoke;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kalbi.lib.ui.LoginPage;
import com.kalbi.lib.util.DataHandlers;
import com.kalbi.test.config.CreateDriver;

public class TestLogin513265 {
	WebDriver driver;
	LoginPage login;
	@BeforeMethod
	public void preCondition()
	{
	driver=CreateDriver.getDriverInstance();
	login=new LoginPage(driver);
	}
	@AfterMethod 
	public void postCondition()
	{
		driver.close();
	}
	@Test
	public void testInvalidLoginTC135462()
	{
		String un=DataHandlers.getDataFromExcel("data","TC135462",1,0);
		String pwd=DataHandlers.getDataFromExcel("data","TC135462",1,1);
		login.WaitForLoginPagetoLoad();
		login.getUsernameTextbox().sendKeys(un);
		login.getPasswordTextbox().sendKeys(pwd);
		login.getLoginButton().click();
		String actualErrorMsg=login.getLoginErrorMsg().getText();
		String ExpectedErrorMsg="Username or Password is invalid. Please try again.";
		Assert.assertEquals(actualErrorMsg, ExpectedErrorMsg);
	}
}
