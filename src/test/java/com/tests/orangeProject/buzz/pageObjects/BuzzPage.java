package com.tests.orangeProject.buzz.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BuzzPage {
	
   /*Locators*/
	final static String BUZZ_ID="menu_buzz_viewBuzz";
	final static String UPLOAD_IMAGE_ID="images-tab-label";
	final static String FIELD_TEXT_ID="phototext";
	final static String UPLOAD_BUTTON_ID="image-upload-button";
	final static String POST_BUTTON_ID="imageUploadBtn";
	
   /*@FindBy*/
	@FindBy(how=How.ID,using=BUZZ_ID)
	public static WebElement buzz_Button;
	@FindBy(how=How.ID,using=UPLOAD_IMAGE_ID)
	public static WebElement upload_button1;
	@FindBy(how=How.ID,using=FIELD_TEXT_ID)
	public static WebElement text_Field;
	@FindBy(how=How.ID,using=UPLOAD_BUTTON_ID)
	public static WebElement upload_button2;
	@FindBy(how=How.ID,using=POST_BUTTON_ID)
	public static WebElement post_Button;
	
	
	/*Methods*/
	public void clickBuzz() {
		buzz_Button.click();
	}
	
	public void clickUpload1() {
		upload_button1.click();
	}
	
	public void fillField(String message) {
		text_Field.sendKeys(message);
	}
	
	public void uploadFileWithRobot(String imagePath) {
		upload_button2.click();
		StringSelection stringSelection = new StringSelection(imagePath);
		Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipBoard.setContents(stringSelection, null);
		
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(150);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void clickPost() {
		post_Button.click();
	}
	
}
