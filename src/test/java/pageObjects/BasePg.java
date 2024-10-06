package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

public class BasePg {
	
	WebDriver driver;
	public BasePg(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
