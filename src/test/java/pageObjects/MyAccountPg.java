package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPg extends BasePg{

	public MyAccountPg(WebDriver driver) {
		super(driver);
		
	}
	
	//locators
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	
	//ActionMethods
	public boolean isMyAccountPgExists() {
		try {
		return msgHeading.isDisplayed();
		} catch (Exception e) {
			return(false);
		}
	}
	
	
	
	
	
	

}
