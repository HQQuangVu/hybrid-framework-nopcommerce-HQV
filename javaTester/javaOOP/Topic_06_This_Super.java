package javaOOP;

public class Topic_06_This_Super extends Base_OOP {
	private int firstNumber;
	private int secondNumber;

	// Có thể sử dụng this gọi từ constractor này sang constractor kia
	// this phải đặt ở dòng đầu tiên trong block code
	public Topic_06_This_Super() {
		this(12, 7);
		System.out.println("Constructor class con");
	}

	public Topic_06_This_Super(int firstNumber, int secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;

	}

	public void sumNumber() {
		System.out.println(this.firstNumber + this.secondNumber);
	}

	public void showNumber() {
		this.sumNumber();
	}

	public static void main(String[] args) {
		Topic_06_This_Super topic = new Topic_06_This_Super(14, 16);
		topic.sumNumber();
	}

}
