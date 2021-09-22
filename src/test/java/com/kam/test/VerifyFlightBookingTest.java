package com.kam.test;

import org.testng.annotations.Test;

import com.kam.pages.FlightListPage;
import com.kam.pages.HomePage;

/**
 * 
 * @author kamlesh
 *
 */
public class VerifyFlightBookingTest extends TestBase {

	@Test
	private void verifyFlightBookingWithValidDetails() {
		HomePage homePage = navigateToBlazeDeomHomePage();
		FlightListPage flightListPage = homePage.findFlights("Paris", "Rome");
		flightListPage.bookFlight("9696");
	}
}
