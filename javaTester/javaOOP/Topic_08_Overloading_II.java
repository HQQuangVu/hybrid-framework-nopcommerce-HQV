package javaOOP;

public class Topic_08_Overloading_II {

	private int firstNumber;
	private int secondNumber;

	public void sumNumber() {
		System.out.println(this.firstNumber + this.secondNumber);
	}

	public void sumNumber(int number) {
		System.out.println(number + (number * 10 / 100));
	}

	public void sumNumber(int firstNumber, float secondNumber) {
		System.out.println(this.firstNumber + this.secondNumber);
	}

	public static void main(String[] args) {

	}

}
