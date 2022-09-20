package org.sdet40.practise;

import org.openqa.selenium.WebDriver;
import org.sdet40.genericUtility.WebDriverUtility;
import org.testng.annotations.Test;

public class CmdPromptPracticeTest {
@Test
	public void fetchDataFromCmd() {
		String browser = System.getProperty("b");
		String url = System.getProperty("u");
		
		System.out.println("Browser is :"+browser);
		System.out.println("URL is :"+url);
		
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		webDriverUtility.openBrowserWithApplication(browser, 10l, url);
	}
}
