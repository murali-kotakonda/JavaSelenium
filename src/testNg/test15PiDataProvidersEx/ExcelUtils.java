package test15PiDataProvidersEx;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static Object[][] getTableArray(String path, String sheetName) throws IOException {
		FileInputStream inputStream = new FileInputStream(path);

		Workbook fileObj = new XSSFWorkbook(inputStream);

		Sheet sheetObj = fileObj.getSheet(sheetName);
		int rowCount = sheetObj.getLastRowNum() - sheetObj.getFirstRowNum();
		Row firstrow = sheetObj.getRow(0);
		int columns = firstrow.getLastCellNum();
		Object[][] data = new Object[rowCount + 1][columns];
		for (int i = 0; i < rowCount + 1; i++) {
			Row row = sheetObj.getRow(i);
			for (int j = 0; j < columns; j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				if (cellType.equals(CellType.STRING)) {
					data[i][j] = cell.getStringCellValue();
				} else if (cellType.equals(CellType.NUMERIC)) {
					data[i][j] = cell.getNumericCellValue();
				} else if (cellType.equals(CellType.BOOLEAN)) {
					data[i][j] = cell.getBooleanCellValue();
				}
			}
		}
		return data;
	}

	public static Object[][] getLoginObjs(String path, String sheetName) throws IOException {
		FileInputStream inputStream = new FileInputStream(path);
		List<Login> loginObjs = new ArrayList<Login>();

		Workbook fileObj = new XSSFWorkbook(inputStream);
		Sheet sheetObj = fileObj.getSheet(sheetName);
		int rowCount = sheetObj.getLastRowNum() - sheetObj.getFirstRowNum();

		for (int i = 0; i < rowCount + 1; i++) {
			Row row = sheetObj.getRow(i);
			Login emp = new Login();
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				if (j == 0) {
					emp.setName(cell.getStringCellValue());
				} else if (j == 1) {
					emp.setPass(cell.getStringCellValue());
				}
			}
			loginObjs.add(emp);
		}

		Object[][] loginArr = new Object[loginObjs.size()][1];
		int i = 0;
		for (Login e : loginObjs) {
			loginArr[i++][0] = e;
		}
		return loginArr;
	}

	public static void main(String[] args) throws IOException {
		Object[][] data = getTableArray("C://data.xlsx", "input");
		System.out.println(data);
		int rows = data.length;
		for (Object[] r : data) {
			for (Object d : r) {
				System.out.println(d);
			}
		}
	}

}
