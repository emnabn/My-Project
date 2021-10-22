package com.tests.orangeProject.buzz.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tests.orangeProject.buzz.pageObjects.BuzzPage;
import com.tests.utils.CommonMethods;
import com.tests.utils.Setup;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BuzzStepDef {
  
	WebDriver driver;
    BuzzPage buzzPage = new BuzzPage();
    CommonMethods commonMethods = new CommonMethods();
    
    public BuzzStepDef(){
    	driver=Setup.driver;
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
    public void jeVérifieQueLImageEstImportéeEtQueLeMessageAÉtéSoumis(String arg1) throws Throwable {
       
    }


}
