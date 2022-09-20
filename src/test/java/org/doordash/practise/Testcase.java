// Navigate to url -> Register the user -> Login as user -> Logout
package org.doordash.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sdet40.genericUtility.DataType;
import org.sdet40.genericUtility.ExcelUtility;
import org.sdet40.genericUtility.IConstantPath;
import org.sdet40.genericUtility.JavaUtility;
import org.sdet40.genericUtility.WebDriverUtility;

public class Testcase {
	public static void main(String[] args) {
		WebDriver driver = null;
		String sheetName = "CommonData";

		WebDriverUtility webDriverUtility = new WebDriverUtility();
		ExcelUtility excelUtility = new ExcelUtility();
		JavaUtility javaUtility = new JavaUtility();

		excelUtility.initializeTheFile(IConstantPath.EXCELFILE_PATH);
		int randomNumber = javaUtility.getRandomNumber(1000);
		String url = excelUtility.getDataFromExcel(sheetName, 0, 1);
		String userurl = excelUtility.getDataFromExcel(sheetName, 1, 1);
		String browser = excelUtility.getDataFromExcel(sheetName, 2, 1);
		String newUserName = excelUtility.getDataFromExcel(sheetName, 14, 2);
		String firstName = excelUtility.getDataFromExcel(sheetName, 15, 2);
		String lastName = excelUtility.getDataFromExcel(sheetName, 16, 2);
		String email = excelUtility.getDataFromExcel(sheetName, 17, 2);
		String phoneNumber = excelUtility.getDataFromExcel(sheetName, 18, 2);
		String password = excelUtility.getDataFromExcel(sheetName, 19, 2);
		String deliveryAddress = excelUtility.getDataFromExcel(sheetName, 20, 2);
		String timeouts = excelUtility.getDataFromExcel(sheetName, 11, 1);
		long TimeOuts = (long) javaUtility.convertStringToAnyDatatype(timeouts, DataType.LONG);
		
		driver = webDriverUtility.openBrowserWithApplication(browser, TimeOuts, url);
		System.out.println("Random number:"+randomNumber);
		System.out.println("Username is :"+newUserName+randomNumber);
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(newUserName+randomNumber);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);				
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phoneNumber);	
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);	
		driver.findElement(By.xpath("//input[@name='cpassword']")).sendKeys(password);	
		driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys(deliveryAddress);	
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		
		driver= webDriverUtility.navigateTheApplication(driver, userurl);
		driver = webDriverUtility.Login(driver, newUserName+randomNumber, password);
		WebElement we = driver.findElement(By.xpath("//a[text()='Logout']"));
		webDriverUtility.waittillElementisVisible(driver, TimeOuts, we);
		if(we.isDisplayed())
			System.out.println("Login successful by new user. Test case passed.");
		we.click();
		
		excelUtility.closeTheWorkbook();
		webDriverUtility.closeTheBrowser(driver);
	}
}