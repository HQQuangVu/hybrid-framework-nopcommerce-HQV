package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.uploadFiles.HomePageObject;
import pageObjects.jQuery.uploadFiles.PageGeneratorManager;

public class Level_11_Upload_Files extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	String forestFileName = "Forest.jpg";
	String lakeFileName = "Lake.jpg";
	String oceanFileName = "Ocean.jpg";
	String[] multipleFileNames = { forestFileName, lakeFileName, oceanFileName };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Upload_01_Upload_One_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, lakeFileName);
		Assert.assertTrue(homePage.isFileLoadedByName(lakeFileName));
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileLinkUploadedByname(lakeFileName));
	}

	@Test
	public void Upload_02_Upload_Multiple_File_Per_Time() {
		homePage.refreshCurrentPage(driver);
		homePage.uploadMultipleFiles(driver, multipleFileNames);

		Assert.assertTrue(homePage.isFileLoadedByName(lakeFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(oceanFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(forestFileName));

		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isFileLinkUploadedByname(lakeFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByname(oceanFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByname(forestFileName));

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
