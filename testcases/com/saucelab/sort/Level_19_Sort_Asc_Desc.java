package com.saucelab.sort;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.sauceLab.LoginPageObject;
import pageObjects.sauceLab.PageGeneratorManager;
import pageObjects.sauceLab.ProductPageObject;

public class Level_19_Sort_Asc_Desc extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	ProductPageObject productPage;

	@Parameters({ "browser", "appUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String sauceLabUrl) {
		driver = getBrowserDriver(browserName, sauceLabUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.enterToUsernameTextbox("standard_user");
		loginPage.enterToPasswordTextbox("secret_sauce");
		productPage = loginPage.clickToLoginButton();
	}

	@Test
	public void Sort_01_Name() {

		productPage.selectItemInSortDropdown("Name (Z to A)");
		productPage.sleepInSecond(3);

		Assert.assertTrue(productPage.isProductNameSortByDescending());

		productPage.selectItemInSortDropdown("Name (A to Z)");
		productPage.sleepInSecond(3);

		Assert.assertTrue(productPage.isProductNameSortByAscending());
	}

	@Test
	public void Sort_02_Price() {

		productPage.selectItemInSortDropdown("Price (low to high)");
		productPage.sleepInSecond(3);

		Assert.assertTrue(productPage.isProductPriceSortByAscending());

		productPage.selectItemInSortDropdown("Price (high to low)");
		productPage.sleepInSecond(3);

		Assert.assertTrue(productPage.isProductPriceSortByDescending());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
