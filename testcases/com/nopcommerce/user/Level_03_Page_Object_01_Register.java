package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_03_Page_Object_01_Register {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String firstName, lastName, emailAddress;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		homePage = new UserHomePageObject(driver);
		registerPage = new UserRegisterPageObject(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

		firstName = "Automation";
		lastName = "HQ";
		emailAddress = "automation" + generateFakeNumber() + "@mail.com";
	}

	@Test
	public void Register_01_Register_Empty_Data() {
		System.out.println("Register_01 Step 1 : Click to Register link");
		homePage.openRegisterPage();
		System.out.println("Register_01 Step 2 : Click to Register button");
		registerPage.clickToRegisterButton();
		System.out.println("Register_01 Step 3 : Verify Error message");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		System.out.println("Register_02 Step 1 : Click to Register link");
		homePage.openRegisterPage();

		System.out.println("Register_02 Step 2 : Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("dsjf$djsfhjkd@&^");
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");

		System.out.println("Register_02 Step 3 : Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_02 Step 4 : Verify Error message");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Register_03_Register_Success() {
		System.out.println("Register_03 Step 1 : Click to Register link");
		homePage.openRegisterPage();

		System.out.println("Register_03 Step 2 : Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");

		System.out.println("Register_03 Step 3 : Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_03 Step 4 : Verify Register success message");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void Register_04_Existing_Email() {
		System.out.println("Register_04 Step 1 : Click to Register link");
		homePage.openRegisterPage();

		System.out.println("Register_04 Step 2 : Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");

		System.out.println("Register_04 Step 3 : Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_04 Step 4 : Verify Existing Email Error message");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");

	}

	@Test
	public void Register_05_Register_Password_Less_Than_6_Chars() {
		System.out.println("Register_05 Step 1 : Click to Register link");
		homePage.openRegisterPage();

		System.out.println("Register_05 Step 2 : Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123456");

		System.out.println("Register_05 Step 3 : Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_05 Step 4 : Verify Error message");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {
		System.out.println("Register_06 Step 1 : Click to Register link");
		homePage.openRegisterPage();

		System.out.println("Register_06 Step 2 : Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123654");

		System.out.println("Register_06 Step 3 : Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_06 Step 4 : Verify Error message");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
