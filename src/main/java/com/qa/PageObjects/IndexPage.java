package com.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

	WebDriver driver;

	public IndexPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//*[text()='My Account'])[1]")
	WebElement MyAccountBtn;

	@FindBy(linkText = "Login")
	WebElement LoginBtn;
	

	@FindBy(linkText = "Register")
	WebElement RegisterBtn;

	public void MyAccountBtnClick() {

		MyAccountBtn.click();
	}

	public void LoginBtnClick() {

		LoginBtn.click();
	}
	
	public void RegisterBtnClick() {

		RegisterBtn.click();
	}

}
