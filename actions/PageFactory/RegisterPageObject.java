package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// PageUIs
	@CacheLookup
	@FindBy(id = "FirstName")
	private WebElement firstName;

	@FindBy(id = "LastName")
	private WebElement lastName;

	@FindBy(id = "Email")
	private WebElement emailTextbox;

	@FindBy(id = "Password")
	private WebElement passwordTextbox;

	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPassword;

	@FindBy(id = "FirstName-error")
	private WebElement firstNameErrorMessage;

	@FindBy(id = "LastName-error")
	private WebElement lastNameErrorMessage;

	@FindBy(id = "Email-error")
	private WebElement emailErrorMessage;

	@FindBy(id = "Password-error")
	private WebElement passwordErrorMessage;

	@FindBy(id = "ConfirmPassword-error")
	private WebElement confirmPasswordErrorMessage;

	@FindBy(css = "div.result")
	private WebElement registerSuccessMessage;

	@FindBy(id = "register-button")
	private WebElement registerButton;

	@FindBy(xpath = "//div[contains(@class,'validation-summary-errors')]//li")
	private WebElement existingEmailError;

	// Action

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getElementText(driver, firstNameErrorMessage);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getElementText(driver, confirmPasswordErrorMessage);
	}

	public void inputToFirstnameTextbox(String firstname) {
		waitForElementVisible(driver, firstName);
		sendkeyToElement(driver, firstName, firstname);
	}

	public void inputToLastNameTextbox(String lastname) {
		waitForElementVisible(driver, lastName);
		sendkeyToElement(driver, lastName, lastname);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	public void inputToConfirmPasswordTextbox(String confirmPw) {
		waitForElementVisible(driver, confirmPassword);
		sendkeyToElement(driver, confirmPassword, confirmPw);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, existingEmailError);
		return getElementText(driver, existingEmailError);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}

}
