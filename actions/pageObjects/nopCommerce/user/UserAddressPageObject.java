package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageUI;

public class UserAddressPageObject extends BasePage {
	private WebDriver driver;

	public UserAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isAddressPageDisplayed() {
		waitForElementVisible(driver, BasePageUI.ADDRESS_LINK);
		return isElementDisplayed(driver, BasePageUI.ADDRESS_LINK);
	}

}
