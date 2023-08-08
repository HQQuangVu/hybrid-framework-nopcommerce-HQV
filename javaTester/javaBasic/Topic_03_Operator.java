package javaBasic;

public class Topic_03_Operator {

	public static void main(String[] args) {
		int number = 10;
		number +=5; //  number = number +5; 
		System.out.println(number);
		// 15%7 = 2 dư 1 >> chia lấy phần dư trả về giá trị dư
		System.out.println(number % 7);
		
		// In number ra trước = 15 rồi mới tăng number lên 1 = 16
		System.out.println(number++);
		
		// Tăng number lên 1 = 17 rồi mới in number ra
		System.out.println(++number);
		
		for (int i = 0; i < 3; ++i) {
		System.out.println(i);			
		
		String address = "Da Nang";
		if (!(address == "Ha Noi")) {
			System.out.println("Address is different");
		}
		
		// Tam nguyên gồm dấu = ? :
		boolean status = (address == "Ha Noi") ? true : false;
		System.out.println(status);
		}
	}

}
