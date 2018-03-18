package com.automationpractice.WEB_Tests.pages;

public class LandingPage extends PageBase {
	
	private Toolbar toolbar;
	
	//method to click sign in button
	public void clickSignIn() {
		toolbar = u.getToolbar(toolbar);
		toolbar.ClickSignIn();
	}
	
}