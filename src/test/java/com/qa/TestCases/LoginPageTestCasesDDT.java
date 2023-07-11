package com.qa.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.PageObjects.Account_LoginPage;
import com.qa.PageObjects.IndexPage;
import com.qa.PageObjects.MyAccountPage;
import com.qa.Utilities.Utils;

public class LoginPageTestCasesDDT extends BaseClass {

	IndexPage IP;
	Account_LoginPage LP;
	MyAccountPage MAP;

	@Test(dataProvider = "LoginDataProvider")
	public void LoginwithValidCredentials(String userEmail, String userpwd) {

		IP = new IndexPage(driver);
		LP = new Account_LoginPage(driver);
		MAP = new MyAccountPage(driver);

		IP.MyAccountBtnClick();
		IP.LoginBtnClick();

		LP.enterEmail(userEmail);
		LP.enterPwd(userpwd);
		LP.clickLoginBtn();

		Assert.assertTrue(MAP.VerifyAccountTxt().equalsIgnoreCase("Edit your account information"));
		logger.info("TC_LF_001 Passed");

	}

	@DataProvider(name="LoginDataProvider")
	public String[][] LoginDataProvider() throws IOException {

		String filename = System.getProperty("user.dir") + "\\TestDataExcel\\TutorialNinjaTC's.xlsx";

		int ttrows = Utils.getRowCount(filename, "LoginPage");
		int ttcols = Utils.getColCount(filename, "LoginPage");

		String data[][] = new String[ttrows - 1][ttcols];

		for (int i = 1; i < ttrows; i++) {

			for (int j = 0; j < ttcols; j++) {

				data[i - 1][j] = Utils.getCellValue(filename, "LoginPage", i, j);
			}
		}

		return data;

	}

}
