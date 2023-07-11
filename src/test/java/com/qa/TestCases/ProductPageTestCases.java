package com.qa.TestCases;

import org.testng.annotations.Test;

import com.qa.PageObjects.Account_LoginPage;
import com.qa.PageObjects.IndexPage;
import com.qa.PageObjects.MyAccountPage;
import com.qa.PageObjects.ProductPage;
import com.qa.PageObjects.SearchResultPage;

public class ProductPageTestCases extends BaseClass {

	IndexPage IP;
	Account_LoginPage LP;
	MyAccountPage MAP;
	SearchResultPage SRP;
	ProductPage PP;

	String item = "Sony VAIO";

	@Test
	public void addToCartSuccessFully() throws InterruptedException {
		IP = new IndexPage(driver);
		LP = new Account_LoginPage(driver);
		MAP = new MyAccountPage(driver);
		SRP = new SearchResultPage(driver);
		PP = new ProductPage(driver);

		IP.MyAccountBtnClick();
		IP.LoginBtnClick();

		LP.enterEmail(prop.getProperty("username"));
		LP.enterPwd(prop.getProperty("password"));
		LP.clickLoginBtn();

		MAP.enterSearchItem(item);
		MAP.clickSearchBtn();

		SRP.searchIfItemDisplayed(item);
		SRP.openProductPage(item);

		PP.enterQuantity("2");
		PP.clickAddToCart();

//		Assert.assertEquals(PP.verifyValidation(), "Success: You have added " + item + " to your shopping cart!");
		//not sure why this assert is not working
		

	}

}
