package testkeywords;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private FileInputStream fileInputStream;
	private XSSFWorkbook workbook;

	public ExcelUtils(String excelFilePath) {
		try {
			fileInputStream = new FileInputStream(excelFilePath);
			workbook = new XSSFWorkbook(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getSheets() {
		return workbook.getNumberOfSheets();
	}
	
	public XSSFSheet getSheet(int sheetNo) {
		return workbook.getSheetAt(sheetNo);	
	}
	
	public Action getRow(XSSFSheet worksheet, int columns, int i) {
		List<String> testExcutions = new ArrayList<>();
		for (int j = 0; j <=columns - 1; j++) {
			Cell cell = worksheet.getRow(i).getCell(j);
			String text;
			if (cell == null) {
				text = "";
			} else {
				text = cell.getStringCellValue();
			}
			testExcutions.add(text);
		}
		
		Action testcase = new Action(
				testExcutions.get(0), 
				testExcutions.get(1), 
				testExcutions.get(2),
				testExcutions.get(3),
				testExcutions.get(4), 
				testExcutions.get(5));
		return testcase;
	}
	
	public List<Action> getTestCases() {
		List<Action>  testcases = new ArrayList<>();
		int testcasescount = getSheets();
		for (int count = 0; count < testcasescount; count++) {
			XSSFSheet worksheet = getSheet(count);
			int row = worksheet.getLastRowNum();
			int columns = worksheet.getRow(0).getLastCellNum();
			for (int i = 1; i <= row; i++) {
				Action testcase = getRow(worksheet, columns, i);
				testcases.add(testcase);
			}
		}
		return testcases;
	}

}
