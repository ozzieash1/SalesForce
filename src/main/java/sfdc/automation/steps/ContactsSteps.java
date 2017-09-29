package sfdc.automation.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sfdc.automation.impl.Contacts;
import sfdc.automation.impl.ContactsImpl;
import sfdc.automation.impl.Lead;
import sfdc.automation.impl.LeadImpl;
import sfdc.automation.impl.LogInImpl;

public class ContactsSteps {

	Contacts contactsImpl = new ContactsImpl();

	@And("^user click on Contacts tab$")
	public void clickOnContactsTab() throws Throwable {
	
		contactsImpl.clickOnContactsTab();
	}

	
	@And("^user validates newly created contact \"([^\"]*)\"$")
	public void validateContact(String contactName) throws Throwable {
	
		contactsImpl.validateContact(contactName);
	}





}

// @Autowired