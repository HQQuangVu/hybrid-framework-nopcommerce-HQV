package pageUIs.nopCommerce.user;

public class BasePageNopCommerceUI {
	public static final String CUSTOMER_INFO_LINK = "xpath=//li[contains(@class,'customer-info')]";
	public static final String ADDRESS_LINK = "xpath=//li[contains(@class,'customer-addresses')]";
	public static final String ORDERS_LINK = "xpath=//li[contains(@class,'customer-orders')]";
	public static final String DOWNLOADABLE_PRODUCT_LINK = "xpath=//li[contains(@class,'downloadable-products')]";
	public static final String BACK_IN_STOCK_SUBCRIPTION_LINK = "xpath=//li[contains(@class,'back-in-stock-subscriptions')]";
	public static final String REWARD_POINT_LINK = "xpath=//li[contains(@class,'reward-points')]";
	public static final String CHANGE_PASSWORD_LINK = "xpath=//li[contains(@class,'change-password')]";
	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//li[contains(@class,'customer-reviews')]";
	public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='%s']";

	public static final String USER_LOGOUT_LINK = "xpath=//a[@class='ico-logout']";
	public static final String ADMIN_LOGOUT_LINK = "xpath=//a[text()='Logout']";
}
