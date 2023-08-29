package pageUIs.wordpress;

public class UserPostDetailPageUI {
	public static final String POST_TITLE_TEXT = "xpath=//article//h1[text()='%s']";
	public static final String POST_BODY_TEXT = "xpath=//article//h1[text()='%s']/parent::header/following-sibling::div/p[text()='%s']";
	public static final String POST_AUTHOR_TEXT = "xpath=//article//h1[text()='%s']/parent::header//span[@class='author vcard']/a[text()='%s']";

}
