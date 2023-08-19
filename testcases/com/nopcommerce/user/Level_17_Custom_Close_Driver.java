package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_17_Custom_Close_Driver extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "HQ";
		emailAddress = "automation" + generateFakeNumber() + "@mail.com";
		password = "123456";

	}

	@Test
	public void User_01_Register_Login() {
		log.info("Register 01 : Navigate to Register page");
		registerPage = homePage.openRegisterPage();

		log.info("Register 02 : Enter to Firstname textbox with value '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);

		log.info("Register 03 : Enter to LastName textbox with value '" + lastName + "'");
		registerPage.inputToLastNameTextbox(lastName);

		log.info("Register 04 : Enter to Email textbox with value '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);

		log.info("Register 05 : Enter to Password textbox with value '" + password + "'");
		registerPage.inputToPasswordTextbox(password);

		log.info("Register 06 : Enter to ConfirmPassword textbox with value '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Register 07 : Click to 'Register' button");
		registerPage.clickToRegisterButton();

		log.info("Register 08 : Verify Register success message and navigate to HomePage");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Register 09 : Click to 'Log out' link");
		registerPage.clickToLogOutLink();

		homePage = PageGeneratorManager.getUserHomePage(driver);

	}

	@Test
	public void User_02_Login() {

		log.info("Login 01 : Navigate to Login page");
		loginPage = homePage.openLoginPage();

		log.info("Login 02 : Enter to Email textbox with value '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);
		log.info("Login 03 : Enter to Password textbox with value '" + password + "'");
		loginPage.inputToPasswordTextbox(password);

		log.info("Login 04 : Click to Login button");
		homePage = loginPage.clickToLoginButton();

		log.info("Login 05 : Verify 'My account link' displayed");
		verifyFalse(homePage.isMyAccountLinkDisplayed());

		log.info("Login 06 : Navigate to Customer info Page");
		customerInfoPage = homePage.openMyAccountPage();

		log.info("Login 07 : Verify 'Customer info Page' displayed");
		verifyFalse(customerInfoPage.isCustomerInfoPageDisplayed());

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
