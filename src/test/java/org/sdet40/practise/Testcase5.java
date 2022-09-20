//Login as User -> Place the order through restaurant module -> Logout
package org.sdet40.practise;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/index.php");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='nav-link active'])[3]")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("manojbh");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("maruthii");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("(//a [@class='nav-link active'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a [@class='btn btn-purple'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg active']")).click();	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(2000);
		Alert a = driver.switchTo().alert();	
		a.accept();	
		Thread.sleep(2000);
		Alert a1 = driver.switchTo().alert();	
		a1.accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='nav-link active'])[4]")).click();	
		Thread.sleep(2000);
	}
}