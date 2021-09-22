package com.kam.pages;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kam.base.BasePage;
import com.kam.common.CardType;

/**
 * 
 * @author kamlesh
 *
 */
public class PurchaseDetailsPage extends BasePage {

	private final Logger log = Logger.getLogger(this.getClass().getName());

	@FindBy(xpath = "//*[contains(text(), 'Your flight from')]")
	WebElement lblHeaderMessage;

	@FindBy(id = "inputName")
	WebElement txtName;

	@FindBy(id = "address")
	WebElement txtAddress;

	@FindBy(id = "city")
	WebElement txtCity;

	@FindBy(id = "state")
	WebElement txtState;

	@FindBy(id = "zipCode")
	WebElement txtZipCode;

	@FindBy(id = "cardType")
	WebElement ddlCardType;

	@FindBy(id = "creditCardNumber")
	WebElement txtCardNumber;

	@FindBy(id = "creditCardMonth")
	WebElement txtCardMonth;

	@FindBy(id = "creditCardYear")
	WebElement txtCardYear;

	@FindBy(id = "nameOnCard")
	WebElement txtNameOnCard;

	@FindBy(xpath = "//*[@value='Purchase Flight']")
	WebElement btnPurchaseFlight;

	public PurchaseDetailsPage(WebDriver driver) {
		super(driver);
	}

	public void fillPassengerDetails(String name, String address, String city, String state, String zipCode) {
		setText(txtName, name);
		setText(txtAddress, address);
		setText(txtCity, city);
		setText(txtState, state);
		setText(txtZipCode, zipCode);
	}

	public void fillCardDetails(CardType cardType, String cardNumber, String cardMonth, String cardYear) {
		selectFromDropdownByVisibleText(ddlCardType, cardType.getValue());
		setText(txtCardNumber, cardNumber);
		setText(txtCardMonth, cardMonth);
		setText(txtCardYear, cardYear);
	}

	public void clickPurchaseFlight() {
		clickElement(btnPurchaseFlight);
	}

}
