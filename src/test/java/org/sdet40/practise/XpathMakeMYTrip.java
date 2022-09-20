package org.sdet40.practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathMakeMYTrip {
public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
	FileInputStream fis = new FileInputStream("src/test/resources/Test.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String url = wb.getSheet("MMT").getRow(0).getCell(1).getStringCellValue();
	String browser = wb.getSheet("MMT").getRow(1).getCell(1).getStringCellValue();
	WebDriver driver = null;
	switch(browser)
	{
	case "chrome": 
		WebDriverManager.chromedriver().setup();
		driver  = new ChromeDriver();
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
		System.out.println("Please enter a valid browser");
		break;
	}
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	String FromCity = wb.getSheet("MMT").getRow(2).getCell(1).getStringCellValue();
	String ToCity = wb.getSheet("MMT").getRow(3).getCell(1).getStringCellValue();
	driver.findElement(By.xpath("//label[@for='fromCity']//span[text()='From']")).click();
	driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(FromCity);
	driver.findElement(By.xpath("//div[text()='"+FromCity+"']")).click();
	driver.findElement(By.xpath("//label[@for='toCity']//span[text()='To']")).click();
	driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(ToCity);
	driver.findElement(By.xpath("//div[text()='"+ToCity+"']")).click();
	driver.findElement(By.xpath("//a[text()='Search']")).click();
	
	Thread.sleep(3000);
	
	wb.close();
	driver.close();
}
}
