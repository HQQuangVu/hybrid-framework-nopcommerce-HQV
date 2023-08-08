package javaBasic;

import org.testng.annotations.Test;

public class Topic_12_String_Exercise {

	String courseName = "Automation TestinG 2023 Advanced";

	@Test
	public void TC_01() {
		// Count upperCase/ lowerCase/ number in String

		// Convert string >> Char array
		char[] courseNameArr = courseName.toCharArray();
		int countUpperCase = 0;
		int countLowerCase = 0;
		int countNumber = 0;

		for (char character : courseNameArr) {
			// Uppercase
			if (character <= 'Z' && character >= 'A') {
				countUpperCase++;
			}

			// Lowercase
			if (character <= 'z' && character >= 'a') {
				countLowerCase++;
			}

			// Number
			if (character <= '9' && character >= '0') {
				countNumber++;
			}
		}
		System.out.println("Sum of upperCase = " + countUpperCase);
		System.out.println("Sum of lowerCase = " + countLowerCase);
		System.out.println("Sum of Number = " + countNumber);
	}

	@Test
	public void TC_02() {
		char[] courseNameArr = courseName.toCharArray();
		int count = 0;
		for (char c : courseNameArr) {
			if (c == 'o') {
				count++;
			}
		}
		System.out.println(count);
	}

	@Test
	public void TC_03() {
		char[] courseNameArr = courseName.toCharArray();
		// 1 Sử dụng collection
		// Collections.reverse(Arrays.asList(courseNameArr));
		// 2 Sử dụng StringBuilder
		// 3
		for (int i = courseNameArr.length - 1; i >= 0; i--) {
			System.out.println(courseNameArr[i]);
		}
	}
}
