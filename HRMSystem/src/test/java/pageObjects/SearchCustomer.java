package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import utilities.CommonMethods;
import utilities.WaitHelper;

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

	@FindBy(css = "#resultTable")
	@CacheLookup
	WebElement searchTable;
	
	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;
	
	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumns;

	@FindBy(css = "#dialogDeleteBtn")
	@CacheLookup
	WebElement diologDelete;

	public void clickEmpList() {
		mouseOverAction(PimLnk, EmployeeListLnk, driver);
	}

	public void enterEmpName(String text) throws InterruptedException {
		waithelp.WaitForElement(empName, 20000);
		Thread.sleep(2000);

		empName.click();

		empName.sendKeys(text);
		Thread.sleep(2500);
		// driver.findElement(By.id("empsearch_employee_status")).click();
	}

	public void searchButtonClick() {
		searchButton.click();
	}

	public void clickMenu() {
		welcomeMenu.click();
	}

	public void searchcustomerbyid(String id) {
		int rowSize=tableRows.size();
		boolean searchStatus = searchtablebyId(driver, rowSize, id);
		Assert.assertEquals(true, searchStatus);
	}

	public void searchResultControl(String searchText) throws InterruptedException {

		Thread.sleep(2000);
		waithelp.WaitForElement(btnDelete, 20000);
		btnDelete.click();
		waithelp.WaitForElement(diologDelete, 20000);
		diologDelete.click();
	}
}
