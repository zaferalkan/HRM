package stepDefinitions;

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
import gherkin.ast.ScenarioOutline;
import pageObjects.AddEmployeePage;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.SearchCustomer;

public class steps extends BaseClass {

	@Before
	public void setup() throws IOException {

		//logger configuration
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
<<<<<<< Updated upstream
		mp.clickWelcomeMenu();
=======
		mp.clickWel();
//		jpo = new JobPageObjects(driver);
//		jpo.clickWelcome();
//		jpo.clickWelcomeES();
>>>>>>> Stashed changes

	}

	@When("^User click on Log out link$")
	public void user_click_on_Log_out_link() throws InterruptedException {
		logger.info("*****logout process started*****");
<<<<<<< Updated upstream

		mp = new MainPage(driver);
		sc = new SearchCustomer(driver);
		mp.clickLogot();
=======
		// ae = new AddEmployeePage(driver);
		mp = new MainPage(driver);
		// sc = new SearchCustomer(driver);
		mp.clickLogot();
		// jpo = new JobPageObjects(driver);
//		jpo.clickLogOut();
//		jpo.logOutES();
		// ae.logOutEmpPage();
>>>>>>> Stashed changes

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
		ae.clickMenu();
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

<<<<<<< Updated upstream
=======
	// Job Titles

	@When("^Click on Job Titles$")
	public void click_on_Job_Titles() throws Throwable {
		jpo = new JobPageObjects(driver);
		jpo.clickJobTitles();

	}

	@Then("^Click on Add Button$")
	public void click_on_Add_Button() throws Throwable {
		jpo = new JobPageObjects(driver);
		jpo.clickAddNewJob();
	}

	@Then("^Enter A New Job Title$")
	public void enter_A_New_Job_Title() throws Throwable {
		jpo.typeJobTitle("Bakery Chef");
	}

	@Then("^Enter Job Description$")
	public void enter_Job_Description() throws Throwable {
		jpo.typeJobDescription("Minimum 5 years europian deserts experience");

	}

	@Then("^Enter Benefits into Notes$")
	public void enter_Benefits_into_Notes() throws Throwable {
		jpo.typeNote("Full Time, 5 days working day in a week, Free parking, and bonus ");

	}

	@Then("^Click on Save Button$")
	public void click_on_Save_Button() throws Throwable {
		jpo = new JobPageObjects(driver);
		jpo.clickSaveNewJob();
		Thread.sleep(2000);
		mp = new MainPage(driver);
		mp.clickWelcomeMenu();
		// mp.clickLogot();

	}

	// Pay Grade Steps

	@When("^Click on Pay Grades$")
	public void click_on_Pay_Grades() throws Throwable {
		jpo = new JobPageObjects(driver);
		jpo.clickPayGrades();

	}

	@Then("^Click on Add Button to Enter Pay Grade$")
	public void click_on_Add_Button_to_Enter_Pay_Grade() throws Throwable {
		jpo.clickAddNewPayGrade();

	}

	@Then("^Enter Pay Grade$")
	public void enter_Pay_Grade() throws Throwable {
		jpo.enterPayGradeName("BiWeekly8");
	}

	@Then("^Click Save Button$")
	public void click_Save_Button() throws Throwable {
		jpo.clickSavePayGrade();

	}

	@Then("^Click on Add Button to Enter Assigned Currencies$")
	public void click_on_Add_Button_to_Enter_Assigned_Currencies() throws Throwable {
		jpo.clickAddCurrency();

	}

	@Then("^Enter Currency$")
	public void enter_Currency() throws Throwable {
		jpo.enterCurrencyName("dollar");
		Thread.sleep(2000);

	}

	@Then("^Enter Min and Max Salary$")
	public void enter_Min_and_Max_Salary() throws Throwable {
		jpo.minCurrency("1000");
		Thread.sleep(2000);
		jpo.maxCurrency("1200");

	}

	@Then("^Click Add Button to Save Currency$")
	public void click_Add_Button_to_Save_Currency() throws Throwable {
		jpo = new JobPageObjects(driver);
		jpo.clickSaveCurrency();

	}

	// Employment Status Steps

	@When("^Click on Employment Status$")
	public void click_on_Employment_Status() throws Throwable {
		jpo = new JobPageObjects(driver);
		jpo.clickEmploymentStatus();
	}

	@Then("^Enter Employment Status Name$")
	public void enter_Employment_Status_Name() throws Throwable {
		jpo.enterEmpStatusName("Part-Time Role2");

	}

	@Then("^Click on Save Button to Save Employment Status$")
	public void click_on_Save_Button_to_Save_Employment_Status() throws Throwable {
		jpo.clickSaveEmpStatus();

	}

	// Job Categories Steps

	@When("^Click on Job Categories$")
	public void click_on_Job_Categories() throws Throwable {
		jpo = new JobPageObjects(driver);
		jpo.clickJobCategories();
	}

	@Then("^Enter A New Job Category$")
	public void enter_A_New_Job_Category() throws Throwable {
		jpo.enterJobCatName("Mechanics4");
	}

	// Work Shifts

	@When("^Click on Work Shifts$")
	public void click_on_Work_Shifts() throws Throwable {
		Thread.sleep(2000);
		jpo = new JobPageObjects(driver);
		jpo.clickWorkShifts();
	}

	@Then("^Enter Credentials ShiftName as \"([^\"]*)\" and Start/Finish Time \"([^\"]*)\" \"([^\"]*)\" and Select Employee as \"([^\"]*)\" and Save$")
	public void enter_Credentials_ShiftName_as_and_Start_Finish_Time_and_Select_Employee_as_and_Save(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		
		
	    jpo.workShiftDataEntry(arg1, arg2, arg3, arg4);
	    
	    
	}

>>>>>>> Stashed changes
}
