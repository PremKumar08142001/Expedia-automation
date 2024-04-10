package com.expedia.cucumber;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src\\test\\java\\com\\expedia\\cucumber\\FlightSearch.feature", "src\\test\\java\\com\\expedia\\cucumber\\expediafeedback.feature","src\\test\\java\\com\\expedia\\cucumber\\expediasupport.feature"}, glue = {
		"com.expedia.cucumber" }, plugin = { "me.jvt.cucumber.report.PrettyReports:target/cucumber" })
public class TestRunner extends AbstractTestNGCucumberTests {
}
