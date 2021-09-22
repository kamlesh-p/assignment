package com.kam.pages;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kam.base.BasePage;

/**
 * 
 * @author kamlesh
 *
 */
public class ConfirmationPage extends BasePage {

	private final Logger log = Logger.getLogger(this.getClass().getName());

	@FindBy(xpath = "//table/tbody/tr[1]/td[2]")
	WebElement lblConfirmationId;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
	}

	public String getConfirmationId() {
		return lblConfirmationId.getText();
	}
}
