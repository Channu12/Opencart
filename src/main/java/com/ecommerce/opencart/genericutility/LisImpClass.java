package com.ecommerce.opencart.genericutility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LisImpClass implements ITestListener {

	ExtentSparkReporter sparkReporter;
	ExtentReports reports;
	ExtentTest test;

	public void onStart(ITestContext context) {

		String currentTimeAndDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		sparkReporter = new ExtentSparkReporter("./Reports/MyReport"+currentTimeAndDate+".html");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Extent Report");
		sparkReporter.config().setTheme(Theme.DARK);

		reports = new ExtentReports();
		reports.attachReporter(sparkReporter);
		reports.setSystemInfo("OS", "Windows");
		reports.setSystemInfo("Name", "Channa");
	}

	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" is PASSED");
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is FAILED");
		test.log(Status.FAIL, result.getThrowable());
		
		String path = getScreenshot(BaseClass.sdriver);
		test.addScreenCaptureFromBase64String(path);
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is SKIPPED");
	}

	public void onFinish(ITestContext context) {
		reports.flush();
	}

	public String getScreenshot(WebDriver driver)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		return ts.getScreenshotAs(OutputType.BASE64);
	}
}
