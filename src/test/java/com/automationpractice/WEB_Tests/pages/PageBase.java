package com.automationpractice.WEB_Tests.pages;


import org.openqa.selenium.WebDriver;
import com.automationpractice.WEB_Tests.utilities.DriverFactory;
import com.automationpractice.WEB_Tests.utilities.Utilities;


public class PageBase {

	public static WebDriver driver;
	public static Utilities u;
	
	public static void initialiseDriver() {
		driver = DriverFactory.getDriver();
		}	
	
	
	 public static void initialiseUtility() {
		 u = new Utilities();
	 }
	 
	
}