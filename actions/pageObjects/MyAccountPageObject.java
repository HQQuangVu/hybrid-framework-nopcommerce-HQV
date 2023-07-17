package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class MyAccountPageObject extends BasePage {
	private WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddressesLink() {
		waitForElementClickable(driver, "//li[contains(@class,'customer-addresses')]");
		clickToElement(driver, "//li[contains(@class,'customer-addresses')]");
	}
}