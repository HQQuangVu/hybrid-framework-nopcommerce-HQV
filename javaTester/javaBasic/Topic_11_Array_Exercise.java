package javaBasic;

import org.testng.annotations.Test;

public class Topic_11_Array_Exercise {

	int number[] = { 1, 5, 6, 10, 11, 50 };

	@Test
	public void TC_01() {
		int x = 0;
		for (int i = 0; i < number.length; i++) {
			if (x < number[i]) {
				x = number[i];
			}
			System.out.println("Max number = " + x);
		}
	}

	@Test
	public void TC_02_Sum_First_And_Last() {
		int sum = 0;
		sum = number[0] + number[number.length - 1];
		System.out.println("Tổng của 2 số đầu tiên và cuối cùng trong mảng = " + sum);
	}

	@Test
	public void TC_03_Even_Number() {
		for (int i = 0; i < number.length; i++) {
			if (number[i] % 2 == 0) {
				System.out.println(number[i]);
			}
		}
	}

	@Test
	public void TC_04_Sum_All() {
		int sum = 0;
		for (int i = 0; i < number.length; i++) {
			if (number[i] % 2 == 1) {
				sum = sum + number[i];
			}
		}
		System.out.println("Tổng các số lẻ trong mảng = " + sum);
	}

	@Test
	public void TC_05_Sum_Within() {
		int sum = 0;
		for (int i = 0; i < number.length; i++) {
			if (number[i] >= 0 && number[i] <= 20) {
				sum += number[i];
			}
		}
		System.out.println("Tổng các số trong khoảng 0 >> 20 = " + sum);
	}
}
