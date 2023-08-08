package javaBasic;

public class Topic_04_Primitive_Casting {

	public static void main(String[] args) {
		// Ngầm định >> Không mất dữ liệu
		//		byte bNumber = 125;
		//		System.out.println(bNumber);
		//		short sNumber = bNumber;
		//		System.out.println(sNumber);
		//		int iNumber = sNumber;
		//		System.out.println(iNumber);
		//		long lNumber = iNumber;
		//		System.out.println(lNumber);
		//		float fNumber = lNumber;
		//		System.out.println(fNumber);
		//		double dNumber = fNumber;
		//		System.out.println(dNumber);
		
		// Tường minh
		double dNumber = 48375687;
		System.out.println(dNumber);
		
		float fNumber = (float) dNumber;
		System.out.println(fNumber);

	}

}
