package testNg1.test14Poi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteEmpObjs {
	public static void main(String... strings) throws IOException {
		List<Employee> emps = new ArrayList<Employee>();
		for(int i=1;i<=20;i++) {
			emps.add(new Employee(5000+i, "testuser"+i));	
		}
		
		String filePath = "C:\\Project";
		writeExcel(filePath, "data.xlsx", "output", emps);
	}
	
	public static void writeExcel(String filePath, String fileName, 
			String sheetName, List<Employee> emps)
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
		
		//workObj.removeSheetAt(0);
		Sheet sheet = workObj.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        
        for(Employee emp : emps) {
        	Row newRow = createRow(sheet,rowCount++);
        	int columnCount =0;
        	Cell cell = createCell(newRow,columnCount++);
			cell.setCellValue(emp.getId());
			
			cell = createCell(newRow,columnCount++);
			cell.setCellValue(emp.getName());
        }
		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		workObj.write(outputStream);
		outputStream.close();
	}
	
	private static Row createRow(Sheet sheet,int rowCount) {
		Row newRow = sheet.getRow(rowCount);
    	if(newRow==null) {
			newRow = sheet.createRow(rowCount);
		}
    	return newRow;
	}
	
	private static Cell createCell(Row row,int columnNo) {
		Cell cell = row.getCell(columnNo); 
		if(cell==null) {
			cell = row.createCell(columnNo);
		}
    	return cell;
	}
}