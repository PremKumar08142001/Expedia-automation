package com.expedia.cucumber;

import static org.testng.Assert.assertTrue;

import com.expedia.Config.DataConifg;
import com.expedia.base.TestBase;
import com.expedia.pages.ExpediaHomePage;
import com.expedia.pages.FlightResultPage;
import com.expedia.pages.FlightSearchPage;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightSearchDef extends TestBase {
	String resultText = "";

	@Before
	public void init() {
		initialization();
	}

	@After
	public void close() {
		driver.quit();
	}

	@BeforeStep
	public void beforeeachstep() {
		System.out.println("Test started");
	}

	@AfterStep
	public void aftereachstep() {
		System.out.println("Test ended");
	}

	@Given("the user is in Expedia search page")
	public void the_user_is_in_gExpedia_search_page() throws InterruptedException {
		ExpediaHomePage home = new ExpediaHomePage();
		home.preRequisite();

	}

	@When("the user enters trip details")
	public void the_user_enters_trip_details() throws InterruptedException {
		FlightSearchPage oneWaysearchPage = new FlightSearchPage();
		FlightResultPage resultPage = oneWaysearchPage.roundTripFlight(DataConifg.ORIGIN, DataConifg.DESTINATION,
				DataConifg.DEPAETURE_DATE, DataConifg.ARRIVAL_DATE);
		// System.out.println("searched");
		resultText = resultPage.resultOfOneWayFlight();
	}

	@Then("the result page should be displayed")
	public void the_result_page_should_be_displayed() throws InterruptedException {
		assertTrue(resultText.contains("from " + DataConifg.ORIGIN));
		assertTrue(resultText.contains("in " + DataConifg.DESTINATION));
	}
}