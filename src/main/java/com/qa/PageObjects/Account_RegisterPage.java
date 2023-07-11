package com.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Account_RegisterPage {

	WebDriver driver;

	public Account_RegisterPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "input-firstname")
	WebElement fnameTxtBox;

	@FindBy(id = "input-lastname")
	WebElement lnameTxtBox;

	@FindBy(id = "input-email")
	WebElement emailTxtBox;

	@FindBy(id = "input-telephone")
	WebElement telephoneTxtBox;

	@FindBy(id = "input-password")
	WebElement passwordTxtBox;

	@FindBy(id = "input-confirm")
	WebElement ConfirmPasswordTxtBox;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement privacyPolicyCheckBox;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueBtn;

	public void enterFname(String fname) {

		fnameTxtBox.sendKeys(fname);
	}

	public void enterlname(String lname) {

		lnameTxtBox.sendKeys(lname);
	}

	public void enterEmail(String email) {

		emailTxtBox.sendKeys(email);
	}

	public void enterPassword(String pwd) {

		passwordTxtBox.sendKeys(pwd);
		ConfirmPasswordTxtBox.sendKeys(pwd);
	}

	public void selectPrivacy() {

		privacyPolicyCheckBox.click();
	}

	public void clickContinue() {

		continueBtn.click();
	}
	
	public void enterTelephoneNo(String number) {
		
		telephoneTxtBox.sendKeys(number);
	}

}
