Feature: AddUser 

Background: Login steps for All scenarios 
	Given User Launch Chrome Browser 
	When User opens URL "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login" 
	And User enters UserName as "Admin" and Password as "Hum@nhrm123" 
	And Click on Login 
	
Scenario: Add User 
	When Click on Add Employee 
	Then Add Employee  firstname as "psaur" and lastname as "nouaw" and click save 
	When Click on Users 
	And Click Add button 
	And Enter Add User details employeename as "psaur nouaw" username as "psaumar" and password "Hum@nhrm123" and as ConfirmPassword "Hum@nhrm123" and save 
	And Check User list with username as "psaumar" 
	And Click on Welcome 
	When User click on Log out link 
	Then Logout Title should be "LOGIN Panel" 
	And close browser 