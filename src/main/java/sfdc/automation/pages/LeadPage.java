package sfdc.automation.pages;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sfdc.automation.utils.SeleniumUtil;

public class LeadPage {

	SeleniumUtil seleniumUtil = SeleniumUtil.getSeleniumUtil();
	// Home Chatter Leads Contacts accounts etc are coming up as tablist
	
	String xPath_NewButton = ".//input[@title='New']";
	String xPath_Password = ".//input[contains(@name,'pw')]";
	String xPath_LeadLastName = ".//input[@id='name_lastcon2']";
	String xPath_CompanyName = ".//input[@id='lea3']";
	String xPath_UserNavButton = ".//span[@id='userNavLabel']";
	String xPath_LeadSaveBtn = ".//input[@title='Save']";
	
	
	

	public void clickOnLeadsTab() {
		seleniumUtil.clickElementByXpath(".//ul/li/a[contains(@title,'Leads Tab')]");
		
	}

	public void clickOnNewButton() {
		seleniumUtil.clickElementByXpath(xPath_NewButton);
		
	}

	public void enterLeadName(String lastName) {
		seleniumUtil.sendKeysByXPath(xPath_LeadLastName, lastName);
		
	}

	public void entersCompanyName() {
		seleniumUtil.clickElementByXpath(xPath_CompanyName);
		
	}

	public void clickOnSave() {
		seleniumUtil.clickElementByXpath(xPath_LeadSaveBtn);
		
	}






}
