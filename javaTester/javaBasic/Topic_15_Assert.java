package javaBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commons.BaseTest;

@Listeners(commons.MethodListener.class)
public class Topic_15_Assert extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01() {
		System.out.println("Assert 01 - Passed");
		String loginPageUrl = driver.getCurrentUrl();
		verifyEquals(loginPageUrl, "https://www.facebook.com/");

		System.out.println("Assert 02 - Failed");
		String loginPageTitle = driver.getTitle();
		verifyEquals(loginPageTitle, "Facebook - login or sign up....");

		System.out.println("Assert 03 - Passed");
		verifyTrue(driver.findElement(By.xpath("//input[@id='email']")).isDisplayed());

		System.out.println("Assert 04 - Failed");
		verifyFalse(driver.findElement(By.xpath("//input[@id='email']")).isDisplayed());

		System.out.println("Assert 05 - Passed");
		verifyTrue(driver.findElement(By.xpath("//button[@name='login']")).isDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}