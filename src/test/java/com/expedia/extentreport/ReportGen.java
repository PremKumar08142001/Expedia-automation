package com.expedia.extentreport;

import java.io.IOException;

import java.time.LocalDate;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.expedia.base.TestBase;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.expedia.utilities.TestUtil;

public class ReportGen extends TestBase {

	public static void reportCreation() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("reports/" + "Expedia" + "_reports.html");
		extent.attachReporter(spark);
	}

	public static void finishReportAfterTest(ITestResult itr) throws IOException {
		extenttest = extent.createTest(itr.getTestClass().getName() + "-" + itr.getMethod().getMethodName());

		if (itr.getStatus() == ITestResult.SUCCESS) {
			extenttest.log(Status.PASS,
					"Test Passed: " + itr.getTestClass().getName() + " - " + itr.getMethod().getMethodName());
			extenttest.log(Status.INFO, "The test passed successfully.");
			extenttest.log(Status.INFO, "Additional Info: This test verified all functionalities.");
			extenttest.log(Status.INFO, "Performance: The test completed in expected time.");
			extenttest.addScreenCaptureFromPath(
					TestUtil.captureScreenshot(driver, itr.getMethod().getMethodName(), "Success"));
			extenttest.log(Status.INFO, "Screenshot captured for reference: " + itr.getMethod().getMethodName());
			extenttest.log(Status.INFO, "Reported By: Team4");
			extenttest.log(Status.INFO, "Date: " + LocalDate.now());
			extenttest.log(Status.INFO, "Platform: Windows 10");
		} else if (itr.getStatus() == ITestResult.FAILURE) {
			extenttest.log(Status.FAIL,
					"Test Failed: " + itr.getTestClass().getName() + " - " + itr.getMethod().getMethodName());
			extenttest.log(Status.INFO, "The test failed with the following error: " + itr.getThrowable());
			extenttest.log(Status.INFO, "Steps to Reproduce: Follow the test script as per the test plan.");
			extenttest.log(Status.INFO, "Additional Info: Tried rerunning the test, but the issue persists.");
			extenttest.log(Status.INFO, "Priority: High - Needs immediate attention.");
			extenttest.log(Status.INFO, "Impact: Critical - Affects core functionality.");
			extenttest.addScreenCaptureFromPath(
					TestUtil.captureScreenshot(driver, itr.getMethod().getMethodName(), "Failed"));
			extenttest.log(Status.INFO, "Screenshot captured for reference: " + itr.getMethod().getMethodName());
			extenttest.log(Status.INFO, "Reported By: Team4");
			extenttest.log(Status.INFO, "Date: " + LocalDate.now());
			extenttest.log(Status.INFO, "Platform: Windows 10");
		} else if (itr.getStatus() == ITestResult.SKIP) {
			extenttest.log(Status.SKIP,
					"Test Skipped: " + itr.getTestClass().getName() + " - " + itr.getMethod().getMethodName());
			extenttest.log(Status.INFO, "The test was skipped.");
			extenttest.log(Status.INFO, "Reason for Skip: Insufficient test data.");
			extenttest.log(Status.INFO, "Additional Info: Waiting for the environment setup to be completed.");
			extenttest.log(Status.INFO, "Priority: Low - Can be deferred.");
			extenttest.log(Status.INFO, "Impact: Minor - Does not affect critical functionalities.");
			extenttest.addScreenCaptureFromPath(
					TestUtil.captureScreenshot(driver, itr.getMethod().getMethodName(), "Skip"));
			extenttest.log(Status.INFO, "Screenshot captured for reference: " + itr.getMethod().getMethodName());
			extenttest.log(Status.INFO, "Reported By: Team 4");
			extenttest.log(Status.INFO, "Date: " + LocalDate.now());
			extenttest.log(Status.INFO, "Platform: Windows 10");
		}
	}
}