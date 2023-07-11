package com.qa.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

	WebDriver driver;

	public CheckOutPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "input-payment-firstname")
	WebElement fname;

	@FindBy(id = "input-payment-lastname")
	WebElement lname;

	@FindBy(id = "input-payment-address-1")
	WebElement address;

	@FindBy(id = "input-payment-city")
	WebElement city;

	@FindBy(id = "input-payment-postcode")
	WebElement pcode;

	@FindBy(id = "input-payment-country")
	WebElement countryDrpDown;

	@FindBy(id = "input-payment-zone")
	WebElement zoneDrpDown;

	@FindBy(id = "button-payment-address")
	WebElement continueBtn1;

	@FindBy(id = "button-shipping-address")
	WebElement continueBtn2;

	@FindBy(xpath = "(//textarea[@name='comment'])[1]")
	WebElement delieveryComments;

	@FindBy(id = "button-shipping-method")
	WebElement continueBtn3;

	@FindBy(xpath = "(//textarea[@name='comment'])[2]")
	WebElement paymentComments;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement privacyCheckBox;

	@FindBy(id = "button-payment-method")
	WebElement continueBtn4;

	@FindBy(xpath = "//tr//td[1]")
	List<WebElement> productNameList;
	
	@FindBy(id="button-confirm")
	WebElement confirmOrderBtn;
	
	@FindBy(xpath="//div[@id='content']//h1")
	WebElement orderPlacedMessage;

	public void BillingDetailsClickContinue() {

		continueBtn1.click();

	}

	public void DelieveryDetailsClickContinue() {

		continueBtn2.click();

	}

	public void DelieveryMethodSection(String comments) {

		delieveryComments.sendKeys(comments);
		continueBtn3.click();

	}

	public void PaymentMethodSection(String comments) throws InterruptedException {
		
		Thread.sleep(1000);

		paymentComments.sendKeys(comments);
		privacyCheckBox.click();
		continueBtn4.click();

	}

	public boolean ConfirmOrderValidateProduct(String item) throws InterruptedException {
		
		Thread.sleep(1000);

		boolean ele = productNameList.stream().anyMatch(product -> product.getText().equalsIgnoreCase(item));
		return ele;

	}
	
	public void clickConfirmOrder() {
		
		 confirmOrderBtn.click();
		
	}
	
	public String confirmOrderPlacedMessage() throws InterruptedException {
		Thread.sleep(1000);
		return orderPlacedMessage.getText();
	}

}
