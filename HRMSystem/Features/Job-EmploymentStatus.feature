Feature: Employment Status 

Background: Login steps for All scenarios 
	Given User Launch Chrome Browser 
	When User opens URL "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login" 
	And User enters UserName as "Admin" and Password as "Hum@nhrm123" 
	And Click on Login 
	
Scenario: Employment Status 

	When Click on Employment Status 
	Then Click on Add Button 
	And Enter Employment Status Name 
	Then Click on Save Button to Save Employment Status 
	And Click on Welcome Menu 
	And User click on Log out link 
	
	
	
	