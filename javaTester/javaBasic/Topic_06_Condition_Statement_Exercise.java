package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_06_Condition_Statement_Exercise {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);

	@Test
	public void TC_01_If() {
		int number = scanner.nextInt();

		int afterMathNumber = number % 2;
		System.out.println("Phần dư là" + afterMathNumber);
		boolean status = afterMathNumber == 0;

		if (status) {
			System.out.println("Số " + number + "là số chẵn");
		} else {
			System.out.println("Số " + number + "là số lẻ");
		}
	}

	@Test
	public void TC_02() {
		System.out.println("Nhập vào số A");
		int numberA = scanner.nextInt();
		System.out.println("Nhập vào số B");
		int numberB = scanner.nextInt();

		if (numberA > numberB) {
			System.out.println("Số " + numberA + "Lớn hơn " + numberB);
		} else if (numberA == numberB) {
			System.out.println("Số " + numberA + "Bằng " + numberB);
		} else {
			System.out.println("Số " + numberA + "Nhỏ hơn  " + numberB);
		}
	}

	@Test
	public void TC_03() {
		String firstStudent = scanner.nextLine();
		String secondStudent = scanner.nextLine();

		// Sử dụng equals để so sánh các giá trị dạng Reference, ở đây là String
		// equals sẽ kiểm tra value và vị trí của biến
		if (firstStudent.equals(secondStudent)) {
			System.out.println("Học sinh có tên giống nhau");
		} else {
			System.out.println("Học sinh có tên khác nhau");
		}
		// Sử dụng == để so sánh các giá trị kiểu Primitive - nguyên thủy
	}
}
