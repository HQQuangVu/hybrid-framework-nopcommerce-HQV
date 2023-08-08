package javaCommons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_XPathCSS_Ex {
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void TC_01_Empty_Data() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		// Ít bị sai cú pháp/ không đúng đóng mở ngoặc
		// Suggest code lại : CTRL SPACE
		driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();
		
		// Verify
		// Assert.assertTrue >>  kiểm tra 1 điều kiện trả về là đúng
		// Assert.assertFalse >> kiểm tra 1 điều kiện trả về là sai
		// Assert.assertEquals>> kiểm tra hàm về như thực tế và mong đợi
		
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
		
				
		
		
		
	}

	@Test
	public void TC_02_Invalid_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("HQuangVu");
		driver.findElement(By.id("txtEmail")).sendKeys("Hqvu@12345@5454");
		driver.findElement(By.id("txtCEmail")).sendKeys("gqqy@3446@445");
		driver.findElement(By.id("txtPassword")).sendKeys("123567688");
		driver.findElement(By.id("txtCPassword")).sendKeys("324747364");
		driver.findElement(By.id("txtPhone")).sendKeys("0123456789");
		
		driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");

		
		

	}

	@Test
	public void TC_03_Incorrect_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("HQuangVu");
		driver.findElement(By.id("txtEmail")).sendKeys("Hqvu@12345.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("Hqvu@12345.net");
		driver.findElement(By.id("txtPassword")).sendKeys("123567688");
		driver.findElement(By.id("txtCPassword")).sendKeys("324747364");
		driver.findElement(By.id("txtPhone")).sendKeys("0123456789");
		driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
		
		
		
		
		
		
	}

	@Test
	public void TC_04_Invalid_Password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("HQuangVu");
		driver.findElement(By.id("txtEmail")).sendKeys("Hqvu@12345.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("Hqvu@12345.com");
		driver.findElement(By.id("txtPassword")).sendKeys("123");
		driver.findElement(By.id("txtCPassword")).sendKeys("324747364");
		driver.findElement(By.id("txtPhone")).sendKeys("0123456789");
		driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");

		
		
	}
	@Test
	public void TC_05_Incorrect_Password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("HQuangVu");
		driver.findElement(By.id("txtEmail")).sendKeys("Hqvu@12345.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("Hqvu@12345.com");
		driver.findElement(By.id("txtPassword")).sendKeys("324747364");
		driver.findElement(By.id("txtCPassword")).sendKeys("3456758");
		driver.findElement(By.id("txtPhone")).sendKeys("0123456789");
		driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");		

		
	}
	@Test
	public void TC_06_Invalid_PhoneNumber() {
		//Action 1
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("HQuangVu");
		driver.findElement(By.id("txtEmail")).sendKeys("Hqvu@12345.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("Hqvu@12345.com");
		driver.findElement(By.id("txtPassword")).sendKeys("324747364");
		driver.findElement(By.id("txtCPassword")).sendKeys("324747364");
		driver.findElement(By.id("txtPhone")).sendKeys("098345678");
		driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
		
		//Action 2
		driver.findElement(By.id("txtPhone")).clear();
		driver.findElement(By.id("txtPhone")).sendKeys("098345678912");
		driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
		
		//Action 3
		driver.findElement(By.id("txtPhone")).clear();
		driver.findElement(By.id("txtPhone")).sendKeys("98345678912");
		driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
		

		
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}