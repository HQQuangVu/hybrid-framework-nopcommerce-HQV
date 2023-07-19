package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageUI;

public class UserOrderPageObject extends BasePage {
	private WebDriver driver;

	public UserOrderPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isOrderPageDisplayed() {
		waitForElementVisible(driver, BasePageUI.ORDERS_LINK);
		return isElementDisplayed(driver, BasePageUI.ORDERS_LINK);
	}

}
