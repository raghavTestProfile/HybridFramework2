package com.qa.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage {

	WebDriver driver;

	public ShoppingCartPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "a[title='Shopping Cart']")
	WebElement shoppingCartBtn;

	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr//td[2]")
	List<WebElement> cartProductList;

	@FindBy(xpath = "(//h4//a)[1]")
	WebElement CoupnDropDwn;

	@FindBy(xpath = "(//h4//a)[2]")
	WebElement ShippingDropDwn;

	@FindBy(xpath = "(//h4//a)[3]")
	WebElement GiftCertificateDropDwn;

	@FindBy(id = "input-coupon")
	WebElement couponTxtBox;

	@FindBy(id = "button-coupon")
	WebElement applyCoupnBtn;

	@FindBy(css = ".alert-dismissible")
	WebElement verifyValidations;

	@FindBy(id = "input-country")
	WebElement country;

	@FindBy(id = "input-zone")
	WebElement zone;

	@FindBy(id = "input-postcode")
	WebElement pcode;

	@FindBy(id = "button-quote")
	WebElement getQuoteBtn;

	@FindBy(xpath = "//input[@type='radio']")
	WebElement ShippingRadioBtn;

	@FindBy(id = "button-shipping")
	WebElement applyShippingBtn;

	@FindBy(id = "button-voucher")
	WebElement applyGiftBtn;

	@FindBy(id = "input-voucher")
	WebElement enterGift;

	@FindBy(xpath = "//div[@class='pull-right']")
	WebElement checkoutBtn;
	
	@FindBy(xpath="//div[@id='content']//h1")
	WebElement checkoutPageVerify;

	public void gotoCart() {

		shoppingCartBtn.click();
	}

	public Boolean verifyProductInCart(String items) {

		Boolean bool = cartProductList.stream().anyMatch(product -> product.getText().equalsIgnoreCase(items));
		return bool;
	}

	public boolean useCouponCode(String code) {

		CoupnDropDwn.click();
		couponTxtBox.sendKeys(code);
		applyCoupnBtn.click();
		
		return verifyValidations.isDisplayed();

	}

	public boolean applyShippingCosts(String desh, String region, String postCode) throws InterruptedException {
		
		Thread.sleep(1000);

		ShippingDropDwn.click();

		Select s1 = new Select(country);
		s1.selectByVisibleText(desh);

		Select s2 = new Select(zone);
		s2.selectByVisibleText(region);

		pcode.sendKeys(postCode);

		getQuoteBtn.click();
		ShippingRadioBtn.click();
		applyShippingBtn.click();

		return verifyValidations.isDisplayed();

	}

	public boolean applyGift(String code) {

		GiftCertificateDropDwn.click();

		enterGift.sendKeys(code);
		applyGiftBtn.click();

		return verifyValidations.isDisplayed();

	}

	public void clickOnCheckOut() {

		checkoutBtn.click();

	}
	
	public String VerifyCheckOutPage() {
		
		 return  checkoutPageVerify.getText();
		
	}

}
