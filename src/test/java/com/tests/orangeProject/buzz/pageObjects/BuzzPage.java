package com.tests.orangeProject.buzz.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BuzzPage {
	
	//private WaitMethods waitMethods = new WaitMethods();
	
   /*Locators*/
	final static String BUZZ_ID="menu_buzz_viewBuzz";
	final static String UPLOAD_IMAGE_ID="images-tab-label";
	final static String FIELD_TEXT_ID="phototext";
	final static String UPLOAD_BUTTON_ID="image-upload-button";
	final static String POST_BUTTON_ID="imageUploadBtn";
	final static String MESSAGE_TEST_ID="postContent_15";
	final static String IMAGE_ID="1_17";
	
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
	@FindBy(how=How.ID,using=MESSAGE_TEST_ID)
	public static WebElement message_Text;
	@FindBy(how=How.ID,using=IMAGE_ID)
	public static WebElement image;
	
	
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
	
	//For Video
	
	/*Locators*/
	final static String SHARE_BUTTON_ID= "video-tab-label";
	final static String FIELD_VIDEO_ID="createVideo_content";
	final static String SAVE_BUTTON="//input[@value='Save Video']";//"//*/div[@id='postBody']/p/input"
	final static String MESSAGE_LINKTEXT="https://youtu.be/LUri5A2CGQ0";
	
	/*FindBy*/
	
	@FindBy(how=How.ID,using=SHARE_BUTTON_ID)
	public static WebElement share_Button;
	@FindBy(how=How.ID,using=FIELD_VIDEO_ID)
	public static WebElement field_Video;
	@FindBy(how=How.XPATH,using=SAVE_BUTTON)
	public static WebElement save_Button;
	public static By locator= By.xpath(SAVE_BUTTON);
	@FindBy(how=How.LINK_TEXT,using=MESSAGE_LINKTEXT)
	public static WebElement message;
	
	/*Methods*/
	public static void clickShare() {
		share_Button.click();
	}
	
	public static void fillFieldVideo(String video,WebDriver driver1) {
		field_Video.sendKeys(video);
		Actions actions = new Actions(driver1);
		actions.keyDown(field_Video,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		actions.keyDown(Keys.CONTROL).sendKeys("x").keyUp(field_Video,Keys.CONTROL).perform();
		actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
	}
	
	public static void clickSave() {
		save_Button.click();
	}
}
