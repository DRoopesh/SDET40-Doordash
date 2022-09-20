//Test Scenario : Login as user -> Select Dish from Homepage and Place the order -> Go to Orders -> Delete the order -> Logout
package testcasesbackup;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sdet40.genericUtility.DataType;
import org.sdet40.genericUtility.FileUtility;
import org.sdet40.genericUtility.IConstantPath;
import org.sdet40.genericUtility.JavaUtility;
import org.sdet40.genericUtility.WebDriverUtility;

public class Testcase4 {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = null;

		WebDriverUtility webDriverUtility = new WebDriverUtility();
		FileUtility fileUtility = new FileUtility();
		JavaUtility javaUtility = new JavaUtility();
		
		fileUtility.initializeTheFile(IConstantPath.PROPERTYFILE_PATH);

		String userurl = fileUtility.getDataFromPropertyFile("userurl");
		String username = fileUtility.getDataFromPropertyFile("username");
		String password = fileUtility.getDataFromPropertyFile("password");
		String browser = fileUtility.getDataFromPropertyFile("browser");
		String homeDishName = fileUtility.getDataFromPropertyFile("homeDishName");
		String timeouts = fileUtility.getDataFromPropertyFile("Timeouts");
		long Timeouts = (long) javaUtility.convertStringToAnyDatatype(timeouts, DataType.LONG);
		
		driver = webDriverUtility.openBrowserWithApplication(browser, Timeouts, userurl);
		driver = webDriverUtility.Login(driver, username, password);
		driver.findElement(By.xpath("//a[text()='"+homeDishName+"']")).click();
		driver.findElement(By.xpath("//a[text()='"+homeDishName+"']/ancestor::div[@class='food-item']//input[@value='Add To Cart']")).click();    // Add to cart xpath as per dishname
		driver.findElement(By.xpath("//a[text()='Checkout']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Cash on Delivery']")).click();
		driver.findElement(By.xpath("//input[@value='Order Now']")).click();
		webDriverUtility.acceptAlert(driver);
		webDriverUtility.acceptAlert(driver);
		System.out.println("Order placed successfully :"+homeDishName);
		driver.findElement(By.xpath("//tbody//tr[last()]//td//a//i[@class='fa fa-trash-o']")).click();
		webDriverUtility.acceptAlert(driver);
		System.out.println("Order deleted successfully..");
		driver.findElement(By.linkText("Logout")).click();
		webDriverUtility.closeTheBrowser(driver);
	}
}