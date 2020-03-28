package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		

		FileInputStream file = new FileInputStream("C:\\DataDriven\\ShiftTable.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet("Sheet1"); // providing sheet name

		int rowCount = sheet.getLastRowNum(); // returns row count

		int columnCount = sheet.getRow(0).getLastCellNum(); // returns column/cell count

		for (int i = 0; i < rowCount; i++) {

			XSSFRow currentRow = sheet.getRow(i); // focused on current row

			for (int j = 0; j < columnCount; j++) {

				String value = currentRow.getCell(j).toString(); // read the value from a cell - toString is generic
																	// method which can read any type of data

				System.out.print(" " + value);
			}
			System.out.println();
		}

	}

}
