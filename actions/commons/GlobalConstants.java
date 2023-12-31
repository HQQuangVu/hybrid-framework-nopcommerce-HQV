package commons;

import java.io.File;

public class GlobalConstants {
	public static final String PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String JAVA_VERSION = System.getProperty("java.version");

	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles" + File.separator;
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs" + File.separator;
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "ReportNGScreenShots" + File.separator;

	public static final String DB_DEV_URL = "192.168.1.11:9860";
	public static final String DB_DEV_USER = "AutomationHQ";
	public static final String DB_DEV_PASSWORD = "TestP@ssword!";

	public static final String BROWSER_STACK_USERNAME = "";
	public static final String BROWSER_STACK_AUTOMATE_KEY = "";
	public static final String BROWSER_STACK_URL = "https://" + BROWSER_STACK_USERNAME + ":" + BROWSER_STACK_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public static final String SAUCELAB_USERNAME = "";
	public static final String SAUCELAB_AUTOMATE_KEY = "";
	public static final String SAUCELAB_URL = "https://";

	public static final String CROSSBROWSER_USERNAME = "";
	public static final String CROSSBROWSER_AUTOMATE_KEY = "";
	public static final String CROSSBROWSER_URL = "https://";

	public static final String LAMBDA_USERNAME = "";
	public static final String LAMBDA_AUTOMATE_KEY = "";
	public static final String LAMBDA_URL = "https://";

	public static final int SHORT_TIMEOUT = 5;
	public static final int LONG_TIMEOUT = 30;
	public static final long RETRY_TESTFAIL = 3;

}
