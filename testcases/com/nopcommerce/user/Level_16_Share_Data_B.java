package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Level_16_Share_Data_B extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Login 01 : Navigate to Login page");
		loginPage = homePage.openLoginPage();

		log.info("Login 02 : Set cookie and Reload page");
		loginPage.setCookies(driver, Common_01_Register.LoggedCookies);
		loginPage.refreshCurrentPage(driver);

		log.info("Login 03 : Verify 'My account link' displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void User_01() {

	}

	@Test
	public void User_02() {

	}

	@Test
	public void User_03() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
