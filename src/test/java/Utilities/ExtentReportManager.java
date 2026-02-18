package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
//import java.net.URL;
import java.net.URL;

//Extent report 5.x...//version

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import testBase.BaseClass;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;


	public void onStart(ITestContext testContext){

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		sparkReporter = new ExtentSparkReporter(".\\reports\\+ "+ "Execution Report_"+timeStamp+".html");
		sparkReporter.config().setDocumentTitle("Automation Execution Report");
		sparkReporter.config().setReportName("Regression Testing");
		sparkReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application Name","Amazon");
		extent.setSystemInfo("Functionality","Search");
		extent.setSystemInfo("Username",System.getProperty("user.name"));
		extent.setSystemInfo("Environment","Test");

		extent.setSystemInfo("Browser",testContext.getCurrentXmlTest().getParameter("browser"));
		extent.setSystemInfo("Groups",testContext.getCurrentXmlTest().getIncludedGroups().toString());

	}

	public void onTestSuccess(ITestResult result){

		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getMethod().getMethodName() + " executed successfully");

	}
	public void onTestFailure(ITestResult result){
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getTestName() + " execution is failed");


        String imagePath = new BaseClass().captureScreen(result.getName());
		test.addScreenCaptureFromPath(imagePath);


	}

	public void onTestSkipped(ITestResult result){
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getTestName() + " got  skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}


	public void onFinish(ITestContext testContext){
      extent.flush();
	}





}
