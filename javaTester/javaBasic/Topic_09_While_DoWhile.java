package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_While_DoWhile {
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

	}

	@Test
	public void TC_01_For() {

		int number = scanner.nextInt();
		for (int i = number; i < 100; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}

	}

	@Test
	public void TC_02_While() {

		int number = scanner.nextInt();
		while (number < 100) {
			if (number % 2 == 0) {
				System.out.println(number);
				number++;
			}
		}
	}

	@Test
	public void TC_03_While() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();

		while (numberA < numberB) {
			if (numberA % 15 == 0) {
				System.out.println(numberA);
			}
			numberA++;
		}
	}

}
