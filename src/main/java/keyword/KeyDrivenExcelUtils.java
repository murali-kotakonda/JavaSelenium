package keyword;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
->
1.Read the excel using apache poi
2.scan every row
3.read every row info and keep inside the action object
4.keep every action obj to the list
5.pass the list of action objects to the test class
 */

public class KeyDrivenExcelUtils {
	private FileInputStream fileInputStream;
	private XSSFWorkbook workbook;

	public KeyDrivenExcelUtils(String excelFilePath) {
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
	
	public Action getAction(XSSFSheet worksheet, int columns, int i) {
		List<String> steps = new ArrayList<>();
		for (int j = 0; j <=columns - 1; j++) {
			Cell cell = worksheet.getRow(i).getCell(j);
			String text;
			if (cell == null) {
				text = "";
			} else {
				text = cell.getStringCellValue();
			}
			steps.add(text);
		}
		
		Action action = new Action(
				steps.get(0), 
				steps.get(1), 
				steps.get(2),
				steps.get(3),
				steps.get(4), 
				steps.get(5),
				steps.get(6));
		return action;
	}
	
	public List<Action> getActions() {
		List<Action>  actions = new ArrayList<>();
		int testcasescount = getSheets();
		for (int count = 0; count < testcasescount; count++) {
			XSSFSheet worksheet = getSheet(count);
			int row = worksheet.getLastRowNum();
			int columns = worksheet.getRow(0).getLastCellNum();
			for (int i = 1; i <= row; i++) {
				Action action = getAction(worksheet, columns, i);
				actions.add(action);
			}
		}
		return actions;
	}
}
