package javaBasic;

import java.util.Locale;

import com.github.javafaker.Faker;

public class Topic_17_Faker {
	public static void main(String[] args) {
		Faker faker = new Faker();
		System.out.println(faker.business().creditCardType());
		System.out.println(faker.business().creditCardNumber());
		System.out.println(faker.address().cityName());

		Faker fakerVi = new Faker(new Locale("vi"));
		System.out.println(fakerVi.address().firstName());
		System.out.println(fakerVi.address().lastName());
	}
}
