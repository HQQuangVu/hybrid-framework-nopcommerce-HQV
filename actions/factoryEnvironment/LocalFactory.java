package factoryEnvironment;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalFactory {
	private String browserName;
	private WebDriver driver;

	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}

	public WebDriver createDriver() {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		if (browser == BROWSER.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.PROJECT_PATH + "\\browserLogs\\FirefoxLog.log");

			FirefoxOptions options = new FirefoxOptions();

			options.setAcceptInsecureCerts(true);

			options.addArguments("--disable-notifications");
			options.addArguments("--disable-geolocation");

			driver = new FirefoxDriver(options);
		} else if (browser == BROWSER.CHROME) {
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.args", "--disable-logging");
			System.setProperty("webdriver.chrome.silentOutput", "true");

			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);

			options.setAcceptInsecureCerts(true);

			options.addArguments("--disable-notifications");
			options.addArguments("--disable-geolocation");

			options.setExperimentalOption("prefs", prefs);
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

			driver = new ChromeDriver(options);
		} else if (browser == BROWSER.EDGE) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser == BROWSER.H_CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		} else if (browser == BROWSER.H_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		} else {
			throw new RuntimeException("Invalid browser name");
		}
		return driver;
	}
}
