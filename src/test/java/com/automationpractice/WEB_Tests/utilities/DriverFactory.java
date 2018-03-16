package com.automationpractice.WEB_Tests.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.automationpractice.WEB_Tests.data.GlobalData;


public class DriverFactory {

	public static WebDriver getDriver() { 
			
		String browser = GlobalData.BROWSER;    
		String driverPath = GlobalData.DRIVERPATH;											
		WebDriver driver;  
		browser = browser.toUpperCase();
					
				if (browser.equals("CHROME")) {					
					System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
					driver = new ChromeDriver();
					
				}else if (browser.equals("FIREFOX")) {					
					System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");	
					driver = new FirefoxDriver();
						
				}else if (browser.equals("IE")) {
					System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
					driver = new InternetExplorerDriver();
				}else {
					//set default browser to chrome
					driver = new ChromeDriver();
				}
			return driver;
		}
}
