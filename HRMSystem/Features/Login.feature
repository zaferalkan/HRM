Feature: Login 
@sanity 
Scenario: Successful login 
	Given User Launch Chrome Browser 
	When User opens URL "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login" 
	And User enters UserName as "Admin" and Password as "Hum@nhrm123" 
	And Click on Login 
	Then Click on Welcome Menu 
	When User click on Log out link 
	Then Logout Title should be "LOGIN Panel" 
	And close browser 
	
 
Scenario Outline: Data Driven login 
	Given User Launch Chrome Browser 
	When User opens URL "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login" 
	And User enters UserName as "<username>" and Password as "<password>" 
	And Click on Login 
	Then Click on Welcome Menu 
	When User click on Log out link 
	Then Logout Title should be "LOGIN Panel" 
	And close browser 
	
	Examples: 
		|username|password|
		|Admin|Hum@nhrm123|
		|Admin|Hum@nhrm1231|
	