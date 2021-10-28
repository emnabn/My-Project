package com.tests.orangeProject.admin.stepDefinition;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tests.orangeProject.admin.pageObjects.Admin;
import com.tests.utils.CommonMethods;
import com.tests.utils.Setup;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class AdminStepDef {
	
    WebDriver driver;
    
    private Admin admin = new Admin();
    private CommonMethods commonMethods = new CommonMethods();
   
    
    public AdminStepDef() {
    	driver= Setup.driver;
    	PageFactory.initElements(driver, Admin.class);
    }
    
    @When("^Je clique sur le menu Admin$")
    public void jeCliqueSurLeMenuAdmin() throws Throwable {
    	commonMethods.mouseHoover(admin.adminMenu);
    }

    @When("^Je clique sur le menu User Management$")
    public void jeCliqueSurLeMenuUserManagement() throws Throwable {
    	admin.ClickAdminMenu();
    }

    @When("^Je saisie Username \"([^\"]*)\"$")
    public void jeSaisieUsername(String arg1) throws Throwable {
        admin.FillField(arg1);
    }

    @When("^Je clique sur le bouton search$")
    public void jeCliqueSurLeBoutonSearch() throws Throwable {
       admin.clickButton();
    }

    @Then("^Je trouve un seul employé \"([^\"]*)\"$")
    public void jeTrouveUnSeulEmployé(String message) throws Throwable {
        String resultMessage = Admin.verify_Admin.getText();
    	Assert.assertEquals(resultMessage,message);
    }

    @Then("^Je me déconnecte du compte$")
    public void jeMeDéconnecteDuCompte() throws Throwable {
       admin.clickWelcome();
       admin.clickLogoutBoutton(driver);
       admin.clickLogout();
    }
			
}
