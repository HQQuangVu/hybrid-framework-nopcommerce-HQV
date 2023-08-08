package javaOOP;

public class Topic_02_Variable_Property {
	// Access Modifier
	// Data Type
	// Variable Name
	// Variable Value
	private String studentName = "Automation"; // Global Variable
	// Default access modifier
	int studentID = 10005;

	// Static variable - Có thể gán lại giá trị
	// Hàm static có thể truy cập trực tiếp không cần thông qua đối tượng
	public static String studentAddress = "Ho Chi Minh";
	// Dùng trong phạm vi class - cho tất cả instance/ object
	private static String studentPhone = "0987654322";

	// Final variable - Không thể gán lại giá trị
	final String country = "Viet Nam";

	// Static final variable - Hằng số - Không được ghi đè
	// Có thể truy cập rộng rãi cho tất cả instance/ thread
	static final float PI_NUMBER = 3.14159f;

	// Hàm - Method static
	public static void main(String[] args) {

		String studentName = "AutomationHQ";
		if (studentName.startsWith("Automation")) {
			// Biến cục bộ - Block code
			int number = 100;
		}
		studentAddress = "Ha Noi";
		studentPhone = "0987666444";

	}

	// Constructor
	public Topic_02_Variable_Property() {
		String studentname = "Wew";
	}

	// Hàm (Method) - non static
	public void display() {
		// Local Variable - Hàm
		studentName = "Automation";
	}
}
