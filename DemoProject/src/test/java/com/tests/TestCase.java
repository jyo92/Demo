package com.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.DemoClass;

public class TestCase 
{
	public ExtentReports report;
	public ExtentTest logger;
	public String path = "./Reports/ProjectReport.html";
	DemoClass dc = new DemoClass();
	
	@BeforeTest
	public void start()
	{
		report = new ExtentReports(path, true);
	}
	@Test
	public void test9()
	{
		logger = report.startTest("test9");
		Assert.assertTrue(dc.trueMethod());
		logger.log(LogStatus.PASS, "test9 passed");
	}
	
	@Test
	public void test10()
	{
		logger = report.startTest("test10");
		Assert.assertTrue(dc.falseMethod());
		logger.log(LogStatus.PASS, "test10 passed");
	}
	
	@AfterMethod
    public void getResult(ITestResult result) throws IOException
    {
    	if(result.getStatus()==ITestResult.FAILURE)
    	{
    		logger.log(LogStatus.FAIL, result.getName()+" failed");
    	}
    	report.endTest(logger);
    	report.flush();
    }
}
