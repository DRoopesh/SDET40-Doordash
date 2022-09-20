//Login as user -> Select Dish from Homepage -> Place the Order -> Logout

package testcasesbackup;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sdet40.genericUtility.DataType;
import org.sdet40.genericUtility.ExcelUtility;
import org.sdet40.genericUtility.IConstantPath;
import org.sdet40.genericUtility.JavaUtility;
import org.sdet40.genericUtility.WebDriverUtility;

public class Testcase3 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException  {
		String sheetName = "CommonData";
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		ExcelUtility excelUtility = new ExcelUtility();
		JavaUtility javaUtility = new JavaUtility();
		
		excelUtility.initializeTheFile(IConstantPath.EXCELFILE_PATH);	
		
		String userurl = excelUtility.getDataFromExcel(sheetName, 1, 1); 
		String browser = excelUtility.getDataFromExcel(sheetName, 2, 1);
		String username = excelUtility.getDataFromExcel(sheetName, 3, 1); 	
		String password = excelUtility.getDataFromExcel(sheetName, 4, 1);	
		String homeDishName = excelUtility.getDataFromExcel(sheetName, 10, 1);	
		String timeouts = excelUtility.getDataFromExcel(sheetName, 11, 1);
		long Timeouts = (long) javaUtility.convertStringToAnyDatatype(timeouts, DataType.LONG);
		
		WebDriver driver = webDriverUtility.openBrowserWithApplication(browser, Timeouts, userurl);
		driver = webDriverUtility.Login(driver, username, password);

		driver.findElement(By.xpath("//a[text()='"+homeDishName+"']/ancestor::div[@class='content']//div/following-sibling::div/a[@class='btn theme-btn-dash pull-right']")).click();
		driver.findElement(By.xpath("//a[text()='"+homeDishName+"']/ancestor::div/following-sibling::div//span[@class='price pull-left']/following-sibling::input[@class='btn theme-btn']")).click();
		driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg active']")).click();
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		webDriverUtility.acceptAlert(driver);
		webDriverUtility.acceptAlert(driver);
		System.out.println("Order placed successfully :"+homeDishName);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();

		webDriverUtility.closeTheBrowser(driver);
	}
}