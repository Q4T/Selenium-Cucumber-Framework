package com.automationpractice.WEB_Tests.testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features= "features",
		glue="com.automationpractice.WEB_Tests",
		tags= {"@Login"},
plugin = {"html:target/cucumber_html_report",
		  "json:target/cucumber.json" ,
          "junit:target/cucumber.xml",
          "com.cucumber.listener.ExtentCucumberFormatter:target/Extent_Report.html"},
		   monochrome = true)

public class Login {

	public void SmokeTests() {
		
	}	
}