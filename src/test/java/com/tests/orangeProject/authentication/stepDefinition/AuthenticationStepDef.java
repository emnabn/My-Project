package com.tests.orangeProject.authentication.stepDefinition;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tests.orangeProject.authentication.pageObjects.AuthenticationPage;
import com.tests.utils.CommonMethods;
import com.tests.utils.Setup;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AuthenticationStepDef extends CommonMethods{
	
	public WebDriver driver;
	private AuthenticationPage authentificationPage = new AuthenticationPage();
	private CommonMethods commonMethods = new CommonMethods();
	
	public AuthenticationStepDef() {
		driver = Setup.driver;
		PageFactory.initElements(driver, AuthenticationPage.class);
	}
	
	@Given("^Je me connecte sur l'application OrangeHRM$")
	public void jeMeConnecteSurLApplicationOrangeHRM() throws Throwable {
		commonMethods.openURLWithConfigFile("url2");
	}

	@When("^Je saisie le nom d'utilisateur \"([^\"]*)\"$")
	public void jeSaisieLeNomDUtilisateur(String username) throws Throwable {
		authentificationPage.fillUsername(username);
	}

	@When("^Je saisie le mot de passe \"([^\"]*)\"$")
	public void jeSaisieLeMotDePasse(String pswd) throws Throwable {
		authentificationPage.fillPassword(pswd);
	}

	@When("^Je clique sur le bouton login$")
	public void jeCliqueSurLeBoutonLogin() throws Throwable {
		authentificationPage.clickLoginButton();
	}

	@Then("^Je me redirige vers la page Home \"([^\"]*)\"$")
	public void jeMeRedirigeVersLaPageHome(String message) throws Throwable {
		String messageToWelcome = AuthenticationPage.welcome.getText();
		Assert.assertTrue(messageToWelcome.contains(message));
	}

}

