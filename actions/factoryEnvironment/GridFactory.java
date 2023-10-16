package factoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

public class GridFactory {
	private WebDriver driver;
	private String browserName;
	private String ipAddress;
	private String portNumber;

	public GridFactory(String browserName, String ipAddress, String portNumber) {
		this.browserName = browserName;
		this.ipAddress = ipAddress;
		this.portNumber = portNumber;
	}

	public WebDriver createDriver() {
		DesiredCapabilities capability = null;

		switch (browserName) {
		case "firefox":
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.WINDOWS);

			FirefoxOptions fOptions = new FirefoxOptions();
			fOptions.merge(capability);
			break;
		case "chrome":
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.WINDOWS);

			ChromeOptions cOptions = new ChromeOptions();
			cOptions.merge(capability);
			break;
		case "edge":
			capability = DesiredCapabilities.edge();
			capability.setBrowserName("edge");
			capability.setPlatform(Platform.WINDOWS);

			EdgeOptions eOptions = new EdgeOptions();
			eOptions.merge(capability);
			break;
		case "safari":
			capability = DesiredCapabilities.safari();
			capability.setBrowserName("safari");
			capability.setPlatform(Platform.MAC);

			SafariOptions sOptions = new SafariOptions();
			sOptions.merge(capability);
			break;
		default:
			throw new RuntimeException("Browser is not valid!");
		}

		try {
			driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
}
