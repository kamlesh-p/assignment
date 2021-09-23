package com.kam.api;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Reporter;

import io.restassured.response.Response;

/**
 * 
 * @author kamlesh
 *
 */
public class GetLaunchesAPI {

	private static final String URL = "https://api.spacexdata.com/v4/launches/latest";

	/**
	 * Get call to launch API.
	 * 
	 * @return
	 */
	public static Response getResponseBody() {
		Response response = given().when().get(URL).then().extract().response();
		Reporter.log(response.getBody().prettyPrint());
		return response;
	}

	/**
	 * Verify status code.
	 * 
	 * @param response
	 * @param code
	 * @return
	 */
	public static boolean verifyStatusCode(Response response, int code) {
		int statusCode = response.getStatusCode();
		Reporter.log("Verify status code: " + statusCode);
		return statusCode == code;
	}

	public static int getFlightNumebr(Response response) {
		JSONObject jsonObject = new JSONObject(response.getBody().asString());
		return jsonObject.getInt("flight_number");
	}
	
	public static String getId(Response response) {
		JSONObject jsonObject = new JSONObject(response.getBody().asString());
		return jsonObject.getString("id");
	}
}
