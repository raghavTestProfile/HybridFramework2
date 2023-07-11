package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.PageObjects.Account_RegisterPage;
import com.qa.PageObjects.IndexPage;
import com.qa.PageObjects.MyAccountPage;

public class RegisterPageTestCases extends BaseClass {

	IndexPage IP;
	Account_RegisterPage RP;
	MyAccountPage MAP;

	@Test
	public void registerWithMandatoryFields() {

		IP = new IndexPage(driver);
		RP = new Account_RegisterPage(driver);
		MAP = new MyAccountPage(driver);

		IP.MyAccountBtnClick();
		IP.RegisterBtnClick();

		RP.enterFname("Fname");
		RP.enterlname("Lname");
		RP.enterEmail("abc@" + BaseClass.generateRandomAccount() + ".com");
		RP.enterTelephoneNo("999999999");
		RP.enterPassword("helloApplication");
		RP.selectPrivacy();
		RP.clickContinue();

		Assert.assertEquals(MAP.VerifyAccCreation(),
				"Congratulations! Your new account has been successfully created!");
		
		logger.info("TC_RF_001 Passed");

	}

}
