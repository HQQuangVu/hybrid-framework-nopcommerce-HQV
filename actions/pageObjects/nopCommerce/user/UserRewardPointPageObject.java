package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageUI;

public class UserRewardPointPageObject extends BasePage {
	private WebDriver driver;

	public UserRewardPointPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isRewardPointPageDisplayed() {
		waitForElementVisible(driver, BasePageUI.REWARD_POINT_LINK);
		return isElementDisplayed(driver, BasePageUI.REWARD_POINT_LINK);
	}

}
