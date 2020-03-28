package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationExample {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\HRM1\\HRM\\HRMSystem\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.newtours.demoaut.com/");

		// Getting Data from Excel Sheet
		FileInputStream file = new FileInputStream("C:\\DataDriven\\RegistrationInfo.xlsx");

		// Get the workbook instance for XLS file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Get first sheet from the workbook
		XSSFSheet sheet = workbook.getSheet("Sheet1"); // providing sheet name

		int noOfRows = sheet.getLastRowNum();

		System.out.println("Number of records in the excel sheet: " + noOfRows);

		for (int row = 1; row <= noOfRows; row++) {

			XSSFRow currentRow = sheet.getRow(row);

			String firstName = currentRow.getCell(0).toString();
			String lastName = currentRow.getCell(1).toString();
			String phone = currentRow.getCell(2).toString();
			String email = currentRow.getCell(3).toString();
			String address = currentRow.getCell(4).toString();
			String city = currentRow.getCell(5).toString();
			String state = currentRow.getCell(6).toString();
			String zipCode = currentRow.getCell(7).toString();
			String country = currentRow.getCell(8).toString();
			String userName = currentRow.getCell(9).toString();
			String password = currentRow.getCell(10).toString();
			String confPassword = currentRow.getCell(11).toString();

			// Registration Process
			driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();

			// Entering Contact Information
			driver.findElement(By.name("firstName")).sendKeys(firstName);
			driver.findElement(By.name("lastName")).sendKeys(lastName);
			driver.findElement(By.name("phone")).sendKeys(phone);
			driver.findElement(By.name("userName")).sendKeys(email);

			// Entering mailing information
			driver.findElement(By.name("address1")).sendKeys(address);
			driver.findElement(By.name("city")).sendKeys(city);
			driver.findElement(By.name("state")).sendKeys(state);
			driver.findElement(By.name("postalCode")).sendKeys(zipCode);

			// Country Selection
			Select countrySelect = new Select(driver.findElement(By.name("country")));
			countrySelect.selectByVisibleText(country);

			// User Information
			driver.findElement(By.name("email")).sendKeys(userName);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("confirmPassword")).sendKeys(confPassword);

			// Submit the form
			Thread.sleep(3000);
			driver.findElement(By.name("register")).click();

			// Validation Part
			if (driver.getPageSource().contains("Thank you for registering")) {
				System.out.println("Registration Completed for " + row + " record");

			} else {
				System.out.println("Registration is failed for " + row + " record");

//				Thread.sleep(2000);
//				driver.close();
			}
		}

		System.out.println("Data driven test complited");

		driver.close();
		// driver.quit();
		// file.close();

	}

}
