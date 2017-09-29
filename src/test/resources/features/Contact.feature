@current 
Feature: Contact function
Scenario: Varify creating a new contact into the Sales Force
Given user opens a browser 
And User navigates to "https://login.salesforce.com/"
When user enters user name as "USER_ULFAT" and password as "PASSWORD_ULFAT" 
##parameters in double quote above 
And user click on LogIn
And user click on Contacts tab
And user clicks on new button
And user enters "Kurmi" as last name
And user clicks on Save button
And user validates newly created contact "Kurmi"
Then user logs out of the current application 