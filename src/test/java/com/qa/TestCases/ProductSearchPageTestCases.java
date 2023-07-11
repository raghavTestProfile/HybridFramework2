package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.PageObjects.Account_LoginPage;
import com.qa.PageObjects.IndexPage;
import com.qa.PageObjects.MyAccountPage;
import com.qa.PageObjects.SearchResultPage;

public class ProductSearchPageTestCases extends BaseClass {

	IndexPage IP;
	Account_LoginPage LP;
	MyAccountPage MAP;
	SearchResultPage SRP;

	String item = "Sony VAIO";

	@Test
	public void searchOfExistingProduct() throws InterruptedException {

		IP = new IndexPage(driver);
		LP = new Account_LoginPage(driver);
		MAP = new MyAccountPage(driver);
		SRP = new SearchResultPage(driver);

		IP.MyAccountBtnClick();
		IP.LoginBtnClick();

		LP.enterEmail(prop.getProperty("username"));
		LP.enterPwd(prop.getProperty("password"));
		LP.clickLoginBtn();

		MAP.enterSearchItem(item);
		MAP.clickSearchBtn();

		Assert.assertTrue(SRP.searchIfItemDisplayed(item));

		Assert.assertTrue(SRP.openProductPage(item));
	}
}
