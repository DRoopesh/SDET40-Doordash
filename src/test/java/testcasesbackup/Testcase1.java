//Roopesh: Login as User -> Place the order through restaurant module -> Logout
package testcasesbackup;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sdet40.genericUtility.DataType;
import org.sdet40.genericUtility.FileUtility;
import org.sdet40.genericUtility.IConstantPath;
import org.sdet40.genericUtility.JavaUtility;
import org.sdet40.genericUtility.WebDriverUtility;

public class Testcase1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		FileUtility fileUtility = new FileUtility();
		JavaUtility javaUtility = new JavaUtility();

		fileUtility.initializeTheFile(IConstantPath.PROPERTYFILE_PATH);

		String browser = fileUtility.getDataFromPropertyFile("browser");
		String userurl = fileUtility.getDataFromPropertyFile("userurl");
		String username = fileUtility.getDataFromPropertyFile("username");
		String password = fileUtility.getDataFromPropertyFile("password");
		String restaurant = fileUtility.getDataFromPropertyFile("restaurant");
		String dishName = fileUtility.getDataFromPropertyFile("dishName").trim();
		String timeouts = fileUtility.getDataFromPropertyFile("Timeouts");
		long Timeouts = (long)javaUtility.convertStringToAnyDatatype(timeouts, DataType.LONG);
		WebDriver driver = webDriverUtility.openBrowserWithApplication(browser, Timeouts, userurl);

		driver = webDriverUtility.Login(driver, username, password);
		driver.findElement(By.xpath("//a[text()='Restaurants ']")).click();
		driver.findElement(By.xpath("//a[text()='"+restaurant+"']")).click(); // alternate : //a[text()='North Street Tavern']//following::div[3]//a[text()='View Menu']
		driver.findElement(By.xpath("//a[contains(text(),'"+dishName+"')]/ancestor::div[@class='food-item']//input[@type='submit']")).click();	// Change xpath as per dishname->Add To Cart
//driver.findElement(By.xpath("//a[@contains(text(),'"+dishName+"')]/ancestor::div[@class='food-item']//input[@type='submit']")).click();	// Change xpath as per dishname->Add To Cart
		driver.findElement(By.linkText("Checkout")).click();
		driver.findElement(By.xpath("//span[text()='Cash on Delivery']")).click();
		driver.findElement(By.name("submit")).click();
		webDriverUtility.acceptAlert(driver);
		webDriverUtility.acceptAlert(driver);
		System.out.println("Order placed successfully");
		List<WebElement> orderList = driver.findElements(By.xpath("//td[@data-column='Item']"));			
		int size = orderList.size();
		String text = orderList.get(size-1).getText();
		if(text.equalsIgnoreCase(dishName)) {
			System.out.println("Expected Order: "+dishName);
			System.out.println("Actual Order: "+text);
			System.out.println("Testcase passed");
		}
		driver.findElement(By.linkText("Logout")).click();
		webDriverUtility.closeTheBrowser(driver);
	}
}
