package test14PoiEx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
  Read data from all the sheets
    
 */
public class Ex2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		Workbook fileObj = new XSSFWorkbook(new FileInputStream("C:\\test\\Inputdata.xlsx"));

		//to get no of sheets
		int numberOfSheets = fileObj.getNumberOfSheets();

		for (int i = 0; i < numberOfSheets; i++) {
			System.out.println("********************SHEET  ************************************");
			Sheet sheetObj = fileObj.getSheetAt(i);

			// how to get all rows
			int rowCount = sheetObj.getLastRowNum() - sheetObj.getFirstRowNum();

			for (int r = 0; r <= rowCount; r++) {
				Row row = sheetObj.getRow(r);
				int cells = row.getLastCellNum() - row.getFirstCellNum();
				for (int c = 0; c < cells; c++) {
					Cell cell = row.getCell(c);
					System.out.print(cell.getStringCellValue() + " ");
				}
				System.out.println("\n");
			}
		}
	}
}
