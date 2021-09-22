package com.kam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kam.base.BasePage;

public class HomePage extends BasePage {

	@FindBy(name = "fromPort")
	WebElement ddlDepartureCity;

	@FindBy(name = "toPort")
	WebElement ddlDestinationCity;

	@FindBy(tagName = "input")
	WebElement btnFindFlights;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public FlightListPage findFlights(String fromCity, String toCity) {
		selectFromDropdownByVisibleText(ddlDepartureCity, fromCity);
		selectFromDropdownByVisibleText(ddlDestinationCity, toCity);
		clickElement(btnFindFlights);
		return PageFactory.initElements(driver, FlightListPage.class);
	}
}
