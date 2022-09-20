//Akshatha: Login as user -> Select Dish from Homepage -> Place Order -> Logout

package org.sdet40.practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase4 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException  {
		FileInputStream fisExcel = new FileInputStream("./src/test/resources/TestData.xlsx");	
		Workbook wb = WorkbookFactory.create(fisExcel);	
		String browser = wb.getSheet("CommonData").getRow(2).getCell(1).getStringCellValue();
		WebDriver driver=null;	

		switch(browser)	
		{	
		case "chrome": 	
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
		case "firefox": 	
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie": 	
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default: 	
			System.out.println(browser);
			break;
		}	
		String url = wb.getSheet("CommonData").getRow(0).getCell(1).getStringCellValue();	
		String username = wb.getSheet("CommonData").getRow(3).getCell(1).getStringCellValue();	
		String password = wb.getSheet("CommonData").getRow(4).getCell(1).getStringCellValue();	

		driver.manage().window().maximize();	
		driver.get(url);	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		String productname = "Chicken Madeira";
		driver.findElement(By.xpath("//a[text()='"+productname+"']/ancestor::div[@class='content']//div/following-sibling::div/a[@class='btn theme-btn-dash pull-right']")).click();
		driver.findElement(By.xpath("//a[.='"+productname+"']/ancestor::div/following-sibling::div//span[@class='price pull-left']/following-sibling::input[@class='btn theme-btn']")).click();
		driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg active']")).click();
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Alert a = driver.switchTo().alert();
		a.accept();
		Alert a1 = driver.switchTo().alert();
		a1.accept();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();

		driver.quit();
	}
}