package com.automationpractice.WEB_Tests.pages;

import org.openqa.selenium.By;

public class Toolbar extends PageBase {
	private By signOut = By.cssSelector("a[class='logout']");
	private By SignIn = By.cssSelector("a[class='login']");
	
	public Toolbar() {
	
	}
	
	public void ClickSignIn() {
		driver.findElement(SignIn).click();
	}
	
	public void ClickSignOut() {
		driver.findElement(signOut).click();;
	}
}
