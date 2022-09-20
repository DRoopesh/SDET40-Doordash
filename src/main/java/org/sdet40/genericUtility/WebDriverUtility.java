package org.sdet40.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.doordash.ObjectRepository.EdishNames;
import org.doordash.ObjectRepository.ErestaurantNames;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class contains all the WebDriver common actions
 * @author DASARI
 *
 */
public class WebDriverUtility {
	String parentWindow = null;
	String childWindow = null;
	Set<String> Handles = null;
	Iterator<String> it = null;
	JavascriptExecutor jsExecutor;
	WebDriver driver = null;

	/**
	 * This method is used to Launch the browser
	 * @param browser
	 * @return 
	 */
	public WebDriver launchTheBrowser(String browser){
		switch(browser){
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
		return driver;
	}
	/**
	 * This method is used to maximize the browser
	 * @return 
	 */
	public WebDriver maximizeTheBrowser(WebDriver driver) {
		driver.manage().window().maximize();
		return driver;
	}
	/**
	 * This method is used to navigate to the application by url
	 * @param driver
	 * @param url
	 * @return 
	 */
	public WebDriver navigateTheApplication(WebDriver driver,String url) {
		driver.get(url);
		return driver;
	}

	/**
	 * This method is used to make the controller wait implicitly till load
	 * @param Timeouts
	 * @return 
	 */
	public WebDriver implictlyWait(WebDriver driver,Long timeouts) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeouts));
		return driver;
	}
	/**
	 * This method is used to Launch/Maximize/Wait implicitly and navigate to the application
	 * @param browser
	 * @param Timeouts
	 * @param url
	 * @return 
	 */
	public WebDriver openBrowserWithApplication(String browser, Long timeouts, String url) {
		WebDriver driver = launchTheBrowser(browser);
		maximizeTheBrowser(driver);
		implictlyWait(driver,timeouts);
		navigateTheApplication(driver, url);
		return driver;
	}
	/**
	 * This method is used to close the browser
	 * @param driver
	 */
	public void closeTheBrowser(WebDriver driver) {
		driver.quit();
	}
	/**
	 * This method is used to accept the alert popup
	 * @param driver
	 * @return
	 */
	public WebDriver acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
		return driver;
	}
	/**
	 * This method is used to refresh the browser
	 * @param driver
	 * @return
	 */
	public WebDriver refreshTheBrowser(WebDriver driver) {
		driver.navigate().refresh();
		return driver;
	}
	/**
	 * This method is used to login
	 * @param driver
	 * @param username
	 * @param password
	 * @return
	 */
	public WebDriver Login(WebDriver driver, String username, String password) {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		return driver;
	}
	/**
	 * This method is used to handle window popups
	 * @param driver
	 * @return 
	 */
	public WebDriver windowHandling(WebDriver driver) {
		parentWindow = driver.getWindowHandle();
		Handles = driver.getWindowHandles();
		it = Handles.iterator();
		while(it.hasNext())
		{
			childWindow = it.next();
		} 
		return driver;
	}
	/**
	 * This method is used to get the parent window
	 * @return
	 */
	public WebDriver switchToparentwindow(WebDriver driver) {
		driver.switchTo().window(parentWindow);
		return driver;
	}
	/**
	 * This method is used to get child window
	 * @return
	 */
	public WebDriver switchTochildwindow(WebDriver driver) {
		driver.switchTo().window(childWindow);
		return driver;
	}
	/**
	 * This method is used to wait till the element is visible
	 * @param driver
	 * @param Timeouts
	 * @param we
	 */
	public void waittillElementisVisible(WebDriver driver, long Timeouts, WebElement we) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeouts));
		wait.until(ExpectedConditions.visibilityOf(we));
//		return driver;
	}
	public void jsInitilization(WebDriver driver)
	{
		jsExecutor = (JavascriptExecutor) driver;
	}
	public void openApplicationUsingJS(String url) {
		jsExecutor.executeScript("window.location=arguments[0]", url);
	}
	public void sendKeysUsingJS(WebElement element, String data) {
		jsExecutor.executeScript("arguments[0].value=arguments[1]", element, data);
	}
	public void clickUsingJS(WebElement element){
		jsExecutor.executeScript("arguments[0].click()", element);
	}
	public void scrollTillElementUsingJS(WebElement element){
		jsExecutor.executeScript("arguments[0].scrollIntoView()", element);
	}
	/*
	 * This method is used to convertDynamicXpathToElement for single WebElement 
	 */
	public WebElement convertDynamicXpathToElement(String dynamicXpath, String replaceData, WebDriver driver) {
		String requiredXpath = String.format(dynamicXpath, replaceData);
		WebElement element = driver.findElement(By.xpath(requiredXpath));
		return element;
	}
	/*
	 * This method is used to convertDynamicXpathToElement for list of WebElements
	 */
	public List<WebElement> convertDynamicXpathToElements(String dynamicXpath, String replaceData, WebDriver driver) {
		String requiredXpath = String.format(dynamicXpath, replaceData);
		List<WebElement> element = driver.findElements(By.xpath(requiredXpath));
		return element;		
	}
	
	public void selectFromDropDownByVisibleText(WebElement we, String visibleText) {
		Select select = new Select(we);
		select.selectByVisibleText(visibleText);
	}
	
	public void verifyPage(SoftAssert soft, String actualText, String expectedText) {
		soft.assertEquals(actualText, expectedText);
	}
	
	public void verifyResult(SoftAssert soft, String actual, String expected) {
		soft.assertEquals(actual, expected);
	}
	
	public void verifyAssert(SoftAssert soft) {
		soft.assertAll();
	}
	
	public void logoutAction(WebDriver driver) {
		driver.findElement(By.linkText("Logout")).click();
	}
	
	/**
	 * This method is used to capture screenshot 
	 * @param driver
	 * @param javaUtility
	 * @param className
	 * @return 
	 * @throws IOException
	 */
	public String screenShot(WebDriver driver, JavaUtility javaUtility, String className) throws IOException {
		String currentTime = javaUtility.currentTime();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/"+className+"_"+currentTime+".png");
		Files.copy(src, dst);
//		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
	
	public String screenShot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String tempPath = ts.getScreenshotAs(OutputType.BASE64);
		return tempPath;
				
	}
}

