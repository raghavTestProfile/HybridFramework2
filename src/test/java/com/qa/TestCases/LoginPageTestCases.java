package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.PageObjects.Account_LoginPage;
import com.qa.PageObjects.IndexPage;
import com.qa.PageObjects.MyAccountPage;

public class LoginPageTestCases extends BaseClass {

	IndexPage IP;
	Account_LoginPage LP;
	MyAccountPage MAP;

	@Test
	public void LoginwithValidCredentials() {

		IP = new IndexPage(driver);
		LP = new Account_LoginPage(driver);
		MAP = new MyAccountPage(driver);

		IP.MyAccountBtnClick();
		IP.LoginBtnClick();

		LP.enterEmail(prop.getProperty("username"));
		LP.enterPwd(prop.getProperty("password"));
		LP.clickLoginBtn();

		Assert.assertTrue(MAP.VerifyAccountTxt().equalsIgnoreCase("Edit your account information"));
		logger.info("TC_LF_001 Passed");

	}

}
