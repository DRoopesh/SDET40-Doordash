// Program to demonstrate soft Assert

package org.sdet40.practise;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertPractice2 {

	@Test
	public void test1() {
		SoftAssert soft = new SoftAssert();
		String actual = "Good";
		String expected = "Good ";
		Reporter.log("Test1", true);
		soft.assertEquals(actual, expected);
		Reporter.log("Test11", true);
		soft.assertTrue(1!=4 && actual.contains(expected) && actual.contains(expected), "Verifying 1 with 4 and whether actual contains expected");
		soft.assertAll();
		soft.assertEquals("A", "B");
		Reporter.log("test12", true);
	}
	
	@Test
	public void test2() {
		Reporter.log("test2");
	}
}
