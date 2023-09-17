package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommer.data.UserData;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_20_Manage_Date_Part_II extends BaseTest {
	private WebDriver driver;
	private String emailAddress;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		emailAddress = UserData.Register.EMAIL + generateFakeNumber() + "@fakemail.com";
	}

	@Test
	public void User_01_Register_Login() {
		log.info("Register 01 : Navigate to Register page");
		registerPage = homePage.openRegisterPage();

		registerPage.clickToRadioButtonByLabel(driver, "Female");

		log.info("Register 02 : Enter to Firstname textbox with value '" + UserData.Register.FIRST_NAME + "'");
		registerPage.inputToTextboxByID(driver, "FirstName", UserData.Register.FIRST_NAME);

		log.info("Register 03 : Enter to LastName textbox with value '" + UserData.Register.LAST_NAME + "'");
		registerPage.inputToTextboxByID(driver, "LastName", UserData.Register.LAST_NAME);

		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", UserData.Register.DATE);
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", UserData.Register.MONTH);
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", UserData.Register.YEAR);

		log.info("Register 04 : Enter to Email textbox with value '" + emailAddress + "'");
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);

		registerPage.clickToCheckboxByLabel(driver, "Newsletter");

		log.info("Register 05 : Enter to Password textbox with value '" + UserData.Register.PASSWORD + "'");
		registerPage.inputToTextboxByID(driver, "Password", UserData.Register.PASSWORD);

		log.info("Register 06 : Enter to ConfirmPassword textbox with value '" + UserData.Register.PASSWORD + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", UserData.Register.PASSWORD);

		log.info("Register 07 : Click to 'Register' button");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register 08 : Verify Register success message and navigate to HomePage");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Register 09 : Click to 'Log out' link");
		registerPage.clickToLogOutLink();
		homePage = PageGeneratorManager.getUserHomePage(driver);

	}

	@Test
	public void User_02_Login() {

		log.info("Login 01 : Navigate to Login page");
		loginPage = homePage.openLoginPage();

		log.info("Login 02 : Enter to Email textbox with value '" + emailAddress + "'");
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Login 03 : Enter to Password textbox with value '" + UserData.Register.PASSWORD + "'");
		loginPage.inputToTextboxByID(driver, "Password", UserData.Register.PASSWORD);

		log.info("Login 04 : Click to Login button");
		registerPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Login 05 : Verify 'My account link' displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void User_03_My_Account() {

		log.info("My Account 01 : Navigate to Customer info Page");
		customerInfoPage = homePage.openMyAccountPage();

		log.info("My Account 02 : Verify 'Customer info Page' displayed");
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());

		log.info("My Account 03 : Verify 'First Name' value is correct");

		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), UserData.Register.FIRST_NAME);

		log.info("My Account 04 : Verify 'Last Name' value is correct");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), UserData.Register.LAST_NAME);

		log.info("My Account 05 : Verify 'Email' value is correct");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), emailAddress);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
