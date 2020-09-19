package test15PiDataProvidersEx;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write {
	public void writeExcel(String filePath, String fileName, String sheetName, String[] dataToWrite)
			throws IOException {
		String file = filePath + "\\" + fileName;
		FileInputStream inputStream = new FileInputStream(file);
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		
		Workbook workObj = null;
		if (fileExtensionName.equals(".xlsx")) {
			workObj = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {
			workObj = new HSSFWorkbook(inputStream);
		}
		
		Sheet sheet = workObj.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		System.out.println(rowCount);
		Row newRow = sheet.createRow(rowCount + 1);
		for (int j = 0; j < dataToWrite.length; j++) {
			Cell cell = newRow.createCell(j);
			cell.setCellValue(dataToWrite[j]);
		}
		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		workObj.write(outputStream);
		outputStream.close();
	}

	public static void main(String... strings) throws IOException {
		String[] valueToWrite = { "200", "Noida", "25" };
		Write objExcelFile = new Write();
		String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\";
		objExcelFile.writeExcel(filePath, "data.xlsx", "output", valueToWrite);
	}
}