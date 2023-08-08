package javaOOP;

public class Topic_05_Non_Access_Modifier {

	// Static: Variable/ Method
	// Dùng cho tất cả các instance/ object
	// Phạm vi cho toàn bộ system sử dụng
	// Có thể override
	static String browserName = "Chrome";

	// Non-static
	String serverName = "Test";

	final String colorCar = "Red";

	public static void main(String[] args) {

		System.out.println(browserName);

		Topic_05_Non_Access_Modifier test = new Topic_05_Non_Access_Modifier();
		System.out.println(test.serverName);

	}

}
