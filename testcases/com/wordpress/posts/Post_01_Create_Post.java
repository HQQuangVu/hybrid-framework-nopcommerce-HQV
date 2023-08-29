package com.wordpress.posts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.AdminDashboardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.AdminPostAddNewPO;
import pageObjects.wordpress.AdminPostSearchPO;
import pageObjects.wordpress.PageGeneratorManager;
import pageObjects.wordpress.UserHomePO;
import pageObjects.wordpress.UserPostDetailPO;

public class Post_01_Create_Post extends BaseTest {

	String adminUsername = "automationhq";
	String adminPassword = "automationhq";
	String searchPostUrl;
	int randomNumber = generateFakeNumber();
	String postTitle = "Live coding Title " + randomNumber;
	String postBody = "Live coding Body " + randomNumber;
	String authorName = "automationhq";
	String adminUrl, endUserUrl;

	@Parameters({ "browser", "urlAdmin", "urlUser" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		log.info("Pre-condition 01: Open browser and Admin site");
		this.adminUrl = adminUrl;
		this.endUserUrl = endUserUrl;
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
		adminPostAddNewPage.enterToAddNewPostTitle(postTitle);

		log.info("Create-Post 05: Enter to post Body");
		adminPostAddNewPage.enterToAddNewPostBody(postBody);

		log.info("Create-Post 06: Click to 'Publish' button");
		adminPostAddNewPage.clickToPublishButton();

		log.info("Create-Post 07: Click to 'Pre-Publish' button");
		adminPostAddNewPage.clickToPrePublishButton();

		log.info("Create-Post 08: Verify 'Post published.' message is Displayed");
		verifyTrue(adminPostAddNewPage.isPostPublisMessageDisplayed("Post published."));
	}

	@Test
	public void Post_02_Search_Post_And_View_Post() {

		log.info("Search-Post 01: Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

		log.info("Search-Post 02: Enter to search textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);

		log.info("Search-Post 03: Click to 'Search' button");
		adminPostSearchPage.clickToSearchButton();

		log.info("Search-Post 04: Verify Search table contains '" + postTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", postTitle));

		log.info("Search-Post 05: Verify Search table contains '" + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));

		log.info("Search-Post 06: Open End-User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("Search-Post 07: Verify Post information Displayed at Home page");
		verifyTrue(userHomePage.isPostTitleDisplayed(postTitle));
		verifyTrue(userHomePage.isPostBodyDisplayed(postTitle, postBody));
		verifyTrue(userHomePage.isPostAuthorDisplayed(postTitle, authorName));

		log.info("Search-Post 08: Click to 'Post' title");
		userPostDetailPage = userHomePage.clickToPostTitle(postTitle);

		log.info("Search-Post 09: Verify Post information Displayed at Post detail page");
		verifyTrue(userPostDetailPage.isPostTitleDisplayed(postTitle));
		verifyTrue(userPostDetailPage.isPostBodyDisplayed(postTitle, postBody));
		verifyTrue(userPostDetailPage.isPostAuthorDisplayed(postTitle, authorName));
	}

	@Test
	public void Post_03_Edit_Post() {

	}

	@Test
	public void Post_04_Delete_Post() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO adminDashboardPage;
	AdminPostSearchPO adminPostSearchPage;
	AdminPostAddNewPO adminPostAddNewPage;
	UserHomePO userHomePage;
	UserPostDetailPO userPostDetailPage;
}
