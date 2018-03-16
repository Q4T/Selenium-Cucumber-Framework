package com.automationpractice.WEB_Tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaymentMethodPage extends PageBase {
	
	public  PaymentMethodPage() {
		
	}

	private By payByBankWire = By.cssSelector("a[class='bankwire']");
	
	public void clickPaymentMethodPage() {
		WebElement pay = driver.findElement(payByBankWire);
		pay.click();
	}		
}