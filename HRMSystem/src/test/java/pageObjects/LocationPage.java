package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import utilities.CommonMethods;

public class LocationPage extends CommonMethods {

	public WebDriver driver;

	public LocationPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(id = "btnAdd")
	WebElement AddBtn;

	@FindBy(id = "location_name")
	WebElement locationName;

	@FindBy(id = "location_country")
	WebElement locationCountry;

	@FindBy(id = "btnSave")
	WebElement SaveBtn;

	@FindBy(id = "menu_admin_viewAdminModule")
	WebElement AdminLink;

	@FindBy(id = "menu_admin_Organization")
	WebElement organizationLink;

	@FindBy(id = "menu_admin_viewLocations")
	WebElement locationLink;

	@FindBy(css = "#resultTable")
	@CacheLookup
	WebElement searchTable;

	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;

	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumns;

	public void addLocation() throws InterruptedException {

		for (int i = 1; i < 6; i++) {
			AddBtn.click();
			locationName.sendKeys("Office" + i);
			ddlSelectionByInt(i, locationCountry);
			SaveBtn.click();
			System.out.println(i + "saved");
			Thread.sleep(2000);
		}
	}

	public void addLocationFromExcel() throws IOException, InterruptedException {
		FileInputStream file = new FileInputStream("C:\\Users\\acar5\\Desktop\\Business.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet("Sheet1"); // providing sheet name

		int rowCount = sheet.getLastRowNum(); // returns row count
		System.out.println(rowCount + " row count");

		int columnCount = sheet.getRow(0).getLastCellNum(); // returns column/cell count
		System.out.println(columnCount + " column count");

		for (int i = 1; i <= rowCount; i++) {

			XSSFRow currentRow = sheet.getRow(i); // focused on current row
			String lName = currentRow.getCell(0).getStringCellValue();
			String country = currentRow.getCell(1).getStringCellValue();
			AddBtn.click();
			locationName.sendKeys(lName);
			ddlSelectionByText(country, locationCountry);
			SaveBtn.click();
			System.out.println(i + "saved");
			Thread.sleep(2000);

		}

	}

	public void clickOrganizationLink() {
		mouseOverAction(AdminLink, organizationLink, locationLink, driver);
	}

	public void verifyLocationResults() throws IOException, InterruptedException {

		FileInputStream file = new FileInputStream("C:\\Users\\acar5\\Desktop\\Business.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet("Sheet1"); // providing sheet name

		int rowCountGrid = tableRows.size();

		int rowCount = sheet.getLastRowNum(); // returns row count

		int columnCount = sheet.getRow(0).getLastCellNum(); // returns column/cell count
		boolean flag = false;

		for (int i = 1; i <= rowCount; i++) {

			XSSFRow currentRow = sheet.getRow(i); // focused on current row
			String lName = currentRow.getCell(0).getStringCellValue();
			String country = currentRow.getCell(1).getStringCellValue();

			for (int j = 1; j <= rowCountGrid; j++) {
				String resultLocationName = driver
						.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + j + "]/td[2]")).getText();
				String resulCountry = driver
						.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + j + "]/td[4]")).getText();
				if (lName.equalsIgnoreCase(resultLocationName)) {
					if (country.equalsIgnoreCase(resulCountry)) {
						flag = true;
						System.out.println(flag);
						System.out.println(resultLocationName + "-" + resulCountry);
						
					}

				}

			}

		}
		Assert.assertEquals(flag, true);

	}
}
