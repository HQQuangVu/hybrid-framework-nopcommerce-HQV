package pageObjects.sauceLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.sauceLab.ProductPageUI;

public class ProductPageObject extends BasePage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInSortDropdown(String textItem) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN);
		selectItemInDefaultDropdown(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN, textItem);
	}

	public boolean isProductNameSortByAscending() {
		ArrayList<String> productUIList = new ArrayList<>();

		List<WebElement> productNameText = getListElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
		}

		ArrayList<String> productSortList = new ArrayList<>();
		for (String product : productUIList) {
			productSortList.add(product);
		}

		Collections.sort(productSortList);
		return productSortList.equals(productUIList);
	}

	public boolean isProductNameSortByDescending() {
		ArrayList<String> productUIList = new ArrayList<String>();

		List<WebElement> productNameText = getListElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
		}

		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}

		Collections.sort(productSortList);
		Collections.reverse(productSortList);
		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByDescending() {
		ArrayList<Float> productUIList = new ArrayList<Float>();

		List<WebElement> productPriceText = getListElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);
		for (WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}

		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);
		}
		Collections.sort(productSortList);
		Collections.reverse(productSortList);
		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByAscending() {
		ArrayList<Float> productUIList = new ArrayList<Float>();

		List<WebElement> productPriceText = getListElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);
		for (WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}

		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);
		}
		Collections.sort(productSortList);
		return productSortList.equals(productUIList);
	}
}
