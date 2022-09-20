package org.sdet40.practise;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetCalenderDate {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	String reqDate = "11";  //DD
	String reqMonth = "June"; //MMMM-->December   MMM-->Dec   MM-->12
	String reqYear = "2016";  //YYYY
	
	int reqMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(reqMonth).get(ChronoField.MONTH_OF_YEAR);
	
	int reqYearInNum = Integer.parseInt(reqYear);
	
	driver.get("https://testleaf.herokuapp.com/pages/Calendar.html");
	driver.findElement(By.xpath("//input[@id='datepicker']")).click();
	String actMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
	String[] str = actMonthYear.split(" ");
	String actMonth = str[0];
	String actYear = str[1];
	
	int actMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actMonth).get(ChronoField.MONTH_OF_YEAR);
	
	int actYearInNum = Integer.parseInt(actYear);
	
	while((reqMonthInNum>actMonthInNum) || (reqYearInNum>actYearInNum))
	{
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		actMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		str = actMonthYear.split(" ");
		actMonth = str[0];
		actYear = str[1];
		actMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actMonth).get(ChronoField.MONTH_OF_YEAR);
		actYearInNum = Integer.parseInt(actYear);
	}
	while((reqMonthInNum<actMonthInNum) || (reqYearInNum<actYearInNum))
	{
		driver.findElement(By.xpath("//span[text()='Prev']")).click();
		actMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		str = actMonthYear.split(" ");
		actMonth = str[0];
		actYear = str[1];
		actMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actMonth).get(ChronoField.MONTH_OF_YEAR);
		actYearInNum = Integer.parseInt(actYear);
	}
	driver.findElement(By.xpath("//a[text()='"+reqDate+"']")).click();
}
}
