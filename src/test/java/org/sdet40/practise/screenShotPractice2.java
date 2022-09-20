package org.sdet40.practise;

import org.sdet40.genericUtility.BaseClass;
import org.sdet40.genericUtility.ListenerImplementation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class screenShotPractice2 extends BaseClass{
	@Test
	public void screenShot() {
		ListenerImplementation.stest.assignAuthor("Roopesh");
		ListenerImplementation.stest.assignCategory("smoke");
		ListenerImplementation.stest.info("Browser launched successfully");
		ListenerImplementation.stest.info("Login Successful");
		ListenerImplementation.stest.info("Home page displayed successfully");
		Assert.fail();
	}
}
