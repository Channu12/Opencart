package com.ecommerce.opencart.genericutility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility {

	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(IConstants.implicitTime, TimeUnit.SECONDS);
	}
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
}
