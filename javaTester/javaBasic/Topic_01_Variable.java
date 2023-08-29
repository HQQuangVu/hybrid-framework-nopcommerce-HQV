// package javaBasic;
//
// import java.util.Scanner;
//
// public class Topic_01_Variable {
// public Topic_01_Variable() {
// String studentName;
//
// }
//
// static int studentNumber;
// static boolean statusValue;
// // Khi dùng static + final java sẽ coi đây là hằng số - constant, nên được viết HOA
// static final String BROWSER_NAME = "Chrome";
// String studentName = "Automation";
//
// public static void main(String[] args) {
// System.out.println(studentNumber);
// System.out.println(statusValue);
//
// // Biến static truy cập thông qua class
// System.out.println(Topic_01_Variable.BROWSER_NAME);
//
// Topic_01_Variable topic_1 = new Topic_01_Variable();
// Topic_01_Variable topic_2 = new Topic_01_Variable();
// Topic_01_Variable topic_3 = new Topic_01_Variable();
// // Biến global truy cập thông qua đối tượng
// System.out.println(topic_1.studentName);
// System.out.println(topic_2.studentName);
// System.out.println(topic_3.studentName);
// Scanner scanner = new Scanner(System.in);
// String name = scanner.nextLine();
// System.out.println(name);
// System.out.println(name);
//
// }
// // Get: getCurrentUrl/ getTitle/ getText/ getAttribute/ getCssValue/ getSize/ getLocation/...
// public String getStudentName() {
// return this.studentName;
// }
//
// // Set: click/ sendkey/ clear/ select/ back/ forward/ refresh/ get/...
// public void setStudentName(String stdName) {
// this.studentName = stdName;
// }
//
//
// }
