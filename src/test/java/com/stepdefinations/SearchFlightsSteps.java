package com.stepdefinations;

import com.utility.BaseClass;
import com.utility.PropertiesReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SearchFlightsSteps {

	BaseClass base;
	PropertiesReader read;

	public SearchFlightsSteps() {
		base = new BaseClass();
		read = new PropertiesReader("Search");
	}

	@Given("Launch the browser")
	public void launch_the_browser() {
		String browser = read.getData("browser");
		base.launch_browser(browser);
		base.max_browser();
		base.applyimplicitwait();
	}

	@Then("Navigate to the makemytrip application")
	public void navigate_to_the_makemytrip_application() {
		String url = read.getData("url");
		base.getUrl(url);
	}

}
