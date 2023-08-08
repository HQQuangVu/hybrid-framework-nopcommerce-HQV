package javaCommons;

import java.util.Random;

public class Topic_05_Random {

	public static void main(String[] args) {
		// utilities 
		Random rand = new Random();
		System.out.println(rand.nextFloat());
		System.out.println(rand.nextInt());	
		System.out.println("hqquangvu" + rand.nextInt(9999) + "@gmail.net");	
		System.out.println(rand.nextDouble());
		System.out.println(rand.nextLong());
	}

}
