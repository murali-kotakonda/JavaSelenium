package testNg1.test14Poi;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadEmpObjs {

	public static void main(String []args) throws IOException {
		String filePath = "C:\\Project";
		List<Employee> emps  = readExcel(filePath, "data.xlsx", "output");
		for(Employee e: emps) {
			System.out.println(e.getId());
			System.out.println(e.getName());
		}
	}
	
	public static List<Employee> readExcel(String filePath, String fileName, String sheetName) throws IOException {
		FileInputStream inputStream = new FileInputStream(filePath + "\\" + fileName);
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		List<Employee> emps= new ArrayList<Employee>();
		
		Workbook fileObj = null;
		if (fileExtensionName.equals(".xlsx")) {
			fileObj = new XSSFWorkbook(inputStream);
		}else if (fileExtensionName.equals(".xls")) {
			fileObj = new HSSFWorkbook(inputStream);
		}

		Sheet sheetObj = fileObj.getSheet(sheetName);
		int rowCount = sheetObj.getLastRowNum() - sheetObj.getFirstRowNum();
		
		for (int i = 0; i < rowCount + 1; i++) {
			Row row = sheetObj.getRow(i);
			Employee emp = new Employee();
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				if(j==0) {
				emp.setId((int)cell.getNumericCellValue());
				}else if(j==1) {
					emp.setName(cell.getStringCellValue());
				}
			}
			emps.add(emp);
		}
		return emps;
	}

}