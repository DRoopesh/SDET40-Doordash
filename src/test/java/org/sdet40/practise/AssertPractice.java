// Program to demonstrate Assert

package org.sdet40.practise;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AssertPractice {

	@Test
	public void test1() {
		String actual = "Hello";
		String expected = "Hell";
		Reporter.log("test1", true);
		Assert.assertEquals(actual, expected);
		Reporter.log("Test11, true");
		Reporter.log(expected);
	}
	@Test
	public void test2() {
		Reporter.log("test2", true);
	}
}
