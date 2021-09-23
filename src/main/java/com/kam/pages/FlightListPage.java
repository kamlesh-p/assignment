package com.kam.pages;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.kam.base.BasePage;

/**
 * 
 * @author kamlesh
 *
 */
public class FlightListPage extends BasePage {

	private final Logger log = Logger.getLogger(this.getClass().getName());

	@FindBy(xpath = "//*[contains(text(), 'Flights from')]")
	WebElement lblHeaderMessage;

	@FindBy(xpath = "//table/tbody")
	WebElement tblFlights;

	public FlightListPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * bookFlight - select flight from list with given flightNumber.
	 * 
	 * @param flightNumber
	 */
	public PurchaseDetailsPage bookFlight(String flightNumber) {
		Reporter.log("Book flight: " + flightNumber);
		List<WebElement> rows = tblFlights.findElements(By.tagName("tr"));
		if (rows.isEmpty()) {
			Reporter.log("No flight found");
			log.info("No flight found");
			return null;
		}

		boolean flightFound = false;
		for (WebElement row : rows) {
			List<WebElement> columns = row.findElements(By.tagName("td"));
			if (flightNumber.equals(columns.get(1).getText())) {
				flightFound = true;
				clickElement(columns.get(0).findElement(By.tagName("input")));
				break;
			}
		}

		if (!flightFound) {
			Reporter.log("Flight not found");
			log.info("Flight not found");
			return null;
		}
		return PageFactory.initElements(driver, PurchaseDetailsPage.class);
	}
}
