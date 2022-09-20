package org.doordash.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.genericUtility.WebDriverUtility;

public class OrderAndPayPage {
public OrderAndPayPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//span[text()='Cash on Delivery']")
private WebElement cashOnDeliveryCheckBox;

@FindBy(name = "submit")
private WebElement orderNowButton;

@FindBy(xpath="//h4[contains(text(),'Cart Summary')]")
private WebElement payAndOrderPageText;

public String getPayAndOrderPageText() {
	return payAndOrderPageText.getText();
}

public void ClickCashOnDelivery(WebDriver driver, WebDriverUtility webDriverUtility, long Timeouts) {
	webDriverUtility.waittillElementisVisible(driver, Timeouts, cashOnDeliveryCheckBox);
	cashOnDeliveryCheckBox.click();
}

public void ClickOrderNowButton() {
	orderNowButton.click();
}
}