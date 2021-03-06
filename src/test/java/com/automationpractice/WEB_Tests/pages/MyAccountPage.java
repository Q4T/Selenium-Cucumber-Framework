package com.automationpractice.WEB_Tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends PageBase{

	private By SignOut = By.cssSelector(".logout");
	private By womenButton = By.cssSelector("a[class='sf-with-ul'][title='Women']");  //can't find how to do multiple attributes using @FindBy
	private By orderHistory = By.cssSelector("a[href='http://automationpractice.com/index.php?controller=history'][title='Orders']");
	
	
	//wait for page to load		
	public void WaitForMyAccountPageToLoad() {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(SignOut));
	}
	
	//click Women Button
	public  void ClickWomenButton() {
		driver.findElement(womenButton).click();
	}	
	
	
	public void ClickOrderHistoryBttn() {
		driver.findElement(orderHistory).click();
	}
	
	public boolean logoutPresent() {
		WaitForMyAccountPageToLoad();
		if(driver.findElement(SignOut).isDisplayed()) {
			return true;
		}
		return false;
	}
	
	
	public static void justaTest() {
		System.out.println("nothing");
	}
	
}