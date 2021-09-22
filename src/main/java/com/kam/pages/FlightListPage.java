package com.kam.pages;

import java.util.Collections;
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
	public void bookFlight(String flightNumber) {
		List<WebElement> rows = tblFlights.findElements(By.tagName("tr"));
		if (rows.isEmpty()) {
			log.info("No flight found");
			return;
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
			log.info("Flight not found");
		}
	}
}
