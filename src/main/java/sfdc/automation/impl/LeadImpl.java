package sfdc.automation.impl;

import sfdc.automation.pages.LeadPage;
import sfdc.automation.pages.LogInPage;

public class LeadImpl implements Lead  {

	LeadPage leadPage = new LeadPage();

	@Override
	public void clickOnLeadsTab() {
		leadPage.clickOnLeadsTab();
		
	}

	@Override
	public void clickOnNewButton() {
		leadPage.clickOnNewButton();
		
	}

	@Override
	public void enterLeadName(String lastName) {
		leadPage.enterLeadName(lastName);
		
	}

	@Override
	public void entersCompanyName() {
		leadPage.entersCompanyName();
		
	}

	@Override
	public void clickOnSave() {
		leadPage.clickOnSave();
		
	}
	
	
	

}
