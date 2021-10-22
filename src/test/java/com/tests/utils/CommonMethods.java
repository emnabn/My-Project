package com.tests.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {

	public static WebDriver driver;

	public static Properties prop;

	public CommonMethods() {
		driver = Setup.driver;
	}

	public WebDriver switchTabs(WebDriver driver1) {
		// Store and print the names of all the windows opened
		Set<String> handles = driver1.getWindowHandles();
		System.out.println(handles);

		// Pass a window handle to other window
		for (String handle1 : driver1.getWindowHandles()) {
			driver1.switchTo().window(handle1);
			System.out.println(handle1);
		}
		return driver1;
	}
	
	public void mouseHoover(WebElement mouseHover) {
		Actions actions = new Actions(driver);
		actions.moveToElement(mouseHover).perform();
	}
	
	

	public void openURLWithConfigFile(String url) throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/test/resources/configs/config.properties");
		prop.load(fis);
		driver.get(prop.getProperty(url));
	}
}
