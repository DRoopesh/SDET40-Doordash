package org.sdet40.practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

public class XpathAjio {
public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
	FileInputStream fis = new FileInputStream("./src/test/resources/Test.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("AJIO");
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
	
	String productName = "Graphic Shorts & T-shirt Set";
	driver.findElement(By.xpath("//a[text()='KIDS']")).click();
	driver.findElement(By.xpath("//a[@href='/s/0-to-2-years-3767-54091']")).click();

	String productPrice = driver.findElement(By.xpath("//div[text()='"+productName+"']/following-sibling::div/span[@class='price  ']")).getText();
	System.out.println(productPrice);
	sheet.getRow(2).createCell(1).setCellValue(productName);
	sheet.getRow(3).createCell(1).setCellValue(productPrice);
	FileOutputStream fos = new FileOutputStream("./src/test/resources/Test.xlsx");
	wb.write(fos);
	driver.findElement(By.xpath("//div[text()='"+productName+"']")).click();
	wb.close();
}
}
