package com.ecommerce.opencart.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sdriver;
	public JavaUtility jLib = new JavaUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriverUtility wLib = new WebDriverUtility();

	@BeforeSuite
	public void configBS()
	{
		System.out.println("Connected to Database");
	}
	
	@BeforeTest
	public void configBT()
	{
		System.out.println("Configured BT");
	}
	
	@BeforeClass
	public void configBC() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wLib.maximizeWindow(driver);
		
		wLib.implicitWait(driver);
		driver.get(fLib.getDataFromPropertyFile("url"));
		sdriver = driver;
	}
	
	@BeforeMethod
	public void configBM()
	{
		
	}
	
	@AfterMethod
	public void configAM()
	{
		
	}
	
	@AfterClass
	public void configAC()
	{
		driver.quit();
	}
	
	@AfterTest
	public void configAT()
	{
		System.out.println("Configured AT");
	}
	
	@AfterSuite
	public void configAS()
	{
		System.out.println("Dis-Connected to Database");
	}
}
