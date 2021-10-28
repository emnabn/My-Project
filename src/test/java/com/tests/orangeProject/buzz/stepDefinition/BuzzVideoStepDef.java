package com.tests.orangeProject.buzz.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.AbstractPage;
import com.tests.orangeProject.buzz.pageObjects.BuzzPage;
import com.tests.utils.CommonMethods;
import com.tests.utils.Setup;
import com.tests.utils.WaitsMethods;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class BuzzVideoStepDef {
	
	WebDriver driver;
	BuzzPage buzzPage = new BuzzPage();
	CommonMethods commonMethods = new CommonMethods();
	WaitsMethods waitsMethods = new WaitsMethods();
	
	public BuzzVideoStepDef() {
		driver = Setup.driver;
		PageFactory.initElements(driver, BuzzPage.class);
	}

	@When("^Je clique sur l'onglet share video$")
	public void jeCliqueSurLOngletShareVideo() throws Throwable {
		buzzPage.clickBuzz();
		buzzPage.clickShare();
	   
	}

	@When("^Je saisie l'url dans createVideo_content  \"([^\"]*)\"$")
	public void jeSaisieLUrlDansCreateVideo_content(String arg1) throws Throwable {
		buzzPage.fillFieldVideo(arg1,driver);
		
	   
	}

	@When("^Je clique sur le bouton save video$")
	public void jeCliqueSurLeBoutonSaveVideo() throws Throwable {
		waitsMethods.explicitWaitUntilVisibilityOfButton(driver,buzzPage.locator, 20);
		buzzPage.clickSave();
	  
	}

	@Then("^Je vérifie que le video a été partagé \"([^\"]*)\"$")
	public void jeVérifieQueLeVideoAÉtéPartagé(String arg1) throws Throwable {
	    String video_Message= buzzPage.message.getText();
		Assert.assertEquals(arg1, video_Message);
		System.out.println("Video is shared successfully");
	}


}
