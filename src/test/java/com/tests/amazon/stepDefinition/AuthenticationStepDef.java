package com.tests.amazon.stepDefinition;

import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tests.amazon.pageObjects.AuthenticationAmazon;
import com.tests.utils.CommonMethods;
import com.tests.utils.Setup;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AuthenticationStepDef extends CommonMethods{

	public WebDriver driver;
	private AuthenticationAmazon authenticationAmazon = new AuthenticationAmazon();
	private CommonMethods commonMethods = new CommonMethods();
	
	public AuthenticationStepDef() {
		driver=Setup.driver;
		PageFactory.initElements(driver, AuthenticationAmazon.class);
	}
	
	@Given("^I am a user on Amazon website$")
	public void iAUserOnAmazonWebsite() throws Throwable {
		commonMethods.openURLWithConfigFile("url1");
	}

	@When("^I click on Bonjour button$")
	public void iClickOnIdentifiezVousButton() throws Throwable {
		authenticationAmazon.ClickBonjourButton();
		driver=commonMethods.switchTabs(driver); 
	}

	@When("^I enter my email \"([^\"]*)\"$")
	public void iEnterMyEmail(String mail) throws Throwable {
		authenticationAmazon.FillEmail(mail);
		
	}

	@When("^I click on continue button$")
	public void iClickOnContinueButton() throws Throwable {
		authenticationAmazon.ClickContinueButton();
		driver=commonMethods.switchTabs(driver);
		
	}

	@When("^I enter my password \"([^\"]*)\"$")
	public void iEnterMyPassword(String psw) throws Throwable {
		authenticationAmazon.FillPaswword(psw);
	}

	@When("^I click on s'identifier button$")
	public void iClickOnSIdentifierButton() throws Throwable {
		authenticationAmazon.ClickIdentifierButton();
	}

	@Then("^Home page is displayed \"([^\"]*)\"$")
	public void homePageIsDisplayed(String message) throws Throwable {
		String welcomeMessage = AuthenticationAmazon.welcome.getText();
		System.out.println(welcomeMessage);
		Assert.assertTrue(welcomeMessage.contains(message));
	}
	


}
