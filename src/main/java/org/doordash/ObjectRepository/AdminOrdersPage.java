package org.doordash.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.genericUtility.WebDriverUtility;


public class AdminOrdersPage {
//	private String customerNameXpath = "//td[text()='+%s']";  // %s --> customer/username
	private String deleteBtnXpath = "//td[contains(text(),'%s')]//following::td[7]//i[@class='fa fa-trash-o']"; // %s --> customer/username
	
	public AdminOrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//tbody//tr[last()]//td//i[@class='fa fa-edit']")
	private WebElement lastOrderStatusEditButton;

	@FindBy(xpath="//button[text()='Update Order Status']")
	private WebElement updateOrderButton;

	@FindBy(name="status")
	private WebElement orderStatusDropDown;

	@FindBy(xpath="//textarea[@name='remark']")
	private WebElement orderStatusTextArea;

	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement submitOrderStatusbtn;

	@FindBy(xpath="//tbody//tr[last()]//button[@type='button']")
	private WebElement latestOrderStatus;

	@FindBy(xpath="//tbody//tr[last()]//td[last()]//input[@class='btn btn-danger']")
	private WebElement closeOrdStsWindowBtn;
	
	@FindBy(xpath="//h4[text()='All Orders']")
	private WebElement adminOrdersPageText;
	
	@FindBy(xpath="//h4[text()='View Order']")
	private WebElement adminEditOrdersPageText;
	
	@FindBy(xpath="//td[contains(text(),'drv')]//following::td[7]//i[@class='fa fa-trash-o']")
	private WebElement drvDeleteBtn;
	
	public String getAdminEditOrdersPageText() {
		return adminEditOrdersPageText.getText();
	}

	public void clickOnEditLastOrderStatus() {
		lastOrderStatusEditButton.click();
	}

	public void clickOnUpdateOrderBtn() {
		updateOrderButton.click();
	}

	public void selectStatusFromDropDown(WebDriverUtility webDriverUtility, String visibleText) {
		webDriverUtility.selectFromDropDownByVisibleText(orderStatusDropDown, visibleText);
	}

	public void enterOrderStatusMessage(String updateMessage) {
		orderStatusTextArea.sendKeys(updateMessage);
	}

	public void submitOrderStatus() {
		submitOrderStatusbtn.click();
	}

	public void closeOrderStsWindow() {
		closeOrdStsWindowBtn.click();
	}

	public String getLatestOrderStatus() {
		return latestOrderStatus.getText();
	}
	
	public String getAdminOrdersPageText() {
		return adminOrdersPageText.getText();
	}
	
	public void deleteOrders(WebDriverUtility webDriverUtility, String customerName, WebDriver driver) {
		 List<WebElement> deleteBtns = webDriverUtility.convertDynamicXpathToElements(deleteBtnXpath, customerName, driver);
		 System.out.println(deleteBtns.size());
		int count = 0;
		 for(int i=0; i<=(deleteBtns.size()-1);i++) {
			 drvDeleteBtn.click();
			 webDriverUtility.acceptAlert(driver);
			 count++;
		}
		System.out.println(count);
	}

	public void verifyOrder(String actualStatus, String expOrderStatus) {
		if(actualStatus.equals(expOrderStatus))
			System.out.println("Order status changed to :"+actualStatus+". Test case is passed");
		else
			System.out.println("Test case is Failed: Actual status is: "+actualStatus);
	}
}

