package com.wordpress.posts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.AdminDashboardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.AdminUserPO;
import pageObjects.wordpress.PageGeneratorManager;

public class User_01_View_User extends BaseTest {

	String adminUsername = "automationhq";
	String adminPassword = "automationhq";
	String adminUrl, endUserUrl;

	@Parameters({ "browser", "urlAdmin", "urlUser" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		log.info("Pre-condition 01: Open browser and Admin site");
		driver = getBrowserDriver(browserName, adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Pre-condition 02: Enter to Username textbox with value " + adminUsername);
		adminLoginPage.enterToUsernameTextbox(adminUsername);
		log.info("Pre-condition 03: Enter to Password textbox with value " + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);
		log.info("Pre-condition 04: Click to 'Login' button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();

	}

	@Test
	public void TC_01_View_User() {

		log.info("View_User 01: Click to 'Users' menu link");
		adminUserPage = adminDashboardPage.clickToUserMenuLink();

		log.info("View_User 02: Get all 'Users' from UI");
		int totalUserNumberInUI = adminUserPage.getUserNumberFromUI();

		log.info("View_User 03: Get all 'Users' from DB");
		int totalUserNumberInDB = adminUserPage.getUserNumberFromDB();

		log.info("View_User 04: Verify 'Users' count in UI matching DB ");
		verifyEquals(totalUserNumberInUI, totalUserNumberInDB);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO adminDashboardPage;
	AdminUserPO adminUserPage;
}
