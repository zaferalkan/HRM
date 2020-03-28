package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	public WebDriver driver;
	LoginPage lg ;

	public MainPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(id = "welcome")
	@CacheLookup
	WebElement welcomeMenu;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement LogoutLink;
	
	public void clickWelcomeMenu() {
		String a=driver.getCurrentUrl();
		String b="http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
		String c="http://166.62.36.207/humanresources/symfony/web/index.php/dashboard";
		if(a.equalsIgnoreCase(c)) {
			welcomeMenu.click();
		}else{
			//driver.quit();
			//Assert.assertEquals(a, c);
		}
	}
	
	public void clickWel() {
		welcomeMenu.click();

	}

	public void clickLogot() {
		LogoutLink.click();
	}

	
	public void titleVerification() {
		
		
		String actualTitle=welcomeMenu.getText();
		Assert.assertEquals("Welcome Admin", actualTitle);
	
	}

	
}