package org.doordash.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.genericUtility.WebDriverUtility;

public class HomePage {
	private WebDriver driver;
	private String homeDishDynamicXpath = "//a[text()='%s']/ancestor::div[@class='content']//div/following-sibling::div/a[@class='btn theme-btn-dash pull-right']"; 	//%s-->Home dish Name
	private String homeDishAddToCartDynamicXpath = "//a[text()='%s']/ancestor::div/following-sibling::div//span[@class='price pull-left']/following-sibling::input[@class='btn theme-btn']"; 	//%s-->Home dish Name
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[text()='Order Delivery & Take-Out ']")
	private WebElement homePageText;

	public String getHomePageText() {
		return homePageText.getText();
	}
	
	public void clickOnHomeDish(String dishName, WebDriverUtility webDriverUtility) {
		webDriverUtility.convertDynamicXpathToElement(homeDishDynamicXpath, dishName, driver).click();
	}
	public void clickOnAddToCart(String dishName, WebDriverUtility webDriverUtility) {
		webDriverUtility.convertDynamicXpathToElement(homeDishAddToCartDynamicXpath, dishName, driver).click();
	}
}
