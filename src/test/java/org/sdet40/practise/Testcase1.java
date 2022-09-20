//Roopesh: Login as User -> Place the order through restaurant module -> Logout
package org.sdet40.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sdet40.genericUtility.DataType;
import org.sdet40.genericUtility.FileUtility;
import org.sdet40.genericUtility.IConstantPath;
import org.sdet40.genericUtility.JavaUtility;
import org.sdet40.genericUtility.WebDriverUtility;

public class Testcase1 {
	public static void main(String[] args) throws InterruptedException {
		JavaUtility javaUtility = new JavaUtility();
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		FileUtility fileUtility = new FileUtility();

		fileUtility.initializeTheFile(IConstantPath.PROPERTYFILE_PATH);

		String browser = fileUtility.getDataFromPropertyFile("browser");
		String userurl = fileUtility.getDataFromPropertyFile("userurl");
		String username = fileUtility.getDataFromPropertyFile("username");
		String password = fileUtility.getDataFromPropertyFile("password");
		String timeouts = fileUtility.getDataFromPropertyFile("timeout");
		long Timeouts = (long) javaUtility.convertStringToAnyDatatype(timeouts, DataType.LONG);
		WebDriver driver = webDriverUtility.openBrowserWithApplication(browser, Timeouts, userurl);


		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("buttn")).click();
		driver.findElement(By.linkText("Restaurants")).click();
		driver.findElement(By.linkText("View Menu")).click();

		String dishname = fileUtility.getDataFromPropertyFile("dishname");
		driver.findElement(By.xpath("(//input[@class='btn theme-btn'])[1]")).click();	// Change xpath as per dishname->Add To Cart
		driver.findElement(By.linkText("Checkout")).click();
		driver.findElement(By.xpath("//span[text()='Cash on Delivery']")).click();
		driver.findElement(By.name("submit")).click();
		webDriverUtility.acceptAlert(driver);
		Thread.sleep(1000);
		webDriverUtility.acceptAlert(driver);
		Thread.sleep(1000);
		driver.findElement(By.linkText("Logout")).click();
		webDriverUtility.closeTheBrowser(driver);
	}
}
