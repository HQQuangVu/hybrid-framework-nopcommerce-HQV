package javaBasic;

public class Topic_10_Break_Continue {

	public static void main(String[] args) {

		// Nested for
		for (int i = 0; i <= 10; i++) {
			if (i == 5) {
				continue;
			}
			System.out.println("i = " + i);
			for (int j = 1; i <= 10; j++) {
				if (j == 5) {
					continue;
				}
				System.out.println("j = " + j);

			}
		}
	}

}
