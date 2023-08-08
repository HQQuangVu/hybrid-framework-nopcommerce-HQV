package javaOOP.polymorphism;

public class Operator {

	public void sum(int a, int b) {
		System.out.println("1st int + int");
	}

	public void sum(int a, float b) {
		System.out.println("2nd int + float");
	}

	public void sum(int a, double b) {
		System.out.println("3rd int + double");
	}

	public static void main(String[] args) {
		Operator opr = new Operator();
		// Trình biên dịch sẽ chọn phương thức nào
		opr.sum(3, 7);
		opr.sum(2, 10.5f);
		opr.sum(10, 6.342d);

	}

}
