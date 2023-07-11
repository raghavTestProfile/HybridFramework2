package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.PageObjects.Account_LoginPage;
import com.qa.PageObjects.CheckOutPage;
import com.qa.PageObjects.IndexPage;
import com.qa.PageObjects.MyAccountPage;
import com.qa.PageObjects.ProductPage;
import com.qa.PageObjects.SearchResultPage;
import com.qa.PageObjects.ShoppingCartPage;

public class CheckoutPageTestCases extends BaseClass {

	IndexPage IP;
	Account_LoginPage LP;
	MyAccountPage MAP;
	SearchResultPage SRP;
	ProductPage PP;
	ShoppingCartPage SCP;
	CheckOutPage COP;

	String item = "Sony VAIO";

	@Test
	public void CheckOutPageUpdate() throws InterruptedException {

		IP = new IndexPage(driver);
		LP = new Account_LoginPage(driver);
		MAP = new MyAccountPage(driver);
		SRP = new SearchResultPage(driver);
		PP = new ProductPage(driver);
		SCP = new ShoppingCartPage(driver);
		COP = new CheckOutPage(driver);

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

		SCP.gotoCart();

		Assert.assertTrue(SCP.verifyProductInCart(item));

		SCP.useCouponCode("testCode");
		SCP.applyShippingCosts("India", "Assam", "3123123");
		SCP.applyGift("gift");

		SCP.clickOnCheckOut();

		COP.BillingDetailsClickContinue();
		COP.DelieveryDetailsClickContinue();
		COP.DelieveryMethodSection("null");
		COP.PaymentMethodSection("null");

		Assert.assertTrue(COP.ConfirmOrderValidateProduct(item));
		COP.clickConfirmOrder();
		
		Assert.assertEquals(COP.confirmOrderPlacedMessage(), "Your order has been placed!");

	}

}
