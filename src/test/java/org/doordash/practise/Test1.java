package org.doordash.practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys("drv");
		driver.findElement(By.name("password")).sendKeys("drv469");
		driver.findElement(By.id("buttn")).click();
		driver.findElement(By.linkText("Restaurants")).click();
		driver.findElement(By.linkText("View Menu")).click();
		driver.findElement(By.xpath("(//input[@class='btn theme-btn'])[1]")).click();		
		driver.findElement(By.linkText("Checkout")).click();
		driver.findElement(By.xpath("//span[text()='Cash on Delivery']")).click();
		driver.findElement(By.name("submit")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();	
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		driver.close();	
}
}
