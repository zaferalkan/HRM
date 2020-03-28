package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

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
	
	public void mouseOverAction(WebElement element1, WebElement element2, WebElement element3, WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(element1).moveToElement(element2).moveToElement(element3).click().build().perform();
	}
	
//	public void mouseOverAction2(WebElement element1, WebElement element2, WebElement element3, WebDriver driver) {
//		Actions action = new Actions(driver);
//		action.moveToElement(element1).moveToElement(element2).moveToElement(element3).click().build().perform();
//	}

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
}
