package sfdc.automation.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sfdc.automation.impl.Lead;
import sfdc.automation.impl.LeadImpl;
import sfdc.automation.impl.LogInImpl;

public class LeadsSteps {

	Lead leadImpl = new LeadImpl();

	@And("^user click on Leads tab$")
	public void clickOnLeadsTab() throws Throwable {
	
		leadImpl.clickOnLeadsTab();
	}

	@And("^user clicks on new button$")
	public void clickOnNewButton() throws Throwable {
		
		leadImpl.clickOnNewButton();
	}

	@And("^user enters \"([^\"]*)\" as last name$")
	public void enterLeadName(String lastName) throws Throwable {
	
		leadImpl.enterLeadName(lastName);
	}

	@And("^user enters \"([^\"]*)\" as company$")
	public void entersCompanyName() throws Throwable {
		
		leadImpl.entersCompanyName();
	}


	@And("^user clicks on Save button$")
	public void clicksOnSave() throws Throwable {
		
		leadImpl.clickOnSave();
	}

	





}

// @Autowired