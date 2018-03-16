package com.automationpractice.WEB_Tests.pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindAll;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends PageBase{

	private LoginPage login;
	private By SignOut = By.cssSelector(".logout");
	private By womenButton = By.cssSelector("a[class='sf-with-ul'][title='Women']");  //can't find how to do multiple attributes using @FindBy
	private By orderHistory = By.cssSelector("a[href='http://automationpractice.com/index.php?controller=history'][title='Orders']");
	
	public MyAccountPage() {

	}
	
	//wait for page to load		
	public void WaitForMyAccountPageToLoad() {
			WebElement wait = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(SignOut));		
	}
	
	//click Women Button
	public void ClickWomenButton() {
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
	
}