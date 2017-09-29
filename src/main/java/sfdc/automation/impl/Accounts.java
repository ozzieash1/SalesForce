package sfdc.automation.impl;

public interface Accounts {

	void clickOnAccountsTab();

	void clickOnNewButton();

	void enterAccountName();

	//Svoid entersCompanyName();

	void clickOnSave();

	void validateAccount(String accountName);

	void validateContact(String accountName);

	void enterAccountsName();

	void enterAccountName(String accountName);
	
	//sending to github
}
