package org.doordash.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.genericUtility.WebDriverUtility;

public class LoginPage {
public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

@FindBy(name = "username")
private WebElement userNameTextField;

@FindBy(name = "password")
private WebElement passwordTextField;

@FindBy(xpath = "//input[@value='Login']")
private WebElement loginButton;

@FindBy(xpath="//h2[text()='Login to your account']")
private WebElement loginPageText;

public void loginAction(String userName, String password) {
	userNameTextField.sendKeys(userName);
	passwordTextField.sendKeys(password);
	loginButton.click();
}

public String getLoginPageText() {
	return loginPageText.getText();
}
}

