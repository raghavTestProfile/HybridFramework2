package com.qa.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentListener implements ITestListener {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	public void configureReport() {

		String stamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "Z99Project-" + stamp + ".html";

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//ExtentReports//" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		reports.setSystemInfo("OS", System.getProperty("os.name"));
		reports.setSystemInfo("Username", System.getProperty("user.name"));
		reports.setSystemInfo("Java Version", System.getProperty("java.version"));

		htmlReporter.config().setDocumentTitle("Tutorials Ninja");

		htmlReporter.config().setReportName("Entent Report for tutorials ninja website");

	}

	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		test = reports.createTest(result.getName());
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		test = reports.createTest(result.getMethod().getMethodName());

		test.log(Status.INFO, result.getThrowable());
		test.log(Status.FAIL, "Test Failed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		test = reports.createTest(result.getMethod().getMethodName());

		test.log(Status.INFO, result.getThrowable());
		test.log(Status.SKIP, "Test Skipped" + ExtentColor.YELLOW);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

		configureReport();

	}

	@Override
	public void onFinish(ITestContext context) {

		reports.flush();

	}

}
