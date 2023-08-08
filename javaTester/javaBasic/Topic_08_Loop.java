package javaBasic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Topic_08_Loop {
		WebDriver driver;
		@Test
		public void TC_01_For() {
			// i = 0
			// 0<5 điều kiện đúng nên chạy vào phần thân >> in ra i
			// sau đó i++ >> i = 1
			for (int i = 0; i <= 5; i++) {
				System.out.println(i);
			}

			String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho"};
			// Array/ List/ Set/ Queue (index)
			// index luôn tính từ 0
			for (int i = 0; i < cityName.length; i++) {
				System.out.println(cityName[i]);
			}
			// for kết hợp if : Thỏa mãn điều kiện mới action
			for (int i = 0; i < cityName.length; i++) {
				if(cityName[i].equals("Ha Noi")) {
					System.out.println("Do action");
					break;
				}				
			}
		}
		@Test
		public void TC_02_ForEach() {
			// ForEach không thể chạy ngược mảng, không tìm được vị trí trong mảng
			// Array
			String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho", "Hai Phong"};
			
			// Java Collection
			// Class: ArrayList/ LinkedList/ Vector/...
			// Interface : List/ Set/ Queue
			List<String> cityAddress = new ArrayList<String>();
			// Compile
			cityAddress.add("Bac Giang");
			cityAddress.add("Bac Lieu");
			cityAddress.add("Ha Nam");
			// Runtime
			for (String city : cityName) {
				cityAddress.add(city);				
			}
			System.out.println(cityAddress.size());
			// Java Generic
			
			List<WebElement> links = driver.findElements(By.cssSelector("//a"));
			// Xử lý dữ liệu
			for (WebElement link : links) {
				link.clear();
			}
			
		}		
}
