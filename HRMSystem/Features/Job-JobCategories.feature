Feature: Job Categories

Background: Login steps for All scenarios 
	Given User Launch Chrome Browser 
	When User opens URL "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login" 
	And User enters UserName as "Admin" and Password as "Hum@nhrm123" 
	And Click on Login 
	
Scenario: Job Categories 
	When Click on Job Categories 
	Then Click on Add Button 
	And Enter A New Job Category 
	And Click on Save Button 
	Then Click on Welcome Menu 
	And User click on Log out link 
