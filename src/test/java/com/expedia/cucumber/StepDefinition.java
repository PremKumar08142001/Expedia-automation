package com.expedia.cucumber;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	
	WebDriver driver;
	@Before
	public void init() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https:expedia.co.in");
	}
	
	@After
	public void close() {
		
		driver.quit();
	}
	
	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() {
//		driver.navigate().to("https://www.expedia.co.in");
	}

	@When("the user clicks on the {string} link")
	public void the_user_clicks_on_the_link(String string) {
	    driver.findElement(By.xpath("//*[@id='app-layer-base']/div[1]/div[2]/div[2]/footer/div/div/ul[1]/li[5]/ul/li[1]/div/a")).click();
	}

	@Then("the {string} button should be displayed")
	public void the_button_should_be_displayed(String string) throws InterruptedException {
	    Thread.sleep(3000);
	    String expectedCancelYourTripURL = driver.getCurrentUrl();
	    String actualCancelYourTripURL = "https://www.expedia.co.in/service/";
	    
	    assertEquals(expectedCancelYourTripURL,actualCancelYourTripURL);
	    
	    assertTrue(true);
	    	
	}
}

