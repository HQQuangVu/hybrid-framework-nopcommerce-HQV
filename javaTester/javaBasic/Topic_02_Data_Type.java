package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
	// Global variable
	static int number;
	
	// Primitive type : Kiểu dữ liệu nguyên thủy
	byte bNumber = 6;	
	short sNumber = 1111;
	int iNumber = 12354;	
	long lNumber = 65000;	
	float fNumber = 5.6f;	
	double dNumber = 15.11d;	
	char cCharacter = 'A';	
	boolean bStatus = false;
	
	// Reference - non primitive type : Kiểu dữ liệu tham chiếu
	// String
	String address = "Ho Chi Minh";	
	// Array
	String[] studentAddress = {address, "Ha Noi", "Da Nang"};
	Integer[] studentNumber = { 15, 20, 30 };
	// Class
	Topic_02_Data_Type topic2;	
	// Interface
	WebDriver driver;	
	// Object
	Object aObject; // Có thể convert sang các kiểu dữ liệu khác	
	// Collection -- List/ Set/ Queue/ Map/...
	List<WebElement> homepageLink = driver.findElements(By.id("a"));
	Set<String> allWindows = driver.getWindowHandles();
	List<String> productName = new ArrayList<String>();
	
	public void referenceExamples() {
		address.toString();
		
		driver.getCurrentUrl();
		
		homepageLink.isEmpty();
		
		productName.size();
	}
	
	public static void main(String[] args) {
		// Local variable - phải gán giá trị mới có thể sử dụng
		int studentNumber = 0;
		
		System.out.println(number);
		
		Topic_02_Data_Type topic = new Topic_02_Data_Type();
		System.out.println(topic.address);
		
		System.out.println(studentNumber);
	}
}
