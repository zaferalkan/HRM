package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonMethods;
import Utils.WaitHelper;

public class SearchCustomer extends CommonMethods {

	public WebDriver driver;
	public WaitHelper waithelp;

	public SearchCustomer(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
		waithelp = new WaitHelper(driver);

	}

	@FindBy(id = "menu_pim_viewPimModule")
	WebElement PimLnk;

	@FindBy(xpath = "//a[text()='Employee List']")
	WebElement EmployeeListLnk;

	@FindBy(id = "searchBtn")
	WebElement searchButton;

	@FindBy(id = "empsearch_employee_name_empName")
	WebElement empName;

	@FindBy(id = "ohrmList_chkSelectAll")
	WebElement check;

	@FindBy(id = "btnDelete")
	WebElement btnDelete;

	@FindBy(id = "welcome")
	@CacheLookup
	WebElement welcomeMenu;

	@FindBy(xpath = "//td[contains(text(),'No Records Found')]")
	@CacheLookup
	WebElement norecord;

	@FindBy(css = "tbody")
	@CacheLookup
	WebElement searchResult;

	@FindBy(css = "#dialogDeleteBtn")
	@CacheLookup
	WebElement diologDelete;

	public void clickEmpList() {
		mouseOverAction(PimLnk, EmployeeListLnk, driver);
	}

	public void enterEmpName(String text) throws InterruptedException {
		waithelp.WaitForElement(empName, 10);
		empName.click();

		empName.sendKeys(text);
		// Thread.sleep(2500);
		// driver.findElement(By.id("empsearch_employee_status")).click();
	}

	public void searchButtonClick() {
		searchButton.click();
	}

	public void clickMenu() {
		welcomeMenu.click();
	}

	public void searchResultControl(String searchText) throws InterruptedException {

		searchResultControl(searchResult, searchText);
		waithelp.WaitForElement(check, 10);
		check.click();
		waithelp.WaitForElement(btnDelete, 10);
		btnDelete.click();
		waithelp.WaitForElement(diologDelete, 10);
		diologDelete.click();
		searchResultControl(norecord, "No Records Found");
	}
}
