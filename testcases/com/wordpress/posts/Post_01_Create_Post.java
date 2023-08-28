package com.wordpress.posts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.admin.AdminDashboardPO;
import pageObjects.wordpress.admin.AdminLoginPO;
import pageObjects.wordpress.admin.AdminPostAddNewPO;
import pageObjects.wordpress.admin.AdminPostSearchPO;
import pageObjects.wordpress.admin.PageGeneratorManager;

public class Post_01_Create_Post extends BaseTest {
	private WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO adminDashboardPage;
	AdminPostSearchPO adminPostSearchPage;
	AdminPostAddNewPO adminPostAddNewPage;
	String adminUsername = "automationhq";
	String adminPassword = "automationhq";
	String searchPostUrl;
	int randomNumber = generateFakeNumber();
	String postTitleValue = "Live coding Title " + randomNumber;
	String postBodyValue = "Live coding Body " + randomNumber;

	@Parameters({ "browser", "urlAdmin" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl) {
		log.info("Pre-condition 01: Open browser and Admin url");
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
	public void Post_01_Create_New_Post() {

		log.info("Create-Post 01: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

		log.info("Create-Post 02: Click to 'Posts' menu link");
		searchPostUrl = adminPostSearchPage.getPageUrl(driver);

		log.info("Create-Post 03: Click to 'Add New' button");
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();

		log.info("Create-Post 04: Enter to post Title");
		adminPostAddNewPage.enterToAddNewPostTitle(postTitleValue);

		log.info("Create-Post 05: Enter to post Body");
		adminPostAddNewPage.enterToAddNewPostBody(postBodyValue);

		log.info("Create-Post 06: Click to 'Publish' button");
		adminPostAddNewPage.clickToPublishButton();

		log.info("Create-Post 07: Click to 'Pre-Publish' button");
		adminPostAddNewPage.clickToPrePublishButton();

		log.info("Create-Post 08: Verify 'Post published.' message is Displayed");
		verifyTrue(adminPostAddNewPage.isPostPublisMessageDisplayed("Post published."));
	}

	@Test
	public void Post_02_Search_Post() {

		log.info("Search-Post 01: Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

	}

	@Test
	public void Post_03_View_Post() {

	}

	@Test
	public void Post_04_Edit_Post() {

	}

	@Test
	public void Post_05_Delete_Post() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
