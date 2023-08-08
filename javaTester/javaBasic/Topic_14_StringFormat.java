package javaBasic;

public class Topic_14_StringFormat {
	public static String REGISTER_LINK = "xpath=//a[@class='ico-register']";
	public static String LOGIN_LINK = "xpath=//a[@class='ico-login']";
	public static String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	public static String LOG_OUT_LINK = "xpath=//a[@class='ico-logout']";

	public static String DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME = "//a[@class='%s']";
	public static String DYNAMIC_LINK_BY_PAGE_NAME = "//div[contains(@class,'%s')]//a[text()='%s']";

	public static void main(String[] args) {
		clickToLink(REGISTER_LINK);
		clickToLink(LOGIN_LINK);
		clickToLink(MY_ACCOUNT_LINK);
		clickToLink(LOG_OUT_LINK);

		clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "ico-register");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "header", "ico-account");

	}

	public static void clickToLink(String locator) {
		System.out.println("Click to" + locator);
	}

	public static void clickToLink(String dynamicLocator, String pageName) {
		String locator = String.format(dynamicLocator, pageName);
		System.out.println("Click to: " + locator);
	}

	public static void clickToLink(String dynamicLocator, String... params) {
		String locator = String.format(dynamicLocator, (Object[]) params);
		System.out.println("Click to: " + locator);
	}
}
