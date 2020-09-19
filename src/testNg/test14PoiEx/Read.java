package test14PoiEx;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read {

	public static void main(String[] args) throws IOException {
		Read readObj = new Read();
		String filePath = "C:\\Project";
		readObj.readExcel(filePath, "data.xlsx", "input");
	}

	public void readExcel(String filePath, String fileName, String sheetName) throws IOException {
		FileInputStream inputStream = new FileInputStream(filePath + "\\" + fileName);
		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		Workbook fileObj = null;
		if (fileExtensionName.equals(".xlsx")) {
			fileObj = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {
			fileObj = new HSSFWorkbook(inputStream);
		}

		Sheet sheetObj = fileObj.getSheet(sheetName);
		int rowCount = sheetObj.getLastRowNum() - sheetObj.getFirstRowNum();

		for (int i = 0; i < rowCount + 1; i++) {
			Row row = sheetObj.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				if (j == 0) {
					System.out.println(cell.getNumericCellValue());
				} else if (j == 1) {
					System.out.println(cell.getStringCellValue());
				}
			}
			System.out.println();
		}
	}

}