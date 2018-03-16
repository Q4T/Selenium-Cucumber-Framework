package com.automationpractice.WEB_Tests.stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.automationpractice.WEB_Tests.pages.PageBase;
import com.automationpractice.WEB_Tests.utilities.Utilities;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	
	@Before
	public static void setUp() {
		Utilities.TestSetUp();
	}
	
	@After
	public static void tearDown(Scenario scenario) {
	    if (scenario.isFailed()) {
	    	 WebDriver driver = PageBase.driver;
		      // Take a screenshot...
		      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		      scenario.embed(screenshot, "image/png");
	    }
	    Utilities.testTearDown();
	}
	
	
	
	
	
}
