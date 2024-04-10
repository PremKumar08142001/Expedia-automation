package com.expedia.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.expedia.base.TestBase;

public class ExpediaHomePage extends TestBase {
	@FindBy(linkText = "Flights")
	private WebElement fightTab;

	public ExpediaHomePage() {
		PageFactory.initElements(driver, this);
	}

	public void clickFlightTab() {
		fightTab.click();
	}

	public void preRequisite() {
		clickFlightTab();
	}
//	Expedia Home page for Packages

	@FindBy(linkText = "Packages")
	private WebElement packagetab;

	public void clickPackageTab() {
		packagetab.click();
	}

	public void flightPreRequisite() {
		clickPackageTab();
	}

}