package com.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	WebDriver driver;

	public MyAccountPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='search']")
	WebElement searchBox;

	@FindBy(linkText = "Edit your account information")
	WebElement EditAccTxt;

	@FindBy(xpath = "//*[text()='Congratulations! Your new account has been successfully created!']")
	WebElement AccountCreationSuccessMessage;

	@FindBy(css = ".btn-default")
	WebElement searchBtn;

	public String VerifyAccountTxt() {

		return EditAccTxt.getText();

	}

	public String VerifyAccCreation() {

		return AccountCreationSuccessMessage.getText();

	}

	public void enterSearchItem(String item) {

		searchBox.sendKeys(item);
	}

	public void clickSearchBtn() {

		searchBtn.click();
	}

}
