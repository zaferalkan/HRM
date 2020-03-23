$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./Features/AddEmployee.feature");
formatter.feature({
  "line": 1,
  "name": "AddEmployee",
  "description": "",
  "id": "addemployee",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Add Employee",
  "description": "",
  "id": "addemployee;add-employee",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "User Launch Chrome Browser",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User opens URL \"http://166.62.36.207/humanresources/symfony/web/index.php/auth/login\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "User enters UserName as \"Admin\" and Password as \"Hum@nhrm123\"",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Click on Login",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Click on Add Employee",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Enter employee details and click save",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Click on Welcome",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "User click on Log out link",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Logout Title should be \"LOGIN Panel\"",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "close browser",
  "keyword": "And "
});
formatter.match({
  "location": "steps.user_Launch_Chrome_Browser()"
});
formatter.result({
  "duration": 6075784000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login",
      "offset": 16
    }
  ],
  "location": "steps.user_opens_URL(String)"
});
formatter.result({
  "duration": 1733966700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Admin",
      "offset": 25
    },
    {
      "val": "Hum@nhrm123",
      "offset": 49
    }
  ],
  "location": "steps.user_enters_UserName_as_and_Password_as(String,String)"
});
formatter.result({
  "duration": 454111800,
  "status": "passed"
});
formatter.match({
  "location": "steps.click_on_Login()"
});
formatter.result({
  "duration": 5275401000,
  "status": "passed"
});
formatter.match({
  "location": "steps.click_on_Add_Employee()"
});
formatter.result({
  "duration": 1438686100,
  "status": "passed"
});
formatter.match({
  "location": "steps.enter_employee_details_and_click_save()"
});
formatter.result({
  "duration": 38155126200,
  "status": "passed"
});
formatter.match({
  "location": "steps.click_on_Welcome()"
});
formatter.result({
  "duration": 224597100,
  "status": "passed"
});
formatter.match({
  "location": "steps.user_click_on_Log_out_link()"
});
formatter.result({
  "duration": 756834000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "LOGIN Panel",
      "offset": 24
    }
  ],
  "location": "steps.logout_Title_should_be(String)"
});
formatter.result({
  "duration": 105000,
  "status": "passed"
});
formatter.match({
  "location": "steps.close_browser()"
});
formatter.result({
  "duration": 2212687100,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Search Customer By Name",
  "description": "",
  "id": "addemployee;search-customer-by-name",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 17,
  "name": "User Launch Chrome Browser",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "User opens URL \"http://166.62.36.207/humanresources/symfony/web/index.php/auth/login\"",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "User enters UserName as \"Admin\" and Password as \"Hum@nhrm123\"",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "Click on Login",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "Click on Employee List",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "Enter employee name and click search",
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "Click on Welcome search",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "User click on Log out link",
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "Logout Title should be \"LOGIN Panel\"",
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "close browser",
  "keyword": "And "
});
formatter.match({
  "location": "steps.user_Launch_Chrome_Browser()"
});
formatter.result({
  "duration": 4157532600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login",
      "offset": 16
    }
  ],
  "location": "steps.user_opens_URL(String)"
});
formatter.result({
  "duration": 1621039100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Admin",
      "offset": 25
    },
    {
      "val": "Hum@nhrm123",
      "offset": 49
    }
  ],
  "location": "steps.user_enters_UserName_as_and_Password_as(String,String)"
});
formatter.result({
  "duration": 431283000,
  "status": "passed"
});
formatter.match({
  "location": "steps.click_on_Login()"
});
formatter.result({
  "duration": 5445338500,
  "status": "passed"
});
formatter.match({
  "location": "steps.click_on_Employee_List()"
});
formatter.result({
  "duration": 1563387500,
  "status": "passed"
});
formatter.match({
  "location": "steps.enter_employee_name_and_click_search()"
});
formatter.result({
  "duration": 6768966800,
  "status": "passed"
});
formatter.match({
  "location": "steps.click_on_Welcome_search()"
});
formatter.result({
  "duration": 481603900,
  "status": "passed"
});
formatter.match({
  "location": "steps.user_click_on_Log_out_link()"
});
formatter.result({
  "duration": 1062715200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "LOGIN Panel",
      "offset": 24
    }
  ],
  "location": "steps.logout_Title_should_be(String)"
});
formatter.result({
  "duration": 119600,
  "status": "passed"
});
formatter.match({
  "location": "steps.close_browser()"
});
formatter.result({
  "duration": 2182302500,
  "status": "passed"
});
});