package pageUIs.jQuery.dataTable;

public class HomePageUI {
	public static final String PAGINATION_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String PAGINATION_PAGE_ACTIVATED_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String TOTAL_PAGE_NUMBER = "css=ul.qgrd-pagination-ul>li.qgrd-pagination-page";
	public static final String PAGINATION_PAGE_INDEX = "xpath=ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tr/td";

	public static final String COLUMN_INDEX_BY_NAME = "xpath=//thead//tr/th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_BY_COLUMN_AND_ROW_INDEX = "xpath=//tbody//tr[%s]//td[%s]/input";
	public static final String DROPDOWN_BY_COLUMN_AND_ROW_INDEX = "xpath=//tbody//tr[%s]//td[%s]//select";
	public static final String CHECKBOX_BY_COLUMN_AND_ROW_INDEX = "xpath=//tbody//tr[%s]//td[%s]//input[@type='checkbox']";
	public static final String ICON_BY_ROW_NUMBER = "xpath=//tbody//tr[%s]//button[@title='%s']";

	public static final String LOAD_BUTTON = "xpath=//button[@id='load']";
}
