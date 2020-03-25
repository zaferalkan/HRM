Feature: AddUser 

Background: Login steps for All scenarios 
	Given User Launch Chrome Browser 
	When User opens URL "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login" 
	And User enters UserName as "Admin" and Password as "Hum@nhrm123" 
	And Click on Login 
	
	Scenario: Add User 
	When Click on Add Employee 
	Then Enter employee details and click save 
	And Click on Users Link
	And Click Add button
	And Enter Add User details and save
	And Click on Welcome 
	When User click on Log out link 
	Then Logout Title should be "LOGIN Panel" 
	And close browser 