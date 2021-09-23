package com.kam.test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.kam.api.GetLaunchesAPI;

import io.restassured.response.Response;

/**
 * 
 * @author kamlesh
 *
 */
public class VerifyLaunchAPITest {

	@Test
	private void verifyLaunchResponseCode() {
		Response response = GetLaunchesAPI.getResponseBody();
		assertNotNull(response, "No respose");
		assertTrue(GetLaunchesAPI.verifyStatusCode(response, 200));
	}

	@Test
	private void verifyLaunchResponseData() {
		Response response = GetLaunchesAPI.getResponseBody();
		assertNotNull(response, "No respose");
		//verify flight number
		int flightNumber = GetLaunchesAPI.getFlightNumebr(response);
		Reporter.log(String.valueOf(flightNumber));
		assertNotNull(flightNumber);
		//verify id
		String id = GetLaunchesAPI.getId(response);
		Reporter.log(id);
		assertNotNull(id);
	}
}
