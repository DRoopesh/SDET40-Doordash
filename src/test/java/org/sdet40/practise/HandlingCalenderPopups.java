package org.sdet40.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCalenderPopups {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
	FileInputStream fis = new FileInputStream("./src/test/resources/Test.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("Calender");
	String url = sheet.getRow(0).getCell(1).getStringCellValue();
	String browser = sheet.getRow(1).getCell(1).getStringCellValue();
	WebDriver driver = null;

	switch(browser)
	{
	case "chrome": 
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver  = new ChromeDriver(options);
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
	
	driver.findElement(By.xpath("//input[@id='datepicker']")).click();
	String date = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
	System.out.println(date);
	Thread.sleep(9000);
	wb.close();
	
}
}