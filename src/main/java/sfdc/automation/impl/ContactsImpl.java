package sfdc.automation.impl;

import sfdc.automation.pages.ContactsPage;
import sfdc.automation.pages.LeadPage;
import sfdc.automation.pages.LogInPage;

public class ContactsImpl implements Contacts  {

	ContactsPage contactsPage = new ContactsPage();

	@Override
	public void clickOnContactsTab() {
		contactsPage.clickOnContactsTab();
		
	}

	@Override
	public void clickOnNewButton() {
		contactsPage.clickOnNewButton();
		
	}

	@Override
	public void enterLeadName() {
		contactsPage.enterLeadName();
		
	}

	@Override
	public void entersCompanyName() {
		contactsPage.entersCompanyName();
		
	}

	@Override
	public void clickOnSave() {
		contactsPage.clickOnSave();
		
	}

	@Override
	public void validateContact(String contactName) {
		contactsPage.validateContact(contactName);
		
	}
	
	
	

}
