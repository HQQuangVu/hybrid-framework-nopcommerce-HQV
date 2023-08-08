package javaBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_06_Condition_Statement {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	@Test
	public void TC_01_If() {
	boolean status = 5>3;
	System.out.println(status);
	// Hàm if sẽ nhận vào 1 điều kiện đúng
	if (status) {
		// Đúng thì vào phần thân của if, sai thì bỏ qua
		System.out.println("Go to if");
	}
	WebDriver driver = new FirefoxDriver();
	// Element không có trong DOM khi popup hiển thị
	List<WebElement> salePopups = driver.findElements(By.id(""));
	// Check element không hiển thị
	if (salePopups.size() > 0 && salePopups.get(0).isDisplayed() ) {
	
	}
	// Uncheck checkboxes
	WebElement testCheckbox = driver.findElement(By.id(""));
	if (testCheckbox.isSelected()) {
		testCheckbox.click();
	}
	
	// Có 2 điều kiện: Nếu đúng vào if , sai vào else

	}
	
	@Test
	public void TC_02_If_Else() {
		// Có 2 điều kiện : True > vào if, False > vào else
		
		// Nếu driver start với browser như Chrome/ Firefox/ Edge >> dùng hàm click Selenium
		// Nếu driver là IE >> dùng click JavascriptExecutor
		System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
	
		System.out.println(driver.toString());
	
		if (driver.toString().contains("internet explorer")) {
			System.out.println("Click by Javascript Executor");
		}	else {
			System.out.println("Click by Selenium WebElement");
		}
			
	
	}
	
	// Sử dụng TestNG xml để run TC này
	@Parameters("browser")
	@Test
	public void TC_03_If_Else_If_Else(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if(browserName.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}  else { // Safari/ Opera/ CocCoc/...
			throw new RuntimeException("Please input correct browser name!");
		}
	System.out.println(browserName);	
	System.out.println(driver.toString());
	}
	
	@Test
	public void TC_04_If_Else_If_Else() {
		// if else
		int age = 20;
		String access = (age <18) ? "You can not access" : "Welcome to our system!";
		
		if (age<18) {
			access = "You can not access";
		} else {
			access = "Welcome to our system!";
		}
		System.out.println(access);
	}
}
