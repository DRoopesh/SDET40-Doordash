package org.doordash.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sdet40.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSPractice {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	WebDriverUtility webDriverUtility = new WebDriverUtility();
	driver.manage().window().maximize();
	webDriverUtility.jsInitilization(driver);
//	String url;
	webDriverUtility.openApplicationUsingJS("http://rmgtestingserver/domain/Online_Food_Ordering_System/login.php");
	webDriverUtility.sendKeysUsingJS(driver.findElement(By.xpath("//input[@placeholder='Username']")), "drv");
	webDriverUtility.sendKeysUsingJS(driver.findElement(By.xpath("//input[@placeholder='Password']")), "drv469");
	webDriverUtility.clickUsingJS(driver.findElement(By.id("buttn")));
	webDriverUtility.scrollTillElementUsingJS(driver.findElement(By.xpath("//footer//div[@class='row']")));
}
}
