package com.automationpractice.WEB_Tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShippingPage extends PageBase {

	private By proceedToCheckoutBttn = By.cssSelector("button[name='processCarrier']");
	private By termsOfServiceCheckBox = By.cssSelector("input[id='cgv']");
	
	public  ShippingPage() {
	
	}
	
	public void clickProceedToCheckoutBttn() {
		
		WebElement proceed = driver.findElement(proceedToCheckoutBttn);
		proceed.click();
	}
		
		public void checkTermsOfService() {
			WebElement checkbox = driver.findElement(termsOfServiceCheckBox);
			 if(!checkbox.isSelected()) {
				 checkbox.click();
			 }			
		}				
}