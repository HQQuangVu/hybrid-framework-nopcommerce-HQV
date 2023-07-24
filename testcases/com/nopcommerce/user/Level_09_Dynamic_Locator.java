package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserOrderPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_09_Dynamic_Locator extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserAddressPageObject addressPage;
	private UserOrderPageObject orderPage;
	private UserRewardPointPageObject rewardPointPage;

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
		registerPage = homePage.openRegisterPage();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		customerInfoPage = homePage.openMyAccountPage();
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());

	}

	@Test
	public void User_02_Switch_Page() {
		addressPage = customerInfoPage.openAddressPage(driver);

		orderPage = addressPage.openOrderPage(driver);

		rewardPointPage = orderPage.openRewardPointPage(driver);

		customerInfoPage = rewardPointPage.openCustomerInfoPage(driver);
	}

	@Test
	public void User_03_Dynamic_Page_I() {
		addressPage = (UserAddressPageObject) customerInfoPage.openMyAccountPageByName(driver, "Addresses");

		orderPage = (UserOrderPageObject) addressPage.openMyAccountPageByName(driver, "Orders");

		rewardPointPage = (UserRewardPointPageObject) orderPage.openMyAccountPageByName(driver, "Reward points");

		customerInfoPage = (UserCustomerInfoPageObject) rewardPointPage.openMyAccountPageByName(driver, "Customer info");
	}

	@Test
	public void User_04_Dynamic_Page_II() {
		customerInfoPage.openMyAccountPagesWithoutReturn(driver, "Orders");
		orderPage = PageGeneratorManager.getUserOrderPage(driver);

		orderPage.openMyAccountPagesWithoutReturn(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);

		rewardPointPage.openMyAccountPagesWithoutReturn(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
