package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "txtUsername")
	@CacheLookup
	WebElement username;

	@FindBy(id = "txtPassword")
	@CacheLookup
	WebElement password;

	@FindBy(id = "btnLogin")
	@CacheLookup
	WebElement btnLogin;

	
	
	//Title
	@FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
	@CacheLookup
	WebElement welcomeLbl;

	@FindBy(id = "logInPanelHeading")
	@CacheLookup
	WebElement LblLoginHead;
	
	@FindBy(css ="#spanMessage")
	@CacheLookup
	WebElement invalidMessage;
	

	// We are creating the methods based on page object model

	public void setUserName(String uname) {
		username.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	
	public void clickLogin() {
		btnLogin.click();
	}

	public void invalidEntry() {
		 invalidMessage.getText();
	}

}
