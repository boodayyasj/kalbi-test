package com.kalbi.test.regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage{
	
	WebDriver driver;
		public HomePage(WebDriver driver)
		{
			this.driver=driver;
		}
		public WebElement getLogoutButton()
		{
			return driver.findElement(By.linkText("Logout"));
		}
		public void WaitForHomePageToLoad()
		{
		WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("container"))));
		}
	}


