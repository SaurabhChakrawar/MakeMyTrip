package com.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = "com.stepdefinations", features = "src/test/resources/FeatureFiles", plugin = {
		"pretty", "html:target/cucumber", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
	}, dryRun = false, tags = "@Search"
)

public class SearchFlightTest extends AbstractTestNGCucumberTests{

}
