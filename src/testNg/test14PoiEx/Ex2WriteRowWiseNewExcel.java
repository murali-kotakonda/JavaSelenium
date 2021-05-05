package test14PoiEx;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


//create new excel
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

public class Ex2WriteRowWiseNewExcel {
	
	public static void main(String[] args) throws IOException {
		String[] valueToWrite = { "60000", "Mythri Tech", "25" , "hello","kumar","67" };
		
		//create workbook obj
		File file = new File("C:\\test\\mydata1.xlsx");
		Workbook workObj  = new XSSFWorkbook();
		
		//create sheet
		Sheet sheet = workObj.createSheet("output");	
		
		int rowCount = 0;
	    int columnCount =0;
	    
	    Row newRow = createRow(sheet,rowCount++);
	    
	    //write to cell
	    for(String data : valueToWrite) {
			Cell cell = createCell(newRow,columnCount++);
			cell.setCellValue(data);
	    }
	    
	    //close resources
		FileOutputStream outputStream = new FileOutputStream(file);
		workObj.write(outputStream);
		outputStream.close();
		
		System.out.println("success");
	}

	private static Row createRow(Sheet sheet, int rowCount) {
		Row newRow = sheet.getRow(rowCount);
		if (newRow == null) {
			newRow = sheet.createRow(rowCount);
		}
		return newRow;
	}

	private static Cell createCell(Row row, int columnNo) {
		Cell cell = row.getCell(columnNo);
		if (cell == null) {
			cell = row.createCell(columnNo);
		}
		return cell;
	}
	
}