package sfdc.automation.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sfdc.automation.impl.Accounts;
import sfdc.automation.impl.AccountsImpl;
import sfdc.automation.impl.ContactsImpl;
import sfdc.automation.impl.Lead;
import sfdc.automation.impl.LeadImpl;
import sfdc.automation.impl.LogInImpl;

public class AccountsSteps {

	Accounts accountsImpl = new AccountsImpl();

	@And("^user click on Accounts tab$")
	public void clickOnAccountsTab() throws Throwable {
	
		accountsImpl.clickOnAccountsTab();
	}

	
	@And("^user validates newly created account \"([^\"]*)\"$")
	public void validateContact(String accountName) throws Throwable {
	
		accountsImpl.validateContact(accountName);
	}
	@And("^user enters \"([^\"]*)\" as Account name$")
	public void enterAccountName(String accountName) throws Throwable {
	
		accountsImpl.enterAccountName(accountName);
	
	
	
	}

	

}

// @Autowired