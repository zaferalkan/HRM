package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {

	// Robot class using
	public void uploadFileWithRobot(String imagePath) {
		StringSelection stringSelection = new StringSelection(imagePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

		Robot robot = null;

		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(150);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	//

	public void dateEntry(String month, String year, String day, WebElement m, WebElement y, List<WebElement> d)
			throws InterruptedException {

		ddlSelectionByText(month, m);
		ddlSelectionByText(year, y);

		List<WebElement> allDates = d;

		for (WebElement day1 : allDates) {
			String date = day1.getText();
			if (date.equalsIgnoreCase(day)) {
				day1.click();
				break;
			}
		}

	}

	// radio coiching
	public void genderRdb(List<WebElement> a, String v) {
		List<WebElement> radioBtn = a;
		for (WebElement radio : radioBtn) {
			String value = radio.getAttribute("value");
			if (radio.isEnabled() && value.equals(v)) {
				radio.click();
				break;
			}
		}
	}

	// dropdown selection by text
	public void ddlSelectionByText(String text, WebElement ddl) throws InterruptedException {
		Select s = new Select(ddl);
		s.selectByVisibleText(text);
		Thread.sleep(3000);
	}

	// dropdown selection by index
	public void ddlSelectionByInt(int Int, WebElement ddl1) throws InterruptedException {
		Select s = new Select(ddl1);
		s.selectByIndex(Int);
		Thread.sleep(3000);
	}

	public void mouseWithJS(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Vertical scroll down by 600 pixels
		js.executeScript("cursorBy(" + x + "," + y + ")");

	}

	public void mouseOverAction(WebElement element1, WebElement element2, WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(element1).moveToElement(element2).click().build().perform();
	}

	public void searchResultControl(WebElement e, String expected) {
		String a = e.getText();
		System.out.println(a);
		boolean ok = a.contains(expected);
		if (ok) {
			System.out.println("search result okey");
		} else {
			System.out.println("result error");
		}
	}

	public boolean searchtablebyId(WebDriver driver, int numOfRows, String id) {
		boolean flag = false;
		for (int i = 1; i <= numOfRows; i++) {
			String actualId = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println(actualId+""+numOfRows);
			if (id.equalsIgnoreCase(actualId)) {
				WebElement click=driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[1]"));
				click.click();
				flag = true;
			}

		}
		return flag;
	}
	
	public void readExcel(String filePath,String fileName,String sheetName) throws IOException{

	    //Create an object of File class to open xlsx file

	    File file =    new File(filePath+"\\"+fileName);

	    //Create an object of FileInputStream class to read excel file

	    FileInputStream inputStream = new FileInputStream(file);

	    Workbook guru99Workbook = null;

	    //Find the file extension by splitting file name in substring  and getting only extension name

	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xlsx file

	    if(fileExtensionName.equals(".xlsx")){

	    //If it is xlsx file then create object of XSSFWorkbook class

	    //guru99Workbook = new XSSFWorkbook(inputStream);

	    }

	    //Check condition if the file is xls file

	    else if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of HSSFWorkbook class

	        guru99Workbook = new HSSFWorkbook(inputStream);

	    }

	    //Read sheet inside the workbook by its name

	    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);

	    //Find number of rows in excel file

	    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();

	    //Create a loop over all the rows of excel file to read it

	    for (int i = 0; i < rowCount+1; i++) {

	        Row row = guru99Sheet.getRow(i);

	        //Create a loop to print cell values in a row

	        for (int j = 0; j < row.getLastCellNum(); j++) {

	            //Print Excel data in console

	            System.out.print(row.getCell(j).getStringCellValue()+"|| ");

	        }

	        System.out.println();
	    } 

	    }  

	    //Main function is calling readExcel function to read data from excel file

	    public static void main(String...strings) throws IOException{

	    //Create an object of ReadGuru99ExcelFile class

	   // ReadGuru99ExcelFile objExcelFile = new ReadGuru99ExcelFile();

	    //Prepare the path of excel file

	    String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";

	    //Call read file method of the class to read data

	    //objExcelFile.readExcel(filePath,"ExportExcel.xlsx","ExcelGuru99Demo");

	    }

}
