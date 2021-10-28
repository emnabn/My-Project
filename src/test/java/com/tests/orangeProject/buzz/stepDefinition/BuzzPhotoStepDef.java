package com.tests.orangeProject.buzz.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.AbstractPage;
import com.tests.orangeProject.buzz.pageObjects.BuzzPage;
import com.tests.utils.CommonMethods;
import com.tests.utils.Setup;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BuzzPhotoStepDef {

	WebDriver driver;
	BuzzPage buzzPage = new BuzzPage();
	CommonMethods commonMethods = new CommonMethods();

	public BuzzPhotoStepDef() {
		driver = Setup.driver;
		PageFactory.initElements(driver, BuzzPage.class);
	}

	@When("^Je clique sur le menu Buzz$")
	public void jeCliqueSurLeMenuBuzz() throws Throwable {
		buzzPage.clickBuzz();
	}

	@When("^Je clique sur l'onglet upload images$")
	public void jeCliqueSurLOngletUploadImages() throws Throwable {
		buzzPage.clickUpload1();
	}

	@When("^Je saisie un message dans la case Photo-Text \"([^\"]*)\"$")
	public void jeSaisieUnMessageDansLaCasePhotoText(String message) throws Throwable {
		buzzPage.fillField(message);
	}

	@When("^Je telecharge l'image en cliquant sur le boutton Upload Images \"([^\"]*)\"$")
	public void jeTelechargeLImageEnCliquantSurLeBouttonUploadImages(String imagePath) throws Throwable {
		buzzPage.uploadFileWithRobot(imagePath);

	}

	@When("^Je clique sur le boutton Post$")
	public void jeCliqueSurLeBouttonPost() throws Throwable {
		buzzPage.clickPost();

	}

	@Then("^Je vérifie que l'image est importée et que le message a été soumis \"([^\"]*)\"$")
	public void jeVérifieQueLImageEstImportéeEtQueLeMessageAÉtéSoumis(String message) throws Throwable {
		String verifyMessage = BuzzPage.message_Text.getText();
		Assert.assertEquals(message, verifyMessage);
		System.out.println("Message OK");
		Boolean image_Exit = BuzzPage.image.isDisplayed();
		Assert.assertTrue(image_Exit);
		System.out.println("Image exit");
        //we have failed because the id of the message is changing in every time
	}

}
