package pageObjects;

import java.awt.AWTException;
import org.sikuli.script.Button;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.joda.time.Days;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Button;
import org.sikuli.script.Location;
import org.sikuli.script.Screen;

import com.sun.tools.internal.xjc.Driver;

import Utils.CommonMethods;
import Utils.WaitHelper;
import junit.framework.Assert;

public class AddEmployeePage extends CommonMethods {

	public WebDriver driver;
	public WaitHelper waithelp;


	public AddEmployeePage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
		waithelp = new WaitHelper(driver);

	}

	@FindBy(id = "menu_pim_viewPimModule")
	WebElement Pim;

	@FindBy(id = "menu_pim_addEmployee")
	WebElement AddEmp;

	@FindBy(id = "firstName")
	@CacheLookup
	WebElement enterFirstName;

	@FindBy(id = "lastName")
	@CacheLookup
	WebElement enterLastName;

	@FindBy(id = "employeeId")
	@CacheLookup
	WebElement enterEmpId;

	@FindBy(id = "chkLogin")
	@CacheLookup
	WebElement clickLogDetails;

	@FindBy(id = "user_name")
	@CacheLookup
	WebElement enterUserName;

	@FindBy(id = "user_password")
	@CacheLookup
	WebElement enterPassWord;

	@FindBy(id = "re_password")
	@CacheLookup
	WebElement reEnterPassWord;

	@FindBy(id = "status")
	@CacheLookup
	WebElement selectStatus;

	@FindBy(xpath = "//input[@id='btnSave']")
	@CacheLookup
	WebElement clickSaveBtn;

	@FindBy(xpath = "//input[@id='btnSave']")
	@CacheLookup
	WebElement clickSaveBtn1;

	@FindBy(xpath = "//input[@id='btnSave']")
	@CacheLookup
	WebElement editBtn;

	@FindBy(id = "personal_optGender_1")
	@CacheLookup
	WebElement maleRdb;

	@FindBy(id = "personal_optGender_2")
	@CacheLookup
	WebElement femaleRdb;

	@FindBy(id = "personal_cmbNation")
	@CacheLookup
	WebElement nationalityDdl;

	@FindBy(id = "personal_cmbMarital")
	@CacheLookup
	WebElement maritalDdl;

	@FindBy(id = "personal_txtLicExpDate")
	@CacheLookup
	WebElement licenseDate;

	@FindBy(id = "personal_DOB")
	@CacheLookup
	WebElement DOB;

	@FindBy(id = "btnSave")
	@CacheLookup
	WebElement saveBtn;

	@FindBy(className = "ui-datepicker-month")
	@CacheLookup
	WebElement monthDdl;

	@FindBy(className = "ui-datepicker-year")
	@CacheLookup
	WebElement yearDdl;

	@FindBy(className = "ui-datepicker-month")
	@CacheLookup
	WebElement monthDdl1;

	@FindBy(id = "welcome")
	@CacheLookup
	WebElement welcomeMenu;

	@FindBy(className = "ui-datepicker-year")
	@CacheLookup
	WebElement yearDdl1;

	@FindBy(id = "btnAddAttachment")
	@CacheLookup
	WebElement addAtt;

	@FindBy(id = "ufile")
	@CacheLookup
	WebElement fileBtn;

	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td")
	@CacheLookup
	List<WebElement> days;

	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td")
	@CacheLookup
	List<WebElement> days1;

	@FindBy(name = "personal[optGender]")
	@CacheLookup
	List<WebElement> genders;

	public void dobEntry() throws InterruptedException {
		DOB.click();
		Thread.sleep(2000);
		dateEntry("May", "1980", "12", monthDdl1, yearDdl1, days1);
	}

	public void clickMenu() {
		welcomeMenu.click();
	}

	public void clickFile() throws InterruptedException {
		fileBtn.click();
		Thread.sleep(2000);
		uploadFileWithRobot("C:\\Users\\acar5\\Desktop\\Thomas.jpg");
	}

	public void clickLicenseDate() throws InterruptedException {
		licenseDate.click();
		Thread.sleep(2000);
		dateEntry("Apr", "2025", "18", monthDdl, yearDdl, days);
	}

	public void firstName(String a) {
		enterFirstName.sendKeys(a);
	}

	public void lastName(String b) {
		enterLastName.sendKeys(b);
	}

	public void employeeId(String c) {
		enterEmpId.clear();
		enterEmpId.sendKeys(c);
	}

	public void createLoginDetails() {
		clickLogDetails.click();
	}

	public void userName(String d) {
		enterUserName.sendKeys(d);
	}

	public void password(String e) {
		waithelp.WaitForElement(enterPassWord, 10);
		enterPassWord.sendKeys(e);
	}

	public void confirmPass(String e) throws InterruptedException {
		waithelp.WaitForElement(reEnterPassWord, 10);
		reEnterPassWord.sendKeys(e);
	}

	public void statusSelection(int f) throws InterruptedException {
		Select s = new Select(selectStatus);
		s.selectByIndex(f);
	//	Thread.sleep(3000);
	}

	public void clickToSave() {
		clickSaveBtn.click();
	}

	public void clickAtt() {
		addAtt.click();
	}

	public void clickToSave1() {
		clickSaveBtn1.click();
	}

	public void clickToEdit() {
		editBtn.click();
	}

	public void genderselection2() {
		genderRdb(genders, "1");
	}

	public void genderSelection(String gender) {

		if (gender.equalsIgnoreCase("male")) {
			maleRdb.click();
		} else {
			femaleRdb.click();
		}
	}

	public void nationalitySelections() throws InterruptedException {
		ddlSelectionByText("Turkish", nationalityDdl);
	}

	public void maritalSelections() throws InterruptedException {
		ddlSelectionByText("Single", maritalDdl);
	}

	public void clickAddEmp() {
		mouseOverAction(Pim, AddEmp, driver);
	}

	public void choichefile() throws InterruptedException, FindFailed {
//		Point fileB=fileBtn.getLocation();
//		int x=fileB.x;
//		int y=fileB.y;
//		
		//reen screen = new Screen();
		//screen.findText("No file chosen").click();
		
		// Find where you want to move the mouse and set a location
		Location wheelPoint = new Location(100,500);
		wheelPoint.click();
		
		
		
		
		
	}
}
