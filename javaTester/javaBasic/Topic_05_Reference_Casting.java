package javaBasic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Topic_05_Reference_Casting {
	public String studentName;
	public String getStudentName() {
		return getStudentName();
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public void showStudentName() {
		System.out.println("Student Name = " + studentName);
	}
	public static void main(String[] args) {
		Topic_05_Reference_Casting firstStudent = new Topic_05_Reference_Casting();
		Topic_05_Reference_Casting secondStudent = new Topic_05_Reference_Casting();
		
		firstStudent.setStudentName("Nguyen Van A");
		secondStudent.setStudentName("Bui Thi B");
		
		// Ép kiểu
		firstStudent = secondStudent;
		firstStudent.showStudentName();
		secondStudent.showStudentName();
		
		secondStudent.setStudentName("Hoang Minh C");
		firstStudent.showStudentName();
		secondStudent.showStudentName();
		
		WebDriver driver = null;
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	}

}
