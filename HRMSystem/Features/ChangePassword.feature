Feature: ChangePassword 

Background: Login steps for All scenarios 
	Given User Launch Chrome Browser 
	When User opens URL "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login" 
	And User enters UserName as "Admin" and Password as "Hum@nhrm123" 
	And Click on Login 
	
	Scenario: Change Password 
	When Click on Users Link 
	And Enter Username
	And Click on Search Button
	Then Click on search result
	And Click on Edit Button
	And Check on Change Password
	And Enter Password and Confirm Password
	And Save Button
	And Click on Welcome 
	When User click on Log out link 
	Then Logout Title should be "LOGIN Panel" 
	And close browser 