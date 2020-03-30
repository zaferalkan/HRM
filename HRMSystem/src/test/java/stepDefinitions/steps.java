package stepDefinitions;

import static org.junit.Assert.assertArrayEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.AddEmployeePage;
import pageObjects.LocationPage;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.SearchCustomer;
import pageObjects.UserPage;

public class steps extends BaseClass {

	@Before
	public void setup() throws IOException {

		// logger configuration
		logger = Logger.getLogger("HRM System");
		PropertyConfigurator.configure("log4j.properties");

		// reading properties file
		configProp = new Properties();
		FileInputStream configProfile = new FileInputStream("config.properties");
		configProp.load(configProfile);

		String br = configProp.getProperty("browser");

		if (br.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();

		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}

		logger.info("*****Launching the browser*****");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Given("^User Launch Chrome Browser$")
	public void user_Launch_Chrome_Browser() {

		lp = new LoginPage(driver);
	}

	@When("^User opens URL \"([^\"]*)\"$")
	public void user_opens_URL(String url) throws Throwable {
		driver.get(url);
	}

	@When("^User enters UserName as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_UserName_as_and_Password_as(String username, String password) throws Throwable {
		logger.info("*****entering credentials*****");

		lp.setUserName(username);
		lp.setPassword(password);
	}

	@When("^Click on Login$")
	public void click_on_Login() throws Throwable {
		logger.info("*****login process started*****");

		lp.clickLogin();
		Thread.sleep(3000);

	}

	@Then("^Page Title should be \"([^\"]*)\"$")
	public void page_Title_should_be(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("Home Page Title should be")
	public void home_Page_Title_should_be(String title) throws Throwable {
		logger.info("*****welcome menu title verified*****");

		mp = new MainPage(driver);
		mp.titleVerification();

	}

	@Then("^Click on Welcome Menu$")
	public void click_on_Welcome_Menu() throws InterruptedException {
		logger.info("*****clicked the welcome menu*****");

		mp = new MainPage(driver);
		mp.clickWelcomeMenu();

	}

	@When("^User click on Log out link$")
	public void user_click_on_Log_out_link() throws InterruptedException {
		logger.info("*****logout process started*****");

		mp = new MainPage(driver);
		sc = new SearchCustomer(driver);
		mp.clickLogot();

	}

	@Then("^Logout Title should be \"([^\"]*)\"$")
	public void logout_Title_should_be(String as) throws Throwable {

	}

	@Then("^close browser$")
	public void close_browser() throws InterruptedException {
		logger.info("*****driver closed*****");

		Thread.sleep(2000);
		driver.close();
	}

	@When("^Click on Add Employee$")
	public void click_on_Add_Employee() throws Throwable {
		logger.info("*****navigate to employee adding page*****");

		ae = new AddEmployeePage(driver);
		ae.clickAddEmp();
	}

	@Then("^Enter employee details and click save$")
	public void enter_employee_details_and_click_save() throws Throwable {
		logger.info("*****Employee added and saved to database with credentials*****");

		ae = new AddEmployeePage(driver);
		ae.firstName("pascal");
		ae.lastName("nouma");
		ae.employeeId("9999");
		ae.createLoginDetails();
		ae.userName("pascal");
		ae.password("Abc@2019asd");
		ae.confirmPass("Abc@2019asd");
		ae.statusSelection(1);
		ae.clickToSave();
		Thread.sleep(2000);
		ae.clickToEdit();
		Thread.sleep(2000);
		// ae.genderSelection("male");
		ae.genderselection2();
		ae.nationalitySelections();
		ae.maritalSelections();
		ae.clickLicenseDate();
		ae.dobEntry();
		ae.clickToSave1();
//		ae.clickAtt();
//		Thread.sleep(3000);
		// ae.choichefile();
	}

	@Then("^Click on Welcome$")
	public void click_on_Welcome() throws Throwable {
		logger.info("*****Go back to welcome menu*****");

		mp = new MainPage(driver);
		mp.clickWel();
	}

	@Then("^Click on Welcome search$")
	public void click_on_Welcome_search() throws Throwable {
		logger.info("*****welcome menu to searck employee*****");

		mp = new MainPage(driver);
		sc.clickMenu();
	}

	@When("^Click on Employee List$")
	public void click_on_Employee_List() throws Throwable {
		logger.info("*****go to employee list*****");

		sc = new SearchCustomer(driver);
		sc.clickEmpList();

	}

	@Then("^Enter employee name and click search$")
	public void enter_employee_name_and_click_search() throws Throwable {
		logger.info("*****enter employee name to search*****");

		String a = "pascal nouma";
		sc.enterEmpName(a);
		Thread.sleep(2500);
		sc.searchButtonClick();
		sc.searchcustomerbyid("9999");
		sc.searchResultControl(a);

	}

	@Then("^Add Employee  firstname as \"([^\"]*)\" and lastname as \"([^\"]*)\" and click save$")
	public void add_Employee_firstname_as_and_lastname_as_and_click_save(String firstname, String lastname)
			throws Throwable {
		Thread.sleep(2000);
		ae = new AddEmployeePage(driver);

		ae.addEmployee(firstname, lastname);
	}

	@When("^Click on Users$")
	public void click_on_Users() throws Throwable {
		Thread.sleep(2000);
		ae = new AddEmployeePage(driver);

		up = new UserPage(driver);
		up.clickUsersLink();

	}

	@When("^Click Add button$")
	public void click_Add_button() throws Throwable {

		up.clickAddBtn();
	}

	@When("^Enter Add User details employeename as \"([^\"]*)\" username as \"([^\"]*)\" and password \"([^\"]*)\" and as ConfirmPassword \"([^\"]*)\" and save$")
	public void enter_Add_User_details_employeename_as_username_as_and_password_and_as_ConfirmPassword_and_save(
			String empName, String Username, String pass, String conpass) throws Throwable {
		up = new UserPage(driver);
		Thread.sleep(2000);
		up.selectUserRole();
		up.enterEmpName(empName);
		up.enterUserName(Username);
		up.passwordEntry(pass, conpass);
		up.clickSave();

	}

	@When("^Check User list with username as \"([^\"]*)\"$")
	public void check_User_list_with_username_as(String username) throws Throwable {

		boolean check = up.checkUserwithUname(username);
		boolean expected = true;
		Assert.assertEquals(expected, check);
	}

	@Then("^Click on search result username as \"([^\"]*)\"$")
	public void click_on_search_result_username_as(String uname) throws Throwable {
		up = new UserPage(driver);
		Thread.sleep(2000);

		System.out.println(uname);
		up.checkresultwithUnameandClick(uname);
	}

	@Then("^Click on Edit Button$")
	public void click_on_Edit_Button() throws Throwable {
		up = new UserPage(driver);
		up.clickEditBtn();
	}

	@Then("^Check on Change Password$")
	public void check_on_Change_Password() throws Throwable {

		up.checkChangePass();
	}

	@Then("^Enter Password and Confirm Password as \"([^\"]*)\" and Save$")
	public void enter_Password_and_Confirm_Password_as_and_Save(String password) throws Throwable {

		up.passwordEntry(password, "Asd123234%!sd");
		Thread.sleep(2000);
		up.checkPasswordMessage();
		up.passwordEntry(password, password);
		Thread.sleep(2000);
		up.clickSave();
		Thread.sleep(2000);

	}

	@When("^Click on Locations Link$")
	public void click_on_Locations_Link() throws Throwable {
		Thread.sleep(2000);

		logger.info("*****Click Organization Link*****");

		lop = new LocationPage(driver);
		lop.clickOrganizationLink();
	}

	@When("^Add Locations$")
	public void add_Locations() throws Throwable {
		lop.addLocationFromExcel();
	}

	@When("^Check Location List$")
	public void check_Location_List() throws Throwable {

		lop.verifyLocationResults();
		Thread.sleep(500);
	}
}
