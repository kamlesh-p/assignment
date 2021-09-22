package com.kam.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.kam.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	private WebDriver driver;

	@BeforeTest
	public void before() {
		// default chrome driver initialization
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// TODO: update to support multiple browser initialization.
	}

	public WebDriver getDriver() {
		return driver;
	}

	protected HomePage navigateToBlazeDeomHomePage() {
		driver.get("https://blazedemo.com/index.php");
		return PageFactory.initElements(driver, HomePage.class);
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
