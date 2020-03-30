package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddEmployeePage;
import pageObjects.LocationPage;
import pageObjects.JobPageObjects;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.SearchCustomer;
import pageObjects.UserPage;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public MainPage mp;
	public AddEmployeePage ae;
	public SearchCustomer sc;
	public Logger logger;
	public Properties configProp;

	public UserPage up;
	public LocationPage lop;
	public JobPageObjects jpo;
	

	public static String randomString() {
		
		String generateString1=RandomStringUtils.randomAlphabetic(5);
		
		return generateString1;
		
	}
}
