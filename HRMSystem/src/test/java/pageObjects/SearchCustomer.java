package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonMethods;

public class SearchCustomer extends CommonMethods {

	public WebDriver driver;

	public SearchCustomer(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
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
		Thread.sleep(2000);

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
		Thread.sleep(2000);

		check.click();
		btnDelete.click();
		Thread.sleep(2000);
		diologDelete.click();
		searchResultControl(norecord, "No Records Found");
	}
}
