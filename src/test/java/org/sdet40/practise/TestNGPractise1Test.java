package org.sdet40.practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractise1Test{
	@Test(groups = {"sanity", "regression"})
	public void step2Test() {
		Assert.fail();
		System.out.println("Script2");
	}
	
	@Test(groups = "regression", retryAnalyzer = org.sdet40.genericUtility.RetryImplementation.class)
	public void step1Test() {
		Assert.fail();
		System.out.println("Script1");
	}
}
