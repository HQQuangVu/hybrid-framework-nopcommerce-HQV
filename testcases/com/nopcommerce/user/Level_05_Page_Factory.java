package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageFactory.HomePageObject;
import PageFactory.LoginPageObject;
import PageFactory.RegisterPageObject;
import commons.BaseTest;

public class Level_05_Page_Factory extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, validEmail, invalidEmail, notFoundEmail, password;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = new HomePageObject(driver);

		firstName = "Automation";
		lastName = "HQ";
		invalidEmail = "automation@com@vn";
		validEmail = "automation" + generateFakeNumber() + "@mail.com";
		notFoundEmail = "automation" + generateFakeNumber() + "@mail.vn";
		password = "123456";

		System.out.println("Precondition Step 1 : Click to Register link");
		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		System.out.println("Precondition Step 2 : Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(validEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Precondition Step 3 : Click to Register link");
		registerPage.clickToRegisterButton();

		System.out.println("Precondition Step 4 : Verify Register success message");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = new HomePageObject(driver);

	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(invalidEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Login_03_Email_Not_Found() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(notFoundEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(validEmail);
		loginPage.inputToPasswordTextbox("");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(validEmail);
		loginPage.inputToPasswordTextbox("654321");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_06_Valid_Email_Password() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(validEmail);
		loginPage.inputToPasswordTextbox(password);

		loginPage.clickToLoginButton();

		homePage = new HomePageObject(driver);

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Override
	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
