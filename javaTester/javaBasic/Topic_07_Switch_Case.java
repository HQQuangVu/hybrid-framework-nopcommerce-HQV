package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_07_Switch_Case {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);
	
	@Parameters("browser")
	@Test
	public void TC_01_Switch_Case_Browser(String browserName) {
	driver = getBrowserDriver(browserName);
	System.out.println(browserName);
	driver.quit();
	}
	public WebDriver getBrowserDriver(String browserName) {
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			 new RuntimeException("Please input correct browser name!");
			 break;
		}
		return driver;
	}
	@Test
	public void TC_02() {
		int month = scanner.nextInt();
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("Tháng này có 31 ngày");
			break;
		case 2:
			System.out.println("Tháng này có 28 ngày");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Tháng này có 30 ngày");
			break;

		default:
			System.out.println("Vui lòng nhập tháng trong khoảng tháng 1 > 12");
			break;
		}
	}
	@Test
	public void TC_03() {
		// Chỉ có thể chạy với các kiểu Int/ String/ Enum - hằng số..
		// Không thể dùng các toán tử Operator trong case: = < > == != 
		int cNumber = scanner.nextInt();
		switch (cNumber) {
		case 1:
			System.out.println("One");
		case 2:
			System.out.println("Two");
		case 3:
			System.out.println("Three");
		case 4:
			System.out.println("Four");
		case 5:
			System.out.println("Five");
		case 6:
			System.out.println("Six");
		case 7:
			System.out.println("Seven");
		case 8:
			System.out.println("Eight");
		case 9:
			System.out.println("Nine");
		case 10:
			System.out.println("Ten");
	
		default:
			System.out.println("Nhập số nguyên trong khoảng 1 > 10");
			break;
		}
	}
	@Test
	public void TC_04() {
		System.out.println("Nhập phép toán + - * / hoặc %");
		String operator = scanner.nextLine();
		System.out.println("Nhập số A = ");
		int numberA = scanner.nextInt();
		System.out.println("Nhập số B = ");
		int numberB = scanner.nextInt();

		switch (operator) {
		case "+":
			System.out.println("A + B = " + (numberA + numberB));
			break;
		case "-":
			System.out.println("A - B = " + (numberA - numberB));
			break;
		case "*":
			System.out.println("A * B = " + (numberA * numberB));
			break;
		case "/":
			System.out.println("A / B = " + (numberA / numberB));
			break;
		case "%":
			System.out.println("A % B = " + (numberA % numberB));
			break;

		default:
			break;
		}
	}
}
