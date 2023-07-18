package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.BasePageUI;

public class AddressPageObject extends BasePage {
	private WebDriver driver;

	public AddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isAddressPageDisplayed() {
		waitForElementVisible(driver, BasePageUI.ADDRESS_LINK);
		return isElementDisplayed(driver, BasePageUI.ADDRESS_LINK);
	}

}
