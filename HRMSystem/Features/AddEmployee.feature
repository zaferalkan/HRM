Feature: AddEmployee 
	
	Scenario: Add Employee 
	Given User Launch Chrome Browser 
	When User opens URL "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login"
	And User enters UserName as "Admin" and Password as "Hum@nhrm123"
	And Click on Login 
	When Click on Add Employee
	Then Enter employee details and click save
	And Click on Welcome 
	When User click on Log out link
	Then Logout Title should be "LOGIN Panel"
	And close browser
	
		
	Scenario: Search Customer By Name
	Given User Launch Chrome Browser 
	When User opens URL "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login"
	And User enters UserName as "Admin" and Password as "Hum@nhrm123"
	And Click on Login 	
	When Click on Employee List
	Then Enter employee name and click search	
	And Click on Welcome search  
	When User click on Log out link
	Then Logout Title should be "LOGIN Panel"
	And close browser