package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import utilities.CommonMethods;
import utilities.WaitHelper;

public class UserPage extends CommonMethods {

	public WebDriver driver;
	public WaitHelper waithelp;

	public UserPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
		waithelp = new WaitHelper(driver);

	}
	
	@FindBy(id = "defaultList__csrf_token")
	WebElement hidden;
	
	@FindBy(id = "menu_admin_viewAdminModule")
	WebElement AdminMenu;

	@FindBy(id = "systemUser_userType")
	WebElement userRole;

	@FindBy(id = "menu_admin_UserManagement")
	WebElement UserManagementMenu;

	@FindBy(id = "menu_admin_viewSystemUsers")
	WebElement UsersMenu;

	@FindBy(id = "btnAdd")
	WebElement btnAdd;

	@FindBy(id = "btnSave")
	WebElement btnSave;
	
	@FindBy(xpath = "//input[@value='Edit']")
	WebElement btnEdit;
	
	@FindBy(id = "systemUser_chkChangePassword")
	WebElement chechChangePass;
	
	@FindBy(id = "systemUser_employeeName_empName")
	WebElement empName;

	@FindBy(id = "systemUser_userName")
	WebElement userName;

	@FindBy(id = "systemUser_password")
	WebElement Password;

	@FindBy(id = "systemUser_confirmPassword")
	WebElement cofirmPassword;

	@FindBy(xpath = "//span[contains(text(),'Passwords do not match')]")
	WebElement wrongPasswordMessage;
	
	@FindBy(css = "#resultTable")
	@CacheLookup
	WebElement searchTable;

	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;

	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumns;

	public void clickUsersLink() {
		mouseOverAction(AdminMenu, UserManagementMenu, UsersMenu, driver);
	}

	public void clickAddBtn() {
		btnAdd.click();
	}

	public void enterEmpName(String name) {
		empName.sendKeys(name);

	}

	public void enterUserName(String usern) {
		userName.sendKeys(usern);
	}

	public void passwordEntry(String password, String confirmPass) throws InterruptedException {
		Password.clear();
		Password.sendKeys(password);
		cofirmPassword.clear();
		cofirmPassword.sendKeys(confirmPass);

		Thread.sleep(3500);
	}

	public void clickSave() throws InterruptedException {
		Thread.sleep(1500);
		btnSave.click();
		
		Thread.sleep(5500);
	}
	public boolean checkUserwithUname(String username) {
		boolean flag=false;
		int a=tableRows.size();
		System.out.println(a);
		for (int i=1;i<=tableRows.size();i++) {
			String rowUserName = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println(i+"-"+rowUserName);
			if(username.equalsIgnoreCase(rowUserName)) {
				flag=true;
			}
			
		}
		return flag;
	}
	
	public void checkresultwithUnameandClick(String username) {
		int a=tableRows.size();
		System.out.println(a);
		for (int i=1;i<=tableRows.size();i++) {
			String rowUserName = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[2]")).getText();
			if(username.equalsIgnoreCase(rowUserName)) {
				System.out.println(i+"-"+rowUserName);
				driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[2]/a")).click();
			}
			
		}
	}
	public void selectUserRole() throws InterruptedException {
		ddlSelectionByText("Admin", userRole);
		ddlSelectionByText("ESS", userRole);

	}
	public void clickEditBtn() {
		btnEdit.click();
	}
	
	public void checkChangePass() {
		chechChangePass.click();
	}
	public void checkPasswordMessage() {
		boolean messageIsdisplayed=wrongPasswordMessage.isDisplayed();
		if(messageIsdisplayed) {
			System.out.println("password does not match message is displayed");
		}
		Assert.assertEquals(true, messageIsdisplayed);
	}
}
