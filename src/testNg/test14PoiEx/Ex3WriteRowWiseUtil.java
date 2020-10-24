package test14PoiEx;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 Write to excel from java:
------------------------------
i/p:
--------------
String[] valueToWrite = { "60000", "Mythri Tech", "25" , "hello" };

o/p in excel:
--------------------
60000
Mythri Tech
25
Hello

New:
-----------
1.create workbook
2.need sheet
3.need row
4.need cell
5.create output strem obj

6.
how to read cell value?
cell.getStringCellValue()


how to write cell value?
cell.setCellValue("kumar");

7.workObj.write(outputStream);

 */
public class Ex3WriteRowWiseUtil {
	public static void main(String... strings) throws IOException {
		String[] valueToWrite = { "60000", "Mythri Tech", "25" , "hello" };
		Ex3WriteRowWiseUtil objExcelFile = new Ex3WriteRowWiseUtil();
		String filePath = "C:\\test";
		objExcelFile.writeExcel(filePath, "data.xlsx", "output", valueToWrite);
	}
	
	public static void writeExcel(String filePath, String fileName, 
			String sheetName, String[] valueToWrite)
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
		
		//workObj.removeSheetAt(1);
		Sheet sheet = workObj.getSheet(sheetName);
		
		int rowCount = 0;
        int columnCount =0;
        
        for(String element : valueToWrite) {
        	Row newRow = createRow(sheet,rowCount++);
			Cell cell = createCell(newRow,columnCount);
			cell.setCellValue(element); 
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