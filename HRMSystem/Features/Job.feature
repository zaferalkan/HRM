Feature: Job 

Background: Login steps for All scenarios 
	Given User Launch Chrome Browser 
	When User opens URL "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login" 
	And User enters UserName as "Admin" and Password as "Hum@nhrm123" 
	And Click on Login 
	
Scenario: Add A New Job 
	When Click on Job Titles 
	Then Click on Add Button 
	And Enter A New Job Title 
	And Enter Job Description 
	And Enter Benefits into Notes 
	And Click on Save Button 
	And Click on Welcome search 
	When User click on Log out link 
	Then Logout Title should be "LOGIN Panel" 
	And close browser