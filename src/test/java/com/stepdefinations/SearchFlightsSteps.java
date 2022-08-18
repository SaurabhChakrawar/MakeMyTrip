package com.stepdefinations;

import com.pageobjects.HomePageObjects;
import com.utility.BaseClass;
import com.utility.PropertiesReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SearchFlightsSteps {

	BaseClass base;
	PropertiesReader read;
	HomePageObjects home;

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

	@Then("Click on from city field")
	public void click_on_from_city_field() {
		home=new HomePageObjects(base.getDriver());
		home.clickOnFromCity();
	}

	@Then("Search from City and select from options")
	public void search_city_and_select_from_options() throws InterruptedException {
		String city = read.getData("from");
		home.enterfromCityName(city);	
		Thread.sleep(2000);
		home.isCitySuggested();
	}
	
	@Then("Search to City and select from options")
	public void search_to_city_and_select_from_options() {
	  
	}

	@Then("Click on to city field")
	public void click_on_to_city_field() {
		home.clickOnToCity();
	}
	

	

}
