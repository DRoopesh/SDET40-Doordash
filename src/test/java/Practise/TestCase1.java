package Practise;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://demo.actitime.com/login.do");
	Tc1 tc = new Tc1(driver);
	tc.getUname().sendKeys("trainee");
	Thread.sleep(2000);
	tc.getPass().sendKeys("trainee");
	Thread.sleep(2000);
	tc.getLoginbutton().click();
	Thread.sleep(2000);	
}
}
