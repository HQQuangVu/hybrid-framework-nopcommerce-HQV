package javaBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Topic_11_Array {

	public static void main(String[] args) {

		String studentName[] = { "Nguyen Anh", "Minh Trang", "Vu Long" };
		studentName[0] = "Nhu Quynh";
		System.out.println(studentName[0]);

		int b[] = new int[5];
		b[0] = 10;
		for (int i = 0; i < studentName.length; i++) {
			System.out.println(studentName[i]);
		}

		for (String std : studentName) {
			if (std.equals("Minh Trang")) {
				System.out.println("Click vào Minh Trang");
			}
		}

		// Động
		ArrayList<String> stdName = new ArrayList<String>();
		// Khi chạy code mới add thêm
		for (String std : stdName) {
			stdName.add(std);
		}

		List<String> names = Arrays.asList("Phong", "Minh", "Duc");
		for (String name : names) {
			System.out.println("Name: " + name);
		}

		String student_Name = Arrays.toString(studentName);
		// Sẽ in ra 1 chuỗi String
		System.out.println(student_Name);
	}

}
