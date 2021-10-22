package com.tests.amazon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuthenticationAmazon {

	/*Locators*/
	final static String BONJOUR_ID = "nav-link-accountList";
	final static String EMAIL_FIELD_ID = "ap_email";
	final static String CONTINUE_BUTTON_ID= "continue";
	final static String PW_FIELD_ID = "ap_password";
	final static String IDENTIFIER_BUTTON_ID = "signInSubmit";
	final static String MESSAGE_BONJOUR_BEN_ID = "nav-link-accountList-nav-line-1";
	
	
	/*@FindBy*/
	@FindBy(how=How.ID,using=BONJOUR_ID)
	public static WebElement connexion;
	@FindBy(how=How.ID,using=EMAIL_FIELD_ID)
	public static WebElement email;
	@FindBy(how=How.ID,using=CONTINUE_BUTTON_ID)
	public static WebElement continueButton;
	@FindBy(how=How.ID,using=PW_FIELD_ID)
	public static WebElement password;
	@FindBy(how=How.ID,using=IDENTIFIER_BUTTON_ID)
	public static WebElement identifierButton;
	@FindBy(how=How.ID,using=MESSAGE_BONJOUR_BEN_ID )
	public static WebElement welcome;
	
	
	
	/*Methods*/
	public void ClickBonjourButton() {
		connexion.click();
	}
	
	public void FillEmail(String mail) {
		email.sendKeys(mail);
	}
	
	public void ClickContinueButton() {
		continueButton.click();
	}
	
	public void FillPaswword(String psw) {
		password.sendKeys(psw);
	}
	public void ClickIdentifierButton() {
		identifierButton.click();
	}
}
