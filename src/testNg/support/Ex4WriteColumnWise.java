package support;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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
60000    Mythri Tech   25   Hello

 */
public class Ex4WriteColumnWise {
	
	public static void main(String... strings) throws IOException {
		String[] valueToWrite = { "60000", "Mythri Tech", "25" , "hello" };
		File file = new File("C:\\test\\data.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		
		//create workbook
		Workbook workObj  = new XSSFWorkbook(inputStream);
		
		//create sheet
		Sheet sheet = workObj.getSheet("output");
		
		int rowCount = 0;
        int columnCount =0;
        
        //write to cell
        Row newRow = createRow(sheet,rowCount++);
        for(String element : valueToWrite) {
        	Cell cell = createCell(newRow,columnCount++);
			cell.setCellValue(element); 
        }
        //close resources
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