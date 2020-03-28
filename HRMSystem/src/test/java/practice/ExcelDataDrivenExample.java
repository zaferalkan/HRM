package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDrivenExample {

	public ArrayList<String> getData(String testCaseName) throws IOException {

		// fileInputStream argument

		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fis = new FileInputStream("C:\\DataDriven\\ShiftTable.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("testData")) {

				XSSFSheet sheet = workbook.getSheetAt(i);

				// identify testcase column by scanning the entire 1st row

				Iterator<Row> rows = sheet.iterator(); // sheet is collection of rows
				Row firstRow = rows.next();
				Iterator<Cell> cells = firstRow.cellIterator(); // sheet is collection of cells
				int k = 0;
				int column = 0;
				while (cells.hasNext()) {
					Cell value = cells.next();
					if (value.getStringCellValue().equalsIgnoreCase("Shifts")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);

				// once column is identify then scan entire testcase column to identify Shift B
				// testcase row

				while (rows.hasNext()) {

					Row r = rows.next();

					if (r.getCell(column).getStringCellValue().equalsIgnoreCase("Shift B")) {

						// after you grab Shift B testcase row = pull all the data of that row and feed
						// into test

						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							a.add(cv.next().getStringCellValue());

						}
					}

				}

			}

		}
		return a;

	}

	public static void main(String[] args) throws IOException {

	}

}
