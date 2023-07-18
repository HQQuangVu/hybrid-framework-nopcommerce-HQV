package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.BasePageUI;

public class RewardPointPageObject extends BasePage {
	private WebDriver driver;

	public RewardPointPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isRewardPointPageDisplayed() {
		waitForElementVisible(driver, BasePageUI.REWARD_POINT_LINK);
		return isElementDisplayed(driver, BasePageUI.REWARD_POINT_LINK);
	}

}
