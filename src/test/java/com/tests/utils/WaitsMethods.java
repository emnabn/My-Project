package com.tests.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsMethods {
	
	WebDriverWait waitExplicit;
	
		
	public void implicitWait(WebDriver driver_i, long second_i) {	
		driver_i.manage().timeouts().implicitlyWait(second_i, TimeUnit.MILLISECONDS);
	}
	
	public WebElement explicitWaitUntilVisibilityOfButton(WebDriver driver_e, By locator, long second_e) {
		WebElement button;
		waitExplicit = new WebDriverWait(driver_e, second_e);
		button = waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return button;
	}
	
	
	
    
	/* FlentWait
	 // Waiting 30 seconds for an element to be present on the page, checking
	   // for its presence once every 5 seconds.
	   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	       .withTimeout(30, SECONDS)
	       .pollingEvery(5, SECONDS)
	       .ignoring(NoSuchElementException.class);

	   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
	     public WebElement apply(WebDriver driver) {
	       return driver.findElement(By.id("foo"));
	     }
	   });
	   */
}
