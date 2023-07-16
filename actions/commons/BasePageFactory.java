package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	public static BasePageFactory getBasePageObject() {
		return new BasePageFactory();
	}

	protected void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	protected String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	protected String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	protected String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	protected void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	protected Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	protected void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	protected void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	protected String getTextAlert(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	protected void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	protected void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindowIDS = driver.getWindowHandles();
		for (String id : allWindowIDS) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
			}
		}
	}

	protected void switchToWindowByTitle(WebDriver driver, String expectedPageTitle) {
		Set<String> allWindowIDS = driver.getWindowHandles();
		for (String id : allWindowIDS) {
			driver.switchTo().window(id);
			String currentPageTitle = driver.getTitle();
			if (currentPageTitle.equals(expectedPageTitle)) {
				break;
			}

		}
	}

	protected void closeAllWindowExceptParent(WebDriver driver, String parentID) {
		Set<String> allWindowIDS = driver.getWindowHandles();
		for (String id : allWindowIDS) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	protected void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	protected String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}

	protected void sendkeyToElement(WebDriver driver, WebElement element, String textValue) {
		element.clear();
		element.sendKeys(textValue);
	}

	protected void selectItemInDefaultDropdown(WebDriver driver, WebElement element, String textItem) {
		Select select = new Select(element);
		select.selectByValue(textItem);
	}

	protected String getSelectedItemDefaultDropdown(WebDriver driver, WebElement element) {
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	protected boolean isDropdownMultiple(WebDriver driver, WebElement element) {
		Select select = new Select(element);
		return select.isMultiple();
	}

	protected void getElementAttribute(WebDriver driver, WebElement element, String attributeName) {
		element.getAttribute(attributeName);
	}

	protected String getElementCssValue(WebDriver driver, WebElement element, String propertyName) {
		return element.getCssValue(propertyName);
	}

	protected String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	protected int getElementSize(WebDriver driver, List<WebElement> elements) {
		return elements.size();
	}

	protected void checkToDefaultCheckboxRadio(WebDriver driver, WebElement element) {
		if (!element.isSelected()) {
			element.click();
		}
	}

	protected void uncheckToDefaultCheckboxRadio(WebDriver driver, WebElement element) {
		if (element.isSelected()) {
			element.click();
		}
	}

	protected boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}

	protected boolean isElementEnabled(WebDriver driver, WebElement element) {
		return element.isEnabled();
	}

	protected boolean isElementSelected(WebDriver driver, WebElement element) {
		return element.isSelected();
	}

	protected void switchToFrameIframe(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	protected void switchToDefaultContent(WebDriver driver, WebElement element) {
		driver.switchTo().defaultContent();
	}

	protected void hoverMouseToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	protected void waitForElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}

	protected void waitForAllElementVisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	protected void waitForElementInvisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}

	protected void waitForAllElementInvisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}

	protected void waitForElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	protected void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	// private long longTimeout = 30;

}
