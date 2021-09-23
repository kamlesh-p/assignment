package com.kam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.kam.base.BasePage;
import com.kam.common.CardType;

/**
 * 
 * @author kamlesh
 *
 */
public class PurchaseDetailsPage extends BasePage {

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

	/**
	 * Fill Passenger Details.
	 * 
	 * @param name
	 * @param address
	 * @param city
	 * @param state
	 * @param zipCode
	 */
	public void fillPassengerDetails(String name, String address, String city, String state, String zipCode) {
		Reporter.log("Fill Passenger Details.");
		setText(txtName, name);
		setText(txtAddress, address);
		setText(txtCity, city);
		setText(txtState, state);
		setText(txtZipCode, zipCode);
	}

	/**
	 * Fill Card Details.
	 * 
	 * @param cardType
	 * @param cardNumber
	 * @param cardMonth
	 * @param cardYear
	 */
	public void fillCardDetails(CardType cardType, String cardNumber, String cardMonth, String cardYear,
			String nameOnCard) {
		Reporter.log("Fill Card Details.");
		selectFromDropdownByVisibleText(ddlCardType, cardType.getValue());
		setText(txtCardNumber, cardNumber);
		setText(txtCardMonth, cardMonth);
		setText(txtCardYear, cardYear);
		setText(txtNameOnCard, nameOnCard);
	}

	/**
	 * 
	 * @return ConfirmationPage
	 */
	public ConfirmationPage clickPurchaseFlight() {
		clickElement(btnPurchaseFlight);
		return PageFactory.initElements(driver, ConfirmationPage.class);
	}

}
