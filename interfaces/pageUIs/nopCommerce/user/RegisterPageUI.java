package pageUIs.nopCommerce.user;

public class RegisterPageUI {
	public static final String FIRSTNAME_TEXTBOX = "xpath=//input[@id='FirstName']";
	public static final String LASTNAME_TEXTBOX = "xpath=//input[@id='LastName']";
	public static final String EMAIL_TEXTBOX = "xpath=//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "xpath=//input[@id='Password']";
	public static final String CONFIRM_PASSWORD = "xpath=//input[@id='ConfirmPassword']";
	public static final String FIRSTNAME_ERROR_MESSAGE = "xpath=//span[@id='FirstName-error']";
	public static final String LASTNAME_ERROR_MESSAGE = "xpath=//span[@id='LastName-error']";
	public static final String EMAIL_ERROR_MESSAGE = "xpath=//span[@id='Email-error']";
	public static final String PASSWORD_ERROR_MESSAGE = "xpath=//span[@id='Password-error']";
	public static final String CONFIRM_PASSWORD_ERROR_MESSAGE = "xpath=//span[@id='ConfirmPassword-error']";
	public static final String REGISTER_SUCCESS_MESSAGE = "xpath=//div[@class='result']";
	public static final String REGISTER_BUTTON = "xpath=//button[@id='register-button']";
	public static final String EXISTING_EMAIL_ERROR = "xpath=//div[contains(@class,'validation-summary-errors')]//li";
	public static final String LOG_OUT_LINK = "xpath=//a[@class='ico-logout']";
}
