package org.doordash.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.genericUtility.WebDriverUtility;

public class MyOrdersPage {
	private WebDriver driver;
	
public MyOrdersPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//tbody//tr[last()]//td//a//i[@class='fa fa-trash-o']")
private WebElement lastOrderDelBtn;

@FindBy(xpath="//th[text()='Status']")
private WebElement myOrdersPageText;

public String getMyOrdersPageText() {
	return myOrdersPageText.getText();
}

@FindBy(xpath = "//td[@data-column='Item']")
private List<WebElement> orderList;

public String getLastOrder() {
	int size = orderList.size();
	String text = orderList.get(size-1).getText();
	return text;
	
//	if(text.equalsIgnoreCase(dishName)) {
//		System.out.println("Expected Order: "+dishName);
//		System.out.println("Actual Order: "+text);
//		System.out.println("Testcase passed");
//	}
}

public void deleteLastOrder(WebDriverUtility webDriverUtility) {
	lastOrderDelBtn.click();
	webDriverUtility.acceptAlert(driver);
	System.out.println("Order deleted successfully..");
}
}
