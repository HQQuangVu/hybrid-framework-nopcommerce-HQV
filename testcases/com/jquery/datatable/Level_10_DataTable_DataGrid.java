package com.jquery.datatable;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("6");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageNumberActivated("6"));

		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageNumberActivated("10"));
	}

	@Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);

		homePage.enterToHeaderTextboxByLabel("Country", "Argentina");
		homePage.enterToHeaderTextboxByLabel("Females", "283821");
		homePage.enterToHeaderTextboxByLabel("Males", "283856");
		homePage.enterToHeaderTextboxByLabel("Total", "560503");
		homePage.sleepInSecond(3);
	}

	@Test
	public void Table_03() {
		actualAllCountryValues = homePage.getAllPageValue();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
