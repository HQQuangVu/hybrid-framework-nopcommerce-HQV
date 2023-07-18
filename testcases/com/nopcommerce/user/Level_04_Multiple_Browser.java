package com.nopcommerce.user;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_04_Multiple_Browser extends BaseTest {
	private WebDriver driverTC;

	private String firstName, lastName, validEmail, invalidEmail, password;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverTC = getBrowserDriver(browserName);

		homePage = new HomePageObject(driverTC);

		firstName = "Automation";
		lastName = "HQ";
		invalidEmail = "automation@com@vn";
		validEmail = "automation" + generateFakeNumber() + "@mail.com";
		password = "123456";

		System.out.println("Precondition Step 1 : Click to Register link");
		homePage.openRegisterLink();

		registerPage = new RegisterPageObject(driverTC);

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
		homePage = new HomePageObject(driverTC);

	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.openLoginLink();

		loginPage = new LoginPageObject(driverTC);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.openLoginLink();

		loginPage = new LoginPageObject(driverTC);

		loginPage.inputToEmailTextbox(invalidEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@AfterClass
	public void afterClass() {
		driverTC.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
