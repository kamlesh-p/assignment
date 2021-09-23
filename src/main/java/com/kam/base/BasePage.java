package com.kam.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	protected void clickElement(WebElement element) {
		element.click();
	}

	protected void setText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	protected void selectFromDropdownByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
}
