package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.BasePageUI;

public class OrderPageObject extends BasePage {
	private WebDriver driver;

	public OrderPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isOrderPageDisplayed() {
		waitForElementVisible(driver, BasePageUI.ORDERS_LINK);
		return isElementDisplayed(driver, BasePageUI.ORDERS_LINK);
	}

}
