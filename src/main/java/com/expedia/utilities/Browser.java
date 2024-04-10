package com.expedia.utilities;
import org.openqa.selenium.WebDriver;

import com.expedia.base.TestBase;


public class Browser extends TestBase {
	public Browser(){
		super();
	}
	public static void goTo(String url) {
		driver.get(url);
	}
	public static void close() {
		driver.close();
	}	
	public static WebDriver Driver() {
		return driver;
	}
	
	
	
	
	
}
