package com.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Account_LoginPage {

	WebDriver driver;

	public Account_LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "input-email")
	WebElement EmailTxtBox;

	@FindBy(id = "input-password")
	WebElement PwdTxtBox;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement LoginBtn;

	public void enterEmail(String email) {

		EmailTxtBox.sendKeys(email);
	}

	public void enterPwd(String pwd) {

		PwdTxtBox.sendKeys(pwd);
	}

	public void clickLoginBtn() {

		LoginBtn.click();
	}

}
