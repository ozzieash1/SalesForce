@current 
Feature: Lead function
Scenario: Varify creating a new lead into the Sales Force
Given user opens a browser 
And User navigates to "https://login.salesforce.com/"
When user enters user name as "USER_ULFAT" and password as "PASSWORD_ULFAT" 
##parameters in double quote above 
And user click on LogIn
And user click on Leads tab
And user clicks on new button
And user enters "Ash" as last name
And user enters "Wells Fargo Bank" as company
And user clicks on Save button
#And user validates newly created lead "Ash"
Then user logs out of the current application 