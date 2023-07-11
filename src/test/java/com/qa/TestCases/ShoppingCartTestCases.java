package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.PageObjects.Account_LoginPage;
import com.qa.PageObjects.IndexPage;
import com.qa.PageObjects.MyAccountPage;
import com.qa.PageObjects.ProductPage;
import com.qa.PageObjects.SearchResultPage;
import com.qa.PageObjects.ShoppingCartPage;

public class ShoppingCartTestCases extends BaseClass {
	
	IndexPage IP;
	Account_LoginPage LP;
	MyAccountPage MAP;
	SearchResultPage SRP;
	ProductPage PP;
	ShoppingCartPage SCP;

	String item = "Sony VAIO";
	
	@Test
	public void ShoppingCartUpdate() throws InterruptedException {
		
	
		IP = new IndexPage(driver);
		LP = new Account_LoginPage(driver);
		MAP = new MyAccountPage(driver);
		SRP = new SearchResultPage(driver);
		PP = new ProductPage(driver);
		SCP=new ShoppingCartPage(driver);

		IP.MyAccountBtnClick();
		IP.LoginBtnClick();

		LP.enterEmail("w@w2.com");
		LP.enterPwd("12123456");
		LP.clickLoginBtn();

		MAP.enterSearchItem(item);
		MAP.clickSearchBtn();

		SRP.searchIfItemDisplayed(item);
		SRP.openProductPage(item);

		PP.enterQuantity("2");
		PP.clickAddToCart();
		
		SCP.gotoCart();
		
		Assert.assertTrue(SCP.verifyProductInCart(item));
		
		
		Assert.assertTrue(SCP.useCouponCode("testCode"));
		Assert.assertTrue(SCP.applyShippingCosts("India","Assam", "3123123"));
		Assert.assertTrue(SCP.applyGift("gift"));
		
		SCP.clickOnCheckOut();
		Assert.assertEquals(SCP.VerifyCheckOutPage(), "Checkout");


	}
	
}
