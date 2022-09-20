package org.doordash.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='username']")
	private WebElement usernameTextField;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//a[@href='all_orders.php']")
	private WebElement ordersButton;

	@FindBy(xpath="//img[@class='profile-pic']")
	private WebElement profileBtn;

	@FindBy(xpath="//a[@href='logout.php']")
	private WebElement logOutBtn;
	
	@FindBy(xpath="//h1[text()='Admin Panel ']")
	private WebElement adminLoginPageText;
	
	@FindBy(xpath="//h4[text()='Admin Dashboard']")
	private WebElement adminDashPageText;
	
	public String getAdminLoginPageText() {
		return adminLoginPageText.getText();
	}
	public String getAdminDashPageText() {
		return adminDashPageText.getText();
	}

	public void loginAction(String userName, String password) {
		usernameTextField.sendKeys(userName);
		passwordTextField.sendKeys(password);
		loginButton.click();		
	}

	public void clickOnOrdersBtn() {
		ordersButton.click();
	}

	public void adminLogOutAction() {
		profileBtn.click();
		logOutBtn.click();
	}
}