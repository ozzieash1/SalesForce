package sfdc.automation.utils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import junit.framework.Assert;

public class SeleniumUtil {

	/*
	 * We will create a null object of WebDriver Interface since WebDriver is an
	 * Interface And we can't instantiate an object of an Interface. So, we will
	 * instantiate it whenever required by implementation of WebDriver Interface
	 * that is ChromeDriver/whichever as we see on around line #47 webDriver =
	 * new ChromeDriver(); webDriver = new FirefoxDriver();
	 */

	public WebDriver webDriver = null;
	/*
	 * We don't need more than one object of WebDriver. Because, if we have more
	 * than one Driver They will keep opening new browser/windows. And
	 * SeleniumUtil Class is responsible for creating the object of WebDriver,
	 * so we do not need more than one object of SeleniumUtil at Application
	 * Level. To achieve this we will be using Singleton Java Pattern. In this
	 * pattern we will make SeleniumUtil Constructor as private so that no one
	 * can create its object and we will create a static method in SeleniumUtil
	 * to get the object of SeleniumUtil Class. And in this method, we will
	 * check whether we already have object of SeleniumUtil class or not. If it
	 * already exists, then we will return the object else if we are
	 * initializing it for the first time we will create a new object and return
	 * it. So,if anyone wants to create the object of the class SeleniumUtil,
	 * they can use the static method we created
	 * 
	 */
	private static SeleniumUtil seleniumUtil;

	public static SeleniumUtil getSeleniumUtil() {
		if (seleniumUtil == null) {
			seleniumUtil = new SeleniumUtil("chrome");
			// seleniumUtil = new SeleniumUtil("firefox");
			return seleniumUtil;
		} else {
			return seleniumUtil;
		}

	}

	private SeleniumUtil(String browser) {
		// This is to check whether wedDriver is initiated or Not.
		// So, it it is first time means WebDriver is null, then only, we will
		// go inside
		// and initialize the driver
		if (webDriver == null) {

			System.setProperty("webdriver.gecko.driver", "C:/WS/geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", "C:/WS/chromedriver.exe");
			if (browser.equalsIgnoreCase("firefox")) {
				webDriver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				webDriver = new ChromeDriver();

				webDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			} else if (browser.equalsIgnoreCase("IE")) {

			} else {
				webDriver = new FirefoxDriver();
			}

			// driver = new FirefoxDriver();
			webDriver.manage().window().maximize();

		}
	}

	public void navigateTo(String url) {
		webDriver.get(url);
	}

	public void logInSalesForce(String userName, String passWord) {

		webDriver.findElement(By.id("username")).sendKeys("ulfat.a.ashraf1@gmail.com");
		webDriver.findElement(By.id("password")).sendKeys("ws85926056");
		webDriver.findElement(By.name("Login")).click();

		System.out.println("Entering User salesForce LogIn" + userName + passWord);

	}
	// sending to github

	// Highlight the name of the method (sendKeysByXPath) then press Alt + Shift
	// + J ; this will add a Java doc comment

	/**
	 * This method will use two parameters xPath of a web element and the value
	 * entered by the user
	 * 
	 * @param xPath
	 * @param value
	 */
	public void sendKeysByXPath(String xPath, String value) {

		// Get web element of input field from given xpath
		// To enter a value in a input field on a web page, first by the use of
		// findelementmethod in WebDriver Class, we will get the element of the
		// the input field
		WebElement elementToEnterValue = webDriver.findElement(By.xpath(xPath));

		// Now we will enter a given value into the selected web element by
		// using sendKeys Method of WebElement Class
		elementToEnterValue.sendKeys(value);

		// WebElement is an Interface; sendKeys method returns Void, we don't
		// need to assign any object to it.

	}

	public void clickElementByXpath(String xPath) {
		WebElement elementToBeClicked = webDriver.findElement(By.xpath(xPath));
		elementToBeClicked.click();

	}

	/**
	 * This method will take Input Parameter as a tab name. And will create an
	 * xPath from the given input parameter And it will try to find the element
	 * for this xpath and will return true if the element does exist or will
	 * return false if tag is not on the screen
	 * 
	 * @param tabName
	 * @return
	 */
	public boolean isTabDisplayed(String tabName) {
		String tabXpath = ".//ul/li/a[contains(@title,'" + tabName + " Tab')]";

		WebElement tabElement = webDriver.findElement(By.xpath(tabXpath));

		if (tabElement == null) {
			return false;
		} else {
			return true;
		}

	}

	public void takeScreenShot() throws IOException {
		File file = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("c:\\screenshot.png"));
	}

	public void clickOnUserNavButton(String xPath_UserNavButton) {
		// TODO Auto-generated method stub

	}

	public void clickOnLogOutButton(String xPath_LogOutButton) {
		// TODO Auto-generated method stub

	}

	public void IsElementDisplayed(String xPath) {
		WebElement tabElement = webDriver.findElement(By.xpath(xPath));

		if (tabElement == null) {
			Assert.fail("unable to find element");
		}

	}

	// How do i verify Alert present in the UI
	public void isAlertPresent(String alert) {
		webDriver.switchTo().alert();
	}

	public boolean isAlertPresent2(String alert) {
		try {
			webDriver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void isAlertAccepted(String alertacceptance) {
		webDriver.switchTo().alert().accept();

	}

	public void isAlertDismissed(String alertDismissed) {
		webDriver.switchTo().alert().dismiss();

	}

	// How do i get the text of the alert
	public void getAlertTest(String alertText) {
		Alert text = webDriver.switchTo().alert();
		System.out.println(text.getText());
	}

	// To switch/select to iFrame- three ways frames can be selected 1. based on
	// index (int), 2.object (String) and 3.Web Element.
	public void switcgToFrame(String frame) {
		webDriver.switchTo().frame(0); // zeroth index
		webDriver.switchTo().frame("frame");// based on name/object
		webDriver.switchTo().frame(webDriver.findElement(By.xpath("")));// based
																		// on
																		// Web
																		// Element

	}

	// Window handles in selenium-three methods available
	public void handlewindow() {
		String parentWindow = webDriver.getWindowHandle();// window where i am
															// performing the
															// action
		Set<String> allWindows = webDriver.getWindowHandles();// will give me
																// all the
																// windows in
																// the UI. it
																// returns a set
																// of strings
																// and not list
																// which allows
																// duplicates.
																// Set does not
																// allow dups
		Iterator<String> allWindow = allWindows.iterator();
		String ParentWindow = allWindow.next();
		webDriver.switchTo().window(parentWindow);
		String childWindow = allWindow.next();
		webDriver.switchTo().window(childWindow);
		// how do i get back to parent/default window/page-simply switch to
		// default content
		webDriver.switchTo().defaultContent();

		System.out.println("...............................");
	}

	// what are the various Wait conditions in selenium - implicit wait apply to
	// the entire page DOM and explicit wait
	public void waitConditionInSelenium() {
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("")));

		System.out.println("...............................");
	}

	// how do I handle mouse over
	public void handleMouseOver() {

		Actions act = new Actions(webDriver);
		act.moveToElement(webDriver.findElement(By.xpath(""))).build().perform();
		System.out.println("...............................");
	}

	// how to handle drop down items

	public void handleDropDownItems() {
		Select sel = new Select(webDriver.findElement(By.xpath("")));
		sel.selectByIndex(8);
		sel.selectByValue("");
		sel.selectByVisibleText("Test");
		// how do i get all data from the drop down
		sel.getOptions();
		List<WebElement> op = sel.getOptions();
		System.out.println("...............................");
	}

	// how do i handle drag & drop?

	public void handledragDrop() {
		Actions act = new Actions(webDriver);
		act.dragAndDrop(webDriver.findElement(By.xpath("")), webDriver.findElement(By.xpath("")));
		System.out.println("...............................");
	}

	// how do i get screenshot in selenium
	// directly, I can't get screenshot off selenium webdriver
	// i need to cast my webDriver with Takescreenshot class
	public void getScreenshot() throws Exception {
		File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
		org.apache.commons.io.FileUtils.copyFile(scrFile, new File("c:\\test\\Screenshots\\login  " + ".png"));
		System.out.println("...............................");
	}

	// How do i get coordinators of window like x & y
	public void handleWindowCordinates() {
		webDriver.manage().window().getPosition().getX();
		webDriver.manage().window().getPosition().getY();
		Point point = webDriver.manage().window().getPosition();
		point.getX();
		point.getY();
		System.out.println("...............................");
	}

	// How do i navigate back ward & forward

	public void navigateBackwarsForward() {
		webDriver.navigate().forward();
		webDriver.navigate().back();
	}

	// how do u get the url and title and count similar objectsof the page
	public void getCurrentURL() {
		webDriver.getCurrentUrl();
		String curUrl = webDriver.getCurrentUrl();
		webDriver.getTitle();
		// int size = webDriver.findElement(By.xpath("")).getSize();

		webDriver.findElement(By.xpath("@id[@name'Test']/following-sibling::td[2]"));
		webDriver.findElement(By.xpath("@id[@name'Test']/Preceding-sibling::td[2]"));
		webDriver.findElement(By.xpath("@id[@name'Test']/child::td[2]"));
		// How do i Get fifth element in the UI
		webDriver.findElements(By.xpath("")).get(5);
		// following methods are used to handle checkbox
		webDriver.findElement(By.xpath("")).isDisplayed();
		webDriver.findElement(By.xpath("")).isSelected();
		webDriver.findElement(By.xpath("")).isEnabled();
//how to execute javaScript in selenium
		
		JavaScriptExecutor JavaScriptExecutor= ((JavaScriptExecutor)webDriver);
	
		//JavaScriptExecutor.executeScript("return window.length");
	
	webDriver.manage().window().maximize();
	// Double slash is relative path, single slash is absolute path
	
	
	//how do i get attribute value
	
	webDriver.findElement(By.xpath("")).getAttribute("name");
	
	webDriver.findElement(By.xpath(" ")).sendKeys(Keys.ENTER);
	
	
	
	}






}// End of class SeleniumUtil
