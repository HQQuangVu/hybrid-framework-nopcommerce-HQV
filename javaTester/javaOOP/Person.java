package javaOOP;

public class Person {
	private String personName;

	public class Student {
		String name = "InnerName";
	}

	public static void main(String[] args) {
		Person person = new Person();
		Person.Student student = person.new Student();
		person.personName = "OuterName";
		student.name = "InnerName";

	}

}
