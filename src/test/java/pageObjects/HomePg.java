package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePg extends BasePg{
	
	//constructors
	public HomePg(WebDriver driver) {
		super(driver);
		
	}
	
	
	//locators
	@FindBy(xpath = "//a[@title='My Account']")
	WebElement link_myAcct;
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement link_register;
	
	@FindBy(xpath = "//a[text()='Login']")
	WebElement link_login;
	
	
	//action methods
	public void clickonMyAcct() {
		link_myAcct.click();
		
	}
	public void register() {
		link_register.click();
	}
	
	public void login() {
		link_login.click();
	}
		
	

}
