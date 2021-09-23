package com.kam.test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kam.base.TestBase;
import com.kam.common.CardType;
import com.kam.common.CommonUtils;
import com.kam.pages.ConfirmationPage;
import com.kam.pages.FlightListPage;
import com.kam.pages.HomePage;
import com.kam.pages.PurchaseDetailsPage;

/**
 * 
 * @author kamlesh
 *
 */
public class VerifyFlightBookingTest extends TestBase {

	@Test(dataProvider ="data")
	private void verifyFlightBookingWithValidDetails(String from, String to, String flightNo) {
		HomePage homePage = navigateToBlazeDeomHomePage();
		FlightListPage flightListPage = homePage.findFlights(from, to);
		PurchaseDetailsPage purchaseDetailsPage = flightListPage.bookFlight(flightNo);
		assertNotNull(purchaseDetailsPage, "Flight not found");
		purchaseDetailsPage.fillPassengerDetails("Kamlesh Prakash", "#12, New Stret", "Bangalore", "Karnataka",
				"560085");
		purchaseDetailsPage.fillCardDetails(CardType.VISA, CommonUtils.getCardNumber(), "2022", "12", "Kamlesh");
		ConfirmationPage confirmationPage = purchaseDetailsPage.clickPurchaseFlight();
		assertNotNull(confirmationPage.getConfirmationId(), "Confirmation id not found.");
	}

	@Test
	private void verifyBookFlightWithoutCardDetails() {
		HomePage homePage = navigateToBlazeDeomHomePage();
		FlightListPage flightListPage = homePage.findFlights("Paris", "Rome");
		PurchaseDetailsPage purchaseDetailsPage = flightListPage.bookFlight("9696");
		assertNotNull(purchaseDetailsPage, "Flight not found");
		purchaseDetailsPage.fillPassengerDetails("TestUser", "12, Test street 1234", "Bangalore", "Karnataka",
				"345345");
		ConfirmationPage confirmationPage = purchaseDetailsPage.clickPurchaseFlight();
		assertNull(confirmationPage.getConfirmationId(), "Confirmation id found.");
	}

	@DataProvider
	private String[][] data() {
		return new String[][] { { "Paris", "Rome", "9696" }, { "São Paolo", "Buenos Aires", "234" } };
	}
}
