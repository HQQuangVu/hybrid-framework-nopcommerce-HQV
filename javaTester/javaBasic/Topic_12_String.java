package javaBasic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_12_String {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		String schoolName = "AutomationHQ";
		String courseName = "automationhq";
		String schoolAddress = "Ho Chi Minh";

		System.out.println("Độ dài Chuỗi" + schoolName.length());
		System.out.println("Lấy ra 1 kí tự ở vị trí đầu tiên - 0 " + schoolName.charAt(0));
		System.out.println("Nối 2 chuỗi với nhau" + schoolName.concat(schoolAddress));

		System.out.println("Kiểm tra -giá trị- 2 chuỗi có bằng nhau không" + schoolName.equals(schoolAddress));
		// equalsIgnoreCase
		System.out.println("Kiểm tra 2 chuỗi bằng nhau không, không quan tâm VIẾT HOA hay viết thường" + schoolName.equalsIgnoreCase(courseName));

		// startsWith/ endsWith/ contains
		System.out.println(schoolName.contains("Auto"));
		System.out.println(schoolName.startsWith("A"));
		System.out.println(schoolName.endsWith("Q"));

		// index trả về vị trí của kí tự đầu tiên
		System.out.println(schoolName.indexOf("utomation"));

		// Lấy ra kí tự /chuỗi kí tự từ vị trí thứ mấy đến kết thúc
		System.out.println("Tách chuỗi từ vị trí index " + schoolName.substring(9));

		// Lấy ra kí tự /chuỗi kí tự từ vị trí > vị trí
		System.out.println("Tách chuỗi từ vị trí index " + schoolName.substring(6, 10));

		// Tách chuỗi thành 1 mảng dựa vào 1 kí tự/ chuỗi kí tự
		String result = "Viewing 48 of 132 results";
		String results[] = result.split(" ");
		System.out.println(results[1]);

		// Replace & convert String to Float
		String productPrice = "$100";
		productPrice = productPrice.replace("$", "");

		float productPriceF = Float.parseFloat(productPrice);
		System.out.println(productPriceF);

		// Convert Float > String
		productPrice = String.valueOf(productPriceF);

		String osName = System.getProperty("os.name");
		System.out.println(osName);
		// Windows 10
		// Handle multiple OS: Mac/ Windows (Actions - key - Ctrol / Command)
		if (osName.toLowerCase().contains("windows")) {
			Keys key = Keys.CONTROL;
			System.out.println(key);
		} else {
			Keys key = Keys.COMMAND;
			System.out.println(key);
		}

		// Multi Browser: toUpperCase
		// firefox = FIREFOX (Enum)

		String driverInstanceName = driver.toString();
		System.out.println(driverInstanceName);
		// Close browser/ driver
		if (osName.contains("internetexplorer")) {
			// Dùng threadsleep thêm 5s sau mỗi sự kiện chuyển page
		}

		// Dùng trim để loại bỏ khoảng trắng/ xuống dòng \n tab \t
		String helloWorld = "				\n 	\t  	helloWorld		";
		helloWorld.trim();
		System.out.println(helloWorld);

		// Dynamic locator
		// Đại diện cho 1 chuỗi : %s / %b %t %d

		String dynamicButtonXpath = "//button[@id='%s']";
		System.out.println("Click to Login button" + String.format(dynamicButtonXpath, "login"));
		System.out.println("Click to Register button" + String.format(dynamicButtonXpath, "register"));
		System.out.println("Click to Search button" + String.format(dynamicButtonXpath, "search"));
	}

}
