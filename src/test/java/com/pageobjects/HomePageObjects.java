package com.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseClass;

public class HomePageObjects extends BaseClass {

	WebDriver driver;

	@FindBy(xpath = "//input[@id=\"fromCity\"]")
	private WebElement fromcity;

	@FindBy(xpath = "//input[@id=\"toCity\"]")
	private WebElement tocity;

	@FindBy(xpath = "//ul[@class=\"react-autosuggest__suggestions-list\"]")
	private List<WebElement> searchList;

	String fromCity;
	String toCity;

	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnFromCity() {
		click(fromcity);
	}

	public void enterfromCityName(String city) {
		this.fromCity = city;
		sendKeys(fromcity, city);
	}

	public void clickOnToCity() {
		click(tocity);
	}

	public void entertoCityName(String city) {
		this.toCity = city;
		sendKeys(tocity, city);
	}
	
	public void isCitySuggested()
	{
		for(WebElement cities:searchList)
		{
			String opt= cities.getText();
			if(opt.contains(fromCity))
			{
				System.out.println("City Found");
			}
		}
	}

}
