package com.utility;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseClass {

	private static WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void launch_browser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt = new ChromeOptions();
			opt.setHeadless(false);
			driver = new ChromeDriver(opt);
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions opt = new EdgeOptions();
			opt.setHeadless(false);
			driver = new EdgeDriver(opt);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions opt = new FirefoxOptions();
			opt.setHeadless(false);
			driver = new FirefoxDriver(opt);
		}
	}

	public void getUrl(String url) {
		driver.get(url);
	}

	public void applyimplicitwait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	public void removeimplicitwait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
	}

	public void max_browser() {
		driver.manage().window().maximize();
	}

	// generic-methods
	public void waitForVisibilityOfElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void click(WebElement element) {
		waitForVisibilityOfElement(element);
		element.click();
	}

	public void jsclick(WebElement element) {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", element);
	}

	public void sendKeys(WebElement element, Keys enter) {
		waitForVisibilityOfElement(element);
		element.sendKeys(enter);
	}

	public void sendKeys(WebElement element, String keyword) {
		waitForVisibilityOfElement(element);
		// element.clear();
		element.sendKeys(keyword);
	}

	public boolean isElementDisplayed(WebElement element) {
		waitForVisibilityOfElement(element);
		return element.isDisplayed();
	}

	public String texts(WebElement element) {
		// waitForVisibilityOfElement(element);
		return element.getText();
	}

	public List<String> WebelementToString(List<WebElement> elementList) {

		List<String> stringList = new ArrayList<String>();

		for (WebElement element : elementList) {

			stringList.add(element.getText().toString());
			// System.out.println(element.getText());
		}

		return stringList;
	}

	public void enterTab() {

		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
	}
	public boolean isElementHiddenNow(String id) {
		removeimplicitwait(); 
		boolean result = ExpectedConditions.invisibilityOfElementLocated(By.xpath(id)).apply(driver);
		applyimplicitwait();
		return result;
	}
	public void moveToElement(WebElement element) {

		try {

			Actions action = new Actions(driver);
			action.moveToElement(element).perform();

		} catch (Exception e) {

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			new Actions(driver).moveToElement(element).build().perform();

		}

	}
	public void scrollIntoView(WebElement element) {

		JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", element);

	}
	public void DoubleClick(WebElement element) {
		Actions act = new Actions(driver);

		// Double click on element
		act.doubleClick(element).perform();
	}
	public String randomStringGenerator() {
		
		 String random=	RandomStringUtils.randomAlphabetic(4);
		 return random;
		}
	
	public String isFieldDisabled(WebElement element,String value) {
		
		 String actual=	element.getAttribute(value);
		 
		 return actual;
			
		}


}