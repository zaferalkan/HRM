Feature: Pay Grades 

Background: Login steps for All scenarios 
	Given User Launch Chrome Browser 
	When User opens URL "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login" 
	And User enters UserName as "Admin" and Password as "Hum@nhrm123" 
	And Click on Login 
	
Scenario: Pay Grades 
	When Click on Pay Grades 
	Then Click on Add Button to Enter Pay Grade 
	And Enter Pay Grade 
	Then Click Save Button 
	And Click on Add Button to Enter Assigned Currencies 
	Then Enter Currency 
	And Enter Min and Max Salary
	Then Click Add Button to Save Currency 
	Then Click on Welcome Menu 
	When  User click on Log out link 
	#Then  Logout Title should be "LOGIN Panel" 
	#And  close browser