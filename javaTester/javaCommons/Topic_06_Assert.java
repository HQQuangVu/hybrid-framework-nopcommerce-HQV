package javaCommons;

import org.testng.Assert;

public class Topic_06_Assert {

	public static void main(String[] args) {
		// Assert
		String fullName = "Automation Testing";
		// Mong đợi 1 điều kiện trả về là đúng (true)
		Assert.assertTrue(fullName.contains("Automation"));
		
		// Mong đợi 1 điều kiện trả về là sai (false)
		Assert.assertFalse(fullName.contains("Manual"));
		
		// Mong đợi 2 điều kiện bằng nhau
		// Expected Result = Actual Result
		Assert.assertEquals(fullName, "Manual");
	}

}
