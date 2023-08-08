package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageNopCommerceUI;

public class UserOrderPageObject extends BasePage {
	private WebDriver driver;

	public UserOrderPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isOrderPageDisplayed() {
		waitForElementVisible(driver, BasePageNopCommerceUI.ORDERS_LINK);
		return isElementDisplayed(driver, BasePageNopCommerceUI.ORDERS_LINK);
	}

}
