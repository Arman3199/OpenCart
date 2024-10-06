package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPg extends BasePg{
	
	public RegistrationPg(WebDriver driver) {
		super(driver);
		
	}

	//locators
	@FindBy(xpath = "//input[@name='firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@name='telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@name='confirm']")
	WebElement txtconfirmPass;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chckBoxPrivacy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	//action methods
	public void setFirstName(String FName) {
		txtFirstName.sendKeys(FName);
		
	}

	public void setLastName(String LName) {
		txtLastName.sendKeys(LName);
		
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
		
	}
	
	public void setTelephone(String telephone) {
		txtTelephone.sendKeys(telephone);
		
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
		
	}
	
	public void setConfirmPass(String password) {
		txtconfirmPass.sendKeys(password);
		
	}
	
	public void clickPrivacyPolicy() {
		chckBoxPrivacy.click();
		
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	
	//checking for confirmation page
	public String getConfirmationMsg() {
		try {
		return	msgConfirmation.getText();
		} catch(Exception e) {
			return e.getMessage();
		}
		
	}
	
	
	
	
	
}
