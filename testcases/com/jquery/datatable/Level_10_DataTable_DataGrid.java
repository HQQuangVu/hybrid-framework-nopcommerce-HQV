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

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	public void Table_01_Paging() {
		// https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/
		homePage.openPagingByPageNumber("6");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageNumberActivated("6"));

		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageNumberActivated("10"));
	}

	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);

		homePage.enterToHeaderTextboxByLabel("Country", "Argentina");
		homePage.enterToHeaderTextboxByLabel("Females", "283821");
		homePage.enterToHeaderTextboxByLabel("Males", "283856");
		homePage.enterToHeaderTextboxByLabel("Total", "560503");
		homePage.sleepInSecond(3);
	}

	public void Table_03_Get_All_Page_Value() {
		actualAllCountryValues = homePage.getAllPageValue();

	}

	@Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {
		// https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/
		homePage.clickToLoadButton();
		homePage.sleepInSecond(3);

		homePage.enterToTextboxAtRowNumberByColumnName("Company", "1", "MichaelJ");
		homePage.enterToTextboxAtRowNumberByColumnName("Contact Person", "2", "Jason Steward");

		homePage.selectDropdownByColumnNameAndRowNumber("Country", "1", "Germany");
		homePage.selectDropdownByColumnNameAndRowNumber("Country", "3", "Malaysia");
		homePage.selectDropdownByColumnNameAndRowNumber("Country", "5", "United Kingdom");

		homePage.checkToCheckboxByColumnAtRowNumber("NPO?", "2");
		homePage.checkToCheckboxByColumnAtRowNumber("NPO?", "3");

		homePage.uncheckToCheckboxByColumnAtRowNumber("NPO?", "1");
		homePage.uncheckToCheckboxByColumnAtRowNumber("NPO?", "4");

		homePage.clickToIconByRowNumber("1", "Remove Current Row");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
