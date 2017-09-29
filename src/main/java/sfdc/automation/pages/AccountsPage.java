package sfdc.automation.pages;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sfdc.automation.utils.SeleniumUtil;

public class AccountsPage {

	SeleniumUtil seleniumUtil = SeleniumUtil.getSeleniumUtil();
	// Home Chatter Leads Contacts accounts etc are coming up as tablist
	
	String xPath_NewButton = ".//input[@title='New']";
	String xPath_Password = ".//input[contains(@name,'pw')]";
	String xPath_LeadLastName = ".//input[@id='name_lastlea2']";
	String xPath_CompanyName = ".//input[@id='lea3']";
	String xPath_UserNavButton = ".//span[@id='userNavLabel']";
	String xPath_LeadSaveBtn = ".//input[@title='Save']";
	String xPath_AccountName = ".//input[@id='acc2']";
	
	

	public void clickOnAccountsTab() {
		seleniumUtil.clickElementByXpath(".//ul/li/a[contains(@title,'Contacts Tab')]");
		
	}

	public void clickOnNewButton() {
		seleniumUtil.clickElementByXpath("xPath_NewButton");
		
	}

	public void enterAccountName(String accountName) {
		seleniumUtil.clickElementByXpath("xPath_AccountName");
		
	}

	/*public void entersCompanyName() {
		seleniumUtil.clickElementByXpath("xPath_CompanyName");
		
	}*/

	public void clickOnSave() {
		seleniumUtil.clickElementByXpath("xPath_LeadSaveBtn");
		
	}

	public void validateContact(String accountName) {
		//.//div[text()='Kurmi']
		
	seleniumUtil.IsElementDisplayed(".//div[text()='"+accountName+"']");
	
	}

	public void enterAccountName1(String accountName) {
		seleniumUtil.clickElementByXpath(xPath_AccountName);
		
	}


	public void enterLeadName() {
		seleniumUtil.clickElementByXpath("xPath_LeadLastName");
		
	}



}
