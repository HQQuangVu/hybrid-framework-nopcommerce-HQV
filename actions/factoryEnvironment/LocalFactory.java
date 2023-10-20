package factoryEnvironment;

import org.openqa.selenium.WebDriver;

import factoryBrowser.BrowserList;
import factoryBrowser.BrowserNotSupportedException;
import factoryBrowser.DriverManagerChrome;
import factoryBrowser.DriverManagerEdge;
import factoryBrowser.DriverManagerFirefox;
import factoryBrowser.DriverManagerHeadlessChrome;
import factoryBrowser.DriverManagerHeadlessFirefox;
import factoryBrowser.DriverManagerSafari;

public class LocalFactory {
	private String browserName;
	private WebDriver driver;

	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}

	public WebDriver createDriver() {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

		switch (browser) {
		case FIREFOX:
			driver = new DriverManagerFirefox().getBrowserDriver();
			break;
		case CHROME:
			driver = new DriverManagerChrome().getBrowserDriver();
			break;
		case EDGE:
			driver = new DriverManagerEdge().getBrowserDriver();
			break;
		case SAFARI:
			driver = new DriverManagerSafari().getBrowserDriver();
			break;
		case H_FIREFOX:
			driver = new DriverManagerHeadlessFirefox().getBrowserDriver();
			break;
		case H_CHROME:
			driver = new DriverManagerHeadlessChrome().getBrowserDriver();
			break;
		default:
			throw new BrowserNotSupportedException(browserName);
		}

		return driver;
	}
}
