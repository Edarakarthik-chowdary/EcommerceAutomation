package com.qa.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	 static ExtentReports extent;

	    public static ExtentReports getReportObject() {
	        String path = System.getProperty("user.dir") + "/reports/extentReport.html";
	        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	        reporter.config().setReportName("Ecommerce Automation Results");
	        reporter.config().setDocumentTitle("Test Results");

	        extent = new ExtentReports();
	        extent.attachReporter(reporter);
	        extent.setSystemInfo("Tester", "Karthik");
	        return extent;
	    }
}