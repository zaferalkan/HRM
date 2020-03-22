package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddEmployeePage;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.SearchCustomer;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public MainPage mp;
	public AddEmployeePage ae;
	public SearchCustomer sc;
	

	public static String randomString() {
		
		String generateString1=RandomStringUtils.randomAlphabetic(5);
		
		return generateString1;
		
	}
}
