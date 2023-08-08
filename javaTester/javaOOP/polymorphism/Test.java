package javaOOP.polymorphism;

public class Test {

	public static void main(String[] args) {
		Animal ani = new Animal();
		ani.eat();

		// add kiểu của lớp con
		// trong quá trình runtime sẽ sử dụng method eat của lớp con Pig
		ani = new Pig();
		ani.eat();
	}

}
