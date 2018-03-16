package com.automationpractice.WEB_Tests.pages;

import com.automationpractice.WEB_Tests.utilities.Utilities;

public class LandingPage extends PageBase {
	
	private Utilities u;
	private Toolbar toolbar;
	
	public LandingPage() {	

		 if (u==null) {
			 u = new Utilities();
		 } 
	}
	
	//method to click sign in button
	public void clickSignIn() {
		toolbar = u.getToolbar(toolbar);
		toolbar.ClickSignIn();
	}
	
}