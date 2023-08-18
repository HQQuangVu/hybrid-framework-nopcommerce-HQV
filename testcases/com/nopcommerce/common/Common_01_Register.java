package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Register extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	public static String emailAddress, password;
	public static Set<Cookie> LoggedCookies;

	@Parameters("browser")
	@BeforeTest(description = "Create new common User for all Testclasses")
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "HQ";
		emailAddress = "automation" + generateFakeNumber() + "@mail.com";
		password = "123456";

		log.info("Pre-Condition 01 : Navigate to Register page");
		registerPage = homePage.openRegisterPage();

		log.info("Pre-Condition 02 : Enter to Firstname textbox with value '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);

		log.info("Pre-Condition 03 : Enter to LastName textbox with value '" + lastName + "'");
		registerPage.inputToLastNameTextbox(lastName);

		log.info("Pre-Condition 04 : Enter to Email textbox with value '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);

		log.info("Pre-Condition 05 : Enter to Password textbox with value '" + password + "'");
		registerPage.inputToPasswordTextbox(password);

		log.info("Pre-Condition 06 : Enter to ConfirmPassword textbox with value '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Pre-Condition 07 : Click to 'Register' button");
		registerPage.clickToRegisterButton();

		log.info("Pre-Condition 08 : Verify Register success message and navigate to HomePage");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Pre-Condition 09 : Click to Log out link");
		registerPage.clickToLogOutLink();
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-Condition 10 : Navigate to Login page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-Condition 11 : Enter to Email textbox with value '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);

		log.info("Pre-Condition 12 : Enter to Password textbox with value '" + password + "'");
		loginPage.inputToPasswordTextbox(password);

		log.info("Pre-Condition 13 : Click to Login button");
		homePage = loginPage.clickToLoginButton();

		LoggedCookies = homePage.getAllCookies(driver);

		driver.quit();
	}

	// @AfterTest
	// public void afterClass() {
	//
	// }
}
