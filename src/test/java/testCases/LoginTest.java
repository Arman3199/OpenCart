package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePg;
import pageObjects.LoginPg;
import pageObjects.MyAccountPg;

public class LoginTest extends BaseClass{
	
	@Test
	public void validateLogin() {
		logger.info("***Starting Login Test!***");
		logger.debug("capturing application debug logs..");
		
		try {
		//object creation of HomePg
		HomePg HP = new HomePg(driver);
		
		//actions to perform login- click on myAcct and Login
		HP.clickonMyAcct();
		HP.login();
		logger.info("***Clicked on accouunt Login link!***");
		
		//LoginPg
		LoginPg LP = new LoginPg(driver);
		logger.info("***Entering Login information!***");
		LP.setEmail(prp.getProperty("email"));
		LP.setPassword(prp.getProperty("password"));
		LP.clickLogin();
		logger.info("***Clicked on login button!***");
		
		
		//myAccountPg
		MyAccountPg myAcctPg = new MyAccountPg(driver);
		
		logger.info("***validating Login!***");
		 boolean displayStatus = myAcctPg.isMyAccountPgExists();
		 Assert.assertEquals(displayStatus, true, "Login Failed!");
		
		} catch(Exception e) {
			Assert.fail();
		}finally {
			logger.info("***Starting Login Test completed!***");
		}
	}
	
	
	
	
	
	
	
	
	

}
