Feature: Organization 

Background: Login steps for All scenarios 
	Given User Launch Chrome Browser 
	When User opens URL "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login" 
	And User enters UserName as "Admin" and Password as "Hum@nhrm123" 
	And Click on Login 
	
	Scenario: Add location
	When Click on Locations Link
	And Add Locations
	And Check Location List
	When Click on Welcome 
	And User click on Log out link 
	Then Logout Title should be "LOGIN Panel" 
	And close browser 
	
	
	
	