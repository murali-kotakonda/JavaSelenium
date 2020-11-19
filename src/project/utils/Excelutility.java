package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import test4.dataProvier.Employee;
public class Excelutility {
	public static Object[][] getTableArray(String path,String sheetName) throws IOException {
		FileInputStream inputStream = new FileInputStream(path);

		Workbook fileObj = new XSSFWorkbook(inputStream);

		Sheet sheetObj = fileObj.getSheet(sheetName);
		int rowCount = sheetObj.getLastRowNum() - sheetObj.getFirstRowNum();
		//List<Employee> emps  = new ArrayList<>();
		Row firstrow = sheetObj.getRow(0);
		int columns = firstrow.getLastCellNum();
		Object[][] data = new Object[rowCount+1][columns];
		for (int i = 0; i < rowCount + 1; i++) {
			Row row = sheetObj.getRow(i);
			for (int j = 0; j < columns; j++) {
				Cell cell = row.getCell(j);
				//cell.get
				data[i][j] = cell.getStringCellValue();
				/*CellType cellType = cell.getCellType();
				if(cellType.equals(CellType.STRING)) {
					data[i][j] = cell.getStringCellValue();
				}else if(cellType.equals(CellType.NUMERIC)) {
					data[i][j] = cell.getNumericCellValue();
				}else if(cellType.equals(CellType.BOOLEAN)) {
					data[i][j] = cell.getBooleanCellValue();
				}*/
			}
		}
		return data;
	}

	public static void main(String[] args) throws IOException {
		String filePath = "E:\\";           
		 filePath= filePath + "Book1.xlsx";	
		Object[][] data = getTableArray(filePath,"Sheet1");
		System.out.println(data);
		int rows = data.length;
		for(Object[] r : data) {
			for(Object d: r) {
			System.out.println(d);
			}
		}
	}

}
	

