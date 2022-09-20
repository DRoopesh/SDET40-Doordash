package org.doordash.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.genericUtility.DishNames;
import org.sdet40.genericUtility.RestaurantNames;
import org.sdet40.genericUtility.WebDriverUtility;

public class PickYourFavFoodPage {
	private WebDriver driver;
	private String dishNameLinkXpath = "//a[contains(text(),'%s')]/ancestor::div[@class='food-item']//input[@type='submit']";   // %s-->Dish Name
	
public PickYourFavFoodPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//h3[contains(text(),'Your Cart')]")
private WebElement dishSelectPageText;

public String getDishSelectPageText() {
	return dishSelectPageText.getText();
}

@FindBy(linkText = "Checkout")
private WebElement checkOutButton;

public void addDishToCart(String dishName, WebDriverUtility webDriverUtility) {
	webDriverUtility.convertDynamicXpathToElement(dishNameLinkXpath, dishName, driver).click();
}

public void ClickCheckOut() {
	checkOutButton.click();
}
}