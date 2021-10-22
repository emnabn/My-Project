package com.tests.orangeProject.admin.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.tests.utils.CommonMethods;

public class Admin {

	/*Locators*/
	final static String ADMIN_ID="menu_admin_viewAdminModule";
	final static String USERMANAGMENT_ID="menu_admin_UserManagement";
	final static String FIELDSEARCH_ID="searchSystemUser_userName";
	final static String SEARCHBTN_ID="searchBtn";
	final static String WELCOME_ID= "welcome";
	final static String LOGOUT_XPATH="//*[@id=\"welcome-menu\"]/ul/li[3]/a";
	final static String VERIFY_ADMIN_XPATH= "//*[contains(text(),'Admin')]";
	
	/*@FindBy*/
	@FindBy(how=How.ID,using=ADMIN_ID)
	public static WebElement adminMenu;
	@FindBy(how=How.ID,using=USERMANAGMENT_ID)
	public static WebElement usermanagement;
	@FindBy (how=How.ID,using=FIELDSEARCH_ID)
	public static WebElement fieldSearch;
	@FindBy(how=How.ID,using=SEARCHBTN_ID)
	public static WebElement searchButton;
	@FindBy(how=How.ID,using=WELCOME_ID)
	public static WebElement welcome;
	@FindBy(how=How.XPATH,using=LOGOUT_XPATH)
	public static WebElement logout;
	@FindBy(how=How.XPATH,using=VERIFY_ADMIN_XPATH)
	public static WebElement verify_Admin;
	
	/*Methods*/
	
	
	public void ClickAdminMenu() {
		adminMenu.click();
	}
	
	public void FillField(String name) {
		fieldSearch.sendKeys(name);
	}
	
	public void clickButton() {
		searchButton.click();
	}
	
	public void clickWelcome() {
		welcome.click();
	}
	
	public void clickLogout() {
		logout.click();
	}
	
}
