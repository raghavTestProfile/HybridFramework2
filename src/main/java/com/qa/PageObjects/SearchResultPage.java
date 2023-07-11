package com.qa.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	WebDriver driver;

	public SearchResultPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "h4")
	List<WebElement> searchedItems;

	@FindBy(css = ".product-thumb")
	List<WebElement> productThumbNails;

	@FindBy(id = "button-cart")
	WebElement verifyProductPageButton;

	public boolean searchIfItemDisplayed(String item) {

		boolean bool = searchedItems.stream().anyMatch(product -> product.getText().equalsIgnoreCase(item));
		return bool;

	}

	public boolean openProductPage(String item) throws InterruptedException {

		WebElement ele = productThumbNails.stream()
				.filter(product -> product.findElement(By.cssSelector("h4")).getText().equals(item)).findFirst()
				.orElse(null);
		ele.findElement(By.linkText(item)).click();

		return verifyProductPageButton.isDisplayed();

	}

}
