package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Level_16_Share_Data_A extends BaseTest {
	private WebDriver driver;
	private String emailAddress, password;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		emailAddress = Common_01_Register.emailAddress;
		password = Common_01_Register.password;

		log.info("Login 01 : Navigate to Login page");
		loginPage = homePage.openLoginPage();

		log.info("Login 02 : Enter to Email textbox with value '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);

		log.info("Login 03 : Enter to Password textbox with value '" + password + "'");
		loginPage.inputToPasswordTextbox(password);

		log.info("Login 04 : Click to Login button");
		homePage = loginPage.clickToLoginButton();
	}

	@Test
	public void User_01_Verify_Login() {

		log.info("Login 05 : Verify 'My account link' displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		log.info("Login 06 : Navigate to Customer info Page");
		customerInfoPage = homePage.openMyAccountPage();

		log.info("Login 07 : Verify 'Customer info Page' displayed");
		verifyTrue(customerInfoPage.isCustomerInfoPageDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
