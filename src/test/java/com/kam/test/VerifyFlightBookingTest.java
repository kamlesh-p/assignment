package com.kam.test;

import org.testng.annotations.Test;

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
		homePage.findFlights("Paris", "Rome");
	}
}
