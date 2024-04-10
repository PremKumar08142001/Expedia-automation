package com.expedia.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.expedia.webdrivers.WebDriverFactory;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	String projectpath = System.getProperty("user.dir");
	public static WebDriverWait wait;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest extenttest;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fileInputStream = new FileInputStream(projectpath + "/config/config.properties");
			prop.load(fileInputStream);
		} catch (IOException io) {
			System.out.println("Exception thrown at TestBase Constructor");
		}
	}

	@SuppressWarnings("deprecation")
	public static void initialization() {

		String browserName = prop.getProperty("browser.name");
		driver = WebDriverFactory.getInstance(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		driver.get(prop.getProperty("site.url"));
	}

}
