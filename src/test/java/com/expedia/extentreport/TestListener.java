package com.expedia.extentreport;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	@Override
	public void onTestSkipped(ITestResult itr) {

		try {
			ReportGen.finishReportAfterTest(itr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
