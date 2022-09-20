package org.doordash.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.genericUtility.WebDriverUtility;

public class RestaurantPage {
	private WebDriver driver;
	private String restaurantMenuDynamicXpath = "//a[text()='%s']"; 	//%s-->Restaurant Name


public RestaurantPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//a[text()='Restaurants ']")
private WebElement restaurantTab;

@FindBy(xpath="//a[text()='View Menu']")
private WebElement resturantPageText;

public String getResturantPageText() {
	return resturantPageText.getText();
}

public void clickRestaurantTab() {
	restaurantTab.click();
}

public void clickOnRestaurantMenu(String restaurant, WebDriverUtility webDriverUtility) {
	webDriverUtility.convertDynamicXpathToElement(restaurantMenuDynamicXpath, restaurant, driver).click();
}
}
