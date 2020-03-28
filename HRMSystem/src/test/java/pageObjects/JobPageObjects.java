package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.CommonMethods;
import utilities.WaitHelper;

public class JobPageObjects extends CommonMethods {

	public WebDriver driver;
	public WaitHelper waithelp;

	public JobPageObjects(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
		waithelp = new WaitHelper(driver);
	}

	// Job Titles
	@FindBy(id = "menu_admin_viewAdminModule")
	WebElement AdminJT;

	@FindBy(id = "menu_admin_Job")
	WebElement JobJT;

	@FindBy(id = "menu_admin_viewJobTitleList")
	WebElement JobTitles;

	@FindBy(xpath = "//input[@id='btnAdd']")
	WebElement AddNewJobBtn;

	@FindBy(id = "jobTitle_jobTitle")
	WebElement JobTitle;

	@FindBy(id = "jobTitle_jobDescription")
	WebElement JobDescription;

	@FindBy(id = "jobTitle_note")
	WebElement JobNote;

	@FindBy(id = "btnSave")
	WebElement SaveJob;

	public void clickJobTitles() {
		mouseOverAction(AdminJT, JobJT, JobTitles, driver);
	}

	public void clickAddNewJob() throws InterruptedException {
		AddNewJobBtn.click();
		Thread.sleep(2000);
	}

	public void typeJobTitle(String JTitle) {
		JobTitle.sendKeys(JTitle);
	}

	public void typeJobDescription(String JDescription) {
		JobDescription.sendKeys(JDescription);
	}

	public void typeNote(String JNote) {
		JobNote.sendKeys(JNote);
	}

	public void clickSaveNewJob() throws InterruptedException {
		Thread.sleep(2000);
		SaveJob.click();
	}

	// Pay Grades
	@FindBy(id = "menu_admin_viewAdminModule")
	WebElement AdminPG;

	@FindBy(id = "menu_admin_Job")
	WebElement JobPG;

	@FindBy(id = "menu_admin_viewPayGrades")
	WebElement PayGrade;

	@FindBy(xpath = "//input[@id='btnAdd']")
	WebElement AddPayGradeBtn;

	@FindBy(id = "payGrade_name")
	WebElement PayGradeName;

	@FindBy(id = "btnSave")
	WebElement SavePayGrade;

	@FindBy(id = "btnAddCurrency")
	WebElement AddCurrency;

	@FindBy(id = "payGradeCurrency_currencyName")
	WebElement CurrencyName;

	@FindBy(id = "payGradeCurrency_minSalary")
	WebElement MinSalary;

	@FindBy(id = "payGradeCurrency_maxSalary")
	WebElement MaxSalary;

	@FindBy(id = "btnSaveCurrency")
	WebElement SaveCurrency;

	@FindBy(id = "welcome")
	WebElement WelcomeMenuJob;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement LogOutPayGrades;

	public void clickPayGrades() throws InterruptedException {
		Thread.sleep(3000);
		mouseOverAction(AdminPG, JobPG, PayGrade, driver);
	}

	public void clickAddNewPayGrade() {
		AddPayGradeBtn.click();
	}

	public void enterPayGradeName(String paygradename) throws InterruptedException {
		PayGradeName.sendKeys(paygradename);
	}

	public void clickSavePayGrade() {
		SavePayGrade.click();
	}

	public void clickAddCurrency() {
		AddCurrency.click();
	}

	public void enterCurrencyName(String currency) throws InterruptedException {
		Thread.sleep(2000);
		CurrencyName.sendKeys(currency);
		CurrencyName.sendKeys(Keys.ARROW_DOWN);
		CurrencyName.sendKeys(Keys.ARROW_DOWN);
		CurrencyName.sendKeys(Keys.ARROW_DOWN);
		CurrencyName.sendKeys(Keys.ENTER);
	}

	public void minCurrency(String min) {
		MinSalary.sendKeys(min);

	}

	public void maxCurrency(String max) {
		MaxSalary.sendKeys(max);
	}

	public void clickSaveCurrency() {
		SaveCurrency.click();
	}

	public void clickWelcome() throws InterruptedException {
		Thread.sleep(2000);
		WelcomeMenuJob.click();
		Thread.sleep(2000);
	}

	public void clickLogOut() {
		LogOutPayGrades.click();

	}

	// Employment Status
	@FindBy(id = "menu_admin_viewAdminModule")
	WebElement AdminES;

	@FindBy(id = "menu_admin_Job")
	WebElement JobES;

	@FindBy(id = "menu_admin_employmentStatus")
	WebElement EmpStatus;

	@FindBy(xpath = "//input[@id='btnAdd']")
	WebElement AddEmpStatusBtn;

	@FindBy(id = "empStatus_name")
	WebElement EmpStatusName;

	@FindBy(id = "btnSave")
	WebElement SaveEmpStatus;

	@FindBy(id = "welcome")
	WebElement WelcomeMenuES;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement LogOutEmpStatus;

	public void clickEmploymentStatus() throws InterruptedException {
		Thread.sleep(3000);
		mouseOverAction(AdminES, JobES, EmpStatus, driver);
	}

	public void clickEmpStatusBtn() {
		AddEmpStatusBtn.click();

	}

	public void enterEmpStatusName(String empStatusName) {
		EmpStatusName.sendKeys(empStatusName);
	}

	public void clickSaveEmpStatus() {
		SaveEmpStatus.click();
	}

	public void clickWelcomeES() {
		WelcomeMenuES.click();
	}

	public void logOutES() {
		LogOutEmpStatus.click();
	}

	// Job Categories
	@FindBy(id = "menu_admin_viewAdminModule")
	WebElement AdminJC;

	@FindBy(id = "menu_admin_Job")
	WebElement JobJC;

	@FindBy(id = "menu_admin_jobCategory")
	WebElement JobCategory;

	@FindBy(xpath = "//input[@id='btnAdd']")
	WebElement AddJobCatBtn;

	@FindBy(id = "jobCategory_name")
	WebElement JobCatName;

	@FindBy(id = "btnSave")
	WebElement SaveJobCat;

	@FindBy(id = "welcome")
	WebElement WelcomeMenuJC;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement LogOutJobCat;

	public void clickJobCategories() {
		mouseOverAction(AdminJC, JobJC, JobCategory, driver);
	}

	public void clickAddNewJobCat() {
		AddJobCatBtn.click();
	}

	public void enterJobCatName(String jobCatName) {
		JobCatName.sendKeys(jobCatName);
	}

	public void clickSaveJobCat() {
		SaveJobCat.click();
	}

	public void clickWelcomeJobCat() {
		WelcomeMenuJC.click();
	}

	public void clickLogOutJobCat() {
		LogOutJobCat.click();
	}

	// Work Shifts
	@FindBy(id = "menu_admin_viewAdminModule")
	WebElement AdminWS;

	@FindBy(id = "menu_admin_Job")
	WebElement JobWS;

	@FindBy(id = "menu_admin_workShift")
	WebElement WorkShifts;

	@FindBy(xpath = "//input[@id='btnAdd']")
	WebElement AddWorkShiftBtn;

	@FindBy(id = "workShift_name")
	WebElement ShiftName;

	@FindBy(id = "workShift_workHours_from")
	WebElement TimeBegins;

	@FindBy(id = "workShift_workHours_to")
	WebElement TimeFinishes;

	@FindBy(id = "workShift_availableEmp")
	WebElement AvailableEmployees;

	@FindBy(id = "btnAssignEmployee")
	WebElement AssignEmployee;;

	public void clickWorkShifts() {
		mouseOverAction(AdminWS, JobWS, WorkShifts, driver);
	}

	public void clickAddWorkShiftName() {
		AddWorkShiftBtn.click();
	}

	public void enterShiftName(String sn) {
		ShiftName.sendKeys(sn);
	}

	public void beginHours(String from) throws InterruptedException {
		Select bh = new Select(TimeBegins);
		bh.selectByValue(from);
		Thread.sleep(2000);
	}

	public void finishHours(String to) throws InterruptedException {
		Select fh = new Select(TimeFinishes);
		fh.selectByValue(to);
		Thread.sleep(2000);

	}

	public void employeeSelection(String employee) {
		Select es = new Select(AvailableEmployees);
		es.selectByVisibleText(employee);

	}
	

	public void clickAddToAssignEmp() {
		AssignEmployee.click();
	}

	public void workShiftDataEntry(String Shiftnama, String fromT,String tot,String Emp) throws InterruptedException {
		
		clickAddWorkShiftName();
		enterShiftName(Shiftnama);
		beginHours(fromT);
		finishHours(tot);
		employeeSelection(Emp);
		clickAddToAssignEmp();
		SaveJob.click();
		
	}
}
