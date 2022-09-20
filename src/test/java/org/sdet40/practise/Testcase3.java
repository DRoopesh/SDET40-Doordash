//Vinod: Test Scenario : Login as user->Place the order -> Go to Orders -> Delete the order->Logout
package org.sdet40.practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase3 {

	public static void main(String[] args) throws IOException, InterruptedException {

		// Step1 --> Convert the Physical File into Java Readable Object
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonDataFile.properties");

		Properties property = new Properties();

		// Step3--> Load all the keys
		property.load(fis);

		// Step4--> Fetch the data

		String url = property.getProperty("userurl").trim();
		String username = property.getProperty("username").trim();
		String password = property.getProperty("password");
		String browser = property.getProperty("browser");
		WebDriver driver = null;
		switch(browser)
		{
		case "chrome": 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
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
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("buttn")).click();
		driver.findElement(By.linkText("Highlands Bar & Grill")).click();
		driver.findElement(By.xpath("(//input[@value='Add To Cart'])[3]")).click();

		driver.findElement(By.linkText("Checkout")).click();
		driver.findElement(By.xpath("//input[@value='Order Now']")).click();
		
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		
		driver.findElement(By.linkText("My Orders")).click();
		driver.navigate().refresh();
		driver.findElement(By.xpath("//tbody//tr[last()]//td//a//i[@class='fa fa-trash-o']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.findElement(By.linkText("Logout")).click();
	}

}