package com.automationpractice.WEB_Tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressesPage extends PageBase{

	private By proceedToCheckoutBttn = By.cssSelector("button[name='processAddress']");
	
	public AddressesPage() {

	}
	
	public void clickProceedToCheckoutBttn() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("javascript:window.scrollBy(0,450)");
		WebElement proceed = driver.findElement(proceedToCheckoutBttn);
		proceed.click();
	}	
}