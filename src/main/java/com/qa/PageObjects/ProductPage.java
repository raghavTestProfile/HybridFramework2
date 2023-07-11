package com.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	WebDriver driver;

	public ProductPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "input-quantity")
	WebElement quantity;

	@FindBy(id = "button-cart")
	WebElement AddToCartButton;
	
	@FindBy(css=".alert-dismissible")
	WebElement validationVerify;

	public void enterQuantity(String no) {

		quantity.clear();
		quantity.sendKeys(no);
	}

	public void clickAddToCart() {

		AddToCartButton.click();

	}
	public String verifyValidation() {
		
		String text=validationVerify.getText().split("×")[0];
		
		return text;
	}

}
