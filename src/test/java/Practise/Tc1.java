package Practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tc1 {
public Tc1(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
	@FindBy(id="username")
	private WebElement uname;
	@FindBy(name="pwd")
	private WebElement pass;
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement loginbutton;
	
	public WebElement getUname() {
		return uname;
	}
	public WebElement getPass() {
		return pass;
	}
	public WebElement getLoginbutton() {
		return loginbutton;
	}
}
