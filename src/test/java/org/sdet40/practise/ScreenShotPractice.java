package org.sdet40.practise;

import org.sdet40.genericUtility.BaseClass;
import org.sdet40.genericUtility.ListenerImplementation;
import org.testng.annotations.Test;

public class ScreenShotPractice extends BaseClass{
	@Test
	public void screenShot() throws Throwable{
	ListenerImplementation.stest.assignAuthor("Varma");
	ListenerImplementation.stest.assignCategory("Regression");
}
}
