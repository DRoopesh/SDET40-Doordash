//Roopesh: Test Scenario : Login as user->Place order->Logout ->Login as admin->Go to order->Change order status->Confirm order status->Logout

package testcasesbackup;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.sdet40.genericUtility.DataType;
import org.sdet40.genericUtility.ExcelUtility;
import org.sdet40.genericUtility.IConstantPath;
import org.sdet40.genericUtility.JavaUtility;
import org.sdet40.genericUtility.WebDriverUtility;

public class Testcase2 {
	public static void main(String[] args) throws InterruptedException, IOException {
		String sheetName = "CommonData";
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		ExcelUtility excelUtility = new ExcelUtility();
		JavaUtility javaUtility = new JavaUtility();
		
		excelUtility.initializeTheFile(IConstantPath.EXCELFILE_PATH);
		
		String userurl = excelUtility.getDataFromExcel(sheetName, 1, 1); 
		String browser = excelUtility.getDataFromExcel(sheetName, 2, 1);
		String username = excelUtility.getDataFromExcel(sheetName, 3, 1); 	
		String password = excelUtility.getDataFromExcel(sheetName, 4, 1);
		String adminurl = excelUtility.getDataFromExcel(sheetName, 5, 1);		
		String adminusername = excelUtility.getDataFromExcel(sheetName, 6, 1);
		String adminpassword = excelUtility.getDataFromExcel(sheetName, 7, 1);
		String dishName = excelUtility.getDataFromExcel(sheetName, 8, 1);
		String restaurant = excelUtility.getDataFromExcel(sheetName, 9, 1);
		String timeouts = excelUtility.getDataFromExcel(sheetName, 11, 1);
		long Timeouts = (long) javaUtility.convertStringToAnyDatatype(timeouts, DataType.LONG);
		String setOrderStatus = excelUtility.getDataFromExcel(sheetName, 12, 2);
		String expOrderStatus = excelUtility.getDataFromExcel(sheetName, 13, 2);
		WebDriver driver = webDriverUtility.openBrowserWithApplication(browser, Timeouts, userurl);

		driver = webDriverUtility.Login(driver, username, password);
		driver.findElement(By.linkText("Restaurants")).click();
		driver.findElement(By.xpath("//a[text()='"+restaurant+"']")).click();
		driver.findElement(By.xpath("//a[text()='"+dishName+"']/ancestor::div[@class='food-item']//input[@type='submit']")).click();	// xpath as per dishname
		driver.findElement(By.xpath("//a[text()='Checkout']")).click();
		driver.findElement(By.xpath("//span[text()='Cash on Delivery']")).click();
		driver.findElement(By.name("submit")).click();
		webDriverUtility.acceptAlert(driver);
		webDriverUtility.acceptAlert(driver);
		System.out.println("Order placed successfully");
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		driver = webDriverUtility.navigateTheApplication(driver, adminurl);
		webDriverUtility.implictlyWait(driver, Timeouts);
		driver = webDriverUtility.Login(driver, adminusername, adminpassword);
		driver.findElement(By.linkText("Orders")).click();
		driver.findElement(By.xpath("//tbody//tr[last()]//td//i[@class='fa fa-edit']")).click();
		driver.findElement(By.linkText("Update Order Status")).click();
		webDriverUtility.windowHandling(driver);
		webDriverUtility.switchTochildwindow(driver);
		driver = webDriverUtility.Login(driver, username, password);
		webDriverUtility.switchToparentwindow(driver);
		driver.findElement(By.linkText("Update Order Status")).click();
		webDriverUtility.windowHandling(driver);
		webDriverUtility.switchTochildwindow(driver);
		Select select = new Select(driver.findElement(By.name("status")));
		select.selectByVisibleText(setOrderStatus);
		driver.findElement(By.xpath("//textarea[@name='remark']")).sendKeys("Order is On the way");
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		webDriverUtility.acceptAlert(driver);
		driver.findElement(By.xpath("//tbody//tr[last()]//td[last()]//input[@class='btn btn-danger']")).click();
		webDriverUtility.switchToparentwindow(driver);
		driver.findElement(By.linkText("Orders")).click();
		Thread.sleep(1000);
		String status = driver.findElement(By.xpath("//tbody//tr[last()]//button[@type='button']")).getText();
		System.out.println("Selected restaurant is :"+restaurant);
		System.out.println("Ordered dish is :"+dishName);
		if(status.equals(expOrderStatus))
			System.out.println("Order status successfully changed to :"+status+". Test case is passed");
		else
			System.out.println("Test case is Failed: Actual status is: "+status);
		driver.findElement(By.xpath("//img[@class='profile-pic']")).click();
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();	
		
		excelUtility.closeTheWorkbook();

		webDriverUtility.closeTheBrowser(driver);
	}
}
