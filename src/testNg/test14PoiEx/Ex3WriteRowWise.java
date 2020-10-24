package test14PoiEx;

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

     
For row wise:
---------------------
for(String element : valueToWrite) {
     	Row newRow = createRow(sheet,rowCount++);
			Cell cell = createCell(newRow,columnCount);
			cell.setCellValue(element); 
}



For column wise:
----------------
Row newRow = createRow(sheet,rowCount++);
for(String element : valueToWrite) {
        	Cell cell = createCell(newRow,columnCount++);
				  cell.setCellValue(element); 
}

 */
public class Ex3WriteRowWise {
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
        for(String element : valueToWrite) {
        	Row newRow = createRow(sheet,rowCount++);
			Cell cell = createCell(newRow,columnCount);
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