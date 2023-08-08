package javaOOP;

public class Topic_09_Overriding_Employee extends Topic_09_Overriding_Person implements Topic_09_Overriding_IWork {
	@Override
	public void eat() {
		System.out.println("15000 VND meal");
	}

	// extend abstract class Person nên bắt buộc phải override
	@Override
	public void sleep() {
		System.out.println("Bắt buộc phải override..");
	}

	@Override
	public void workingTime() {
		System.out.println("Work 10 hours");
	}

}
