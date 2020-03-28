Feature: EditJobTitle 

Background: Login steps for All scenarios 
	Given User Launch Chrome Browser 
	When User opens URL "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login" 
	And User enters UserName as "Admin" and Password as "Hum@nhrm123" 
	And Click on Login 
	
	Scenario: Search current job title and change
	When Click on Job Titles Link 
	Then Find Job Title as "Cotroller" in the table and Click
	And Click on Job Edit Button
	And Check on Job Description
	And Job Save Button
	When Click on Welcome 
	And User click on Log out link 
	Then Logout Title should be "LOGIN Panel" 
	And close browser 