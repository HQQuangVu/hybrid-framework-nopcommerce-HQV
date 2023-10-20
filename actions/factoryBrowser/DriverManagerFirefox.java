package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManagerFirefox implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {

		WebDriverManager.firefoxdriver().setup();
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.PROJECT_PATH + "\\browserLogs\\FirefoxLog.log");

		FirefoxOptions options = new FirefoxOptions();

		options.setAcceptInsecureCerts(true);

		options.addArguments("--disable-notifications");
		options.addArguments("--disable-geolocation");

		return new FirefoxDriver(options);
	}
}
