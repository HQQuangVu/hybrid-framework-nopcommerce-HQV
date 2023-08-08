package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageNopCommerceUI;

public class UserAddressPageObject extends BasePage {
	private WebDriver driver;

	public UserAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isAddressPageDisplayed() {
		waitForElementVisible(driver, BasePageNopCommerceUI.ADDRESS_LINK);
		return isElementDisplayed(driver, BasePageNopCommerceUI.ADDRESS_LINK);
	}

}
