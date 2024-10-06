package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePg;
import pageObjects.RegistrationPg;

public class AcctRegistrationTest extends BaseClass {
	
	
		//validateRegistration()
	@Test
	public void validateAcctRegistration() {
		logger.info("**Starting Account Registration!**");
		logger.debug("## This is debug log message ###");
		try {
		//create object of homepg class and performing actions
		HomePg hp = new HomePg(driver);
		logger.info("Clicking on myAccount");
		hp.clickonMyAcct();
		hp.register();
		logger.info("Clicking Regster link");
		
		//create object of RegsitrationPage
		logger.info("Providing customer information");
		RegistrationPg repPg = new RegistrationPg(driver);
		repPg.setFirstName(randomString().toUpperCase());
		repPg.setLastName(randomString().toUpperCase());
		repPg.setEmail(randomAlphaNum() + "@gmail.com");
		repPg.setTelephone(randomNum());
	
		String pwd = randomAlphaNum();//save same password for both
		repPg.setPassword(pwd);
		repPg.setConfirmPass(pwd);
		
		repPg.clickPrivacyPolicy();
		repPg.clickContinue();
		
		logger.info("Validating expected message..");
		String confirmMsg =	repPg.getConfirmationMsg();	
		Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
		logger.info("Account registration test passed!");
	} catch(Exception e) {
		
	} finally {
		logger.info("***Finished Account Registration***");
	}
	
	}
	
	
	
	
}
