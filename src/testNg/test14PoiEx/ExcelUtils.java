package test14PoiEx;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
Excel:
---------
For working with excel we need the "apache poi" dependency in the pom.xml



 .xls   -> Old excel
 .xlsx  -> New Excel 
 
 
 Order of objects:
-------------------
1.WorkBook Obj
2.Sheet Obj
3.Row
4.Cell obj


How to create workbook obj:
----------------------------------
1.for old excel .xls 
WorkBook fileObj = new HSSFWorkbook();

2. New excel .xlsx
WorkBook fileObj = new XSSFWorkbook();

How to get workbook obj for existing excel file?
----------------------------------------------------
Workbook fileObj = new XSSFWorkbook(new FileInputStream("<path>//Inputdata.xlsx"));
	

to get no of sheets
--------------------------
int numberOfSheets = fileObj.getNumberOfSheets();




create sheet object:
---------------------------------
Sheet sheetObj = fileObj.createSheet("data");

get the 1st sheet
--------------------------------------
Sheet sheetObj = fileObj.getSheetAt(0);


get the sheet by name
--------------------------------------
Sheet sheetObj = fileObj.getSheet("output");



How to create  row object:
--------------------------
Row row= sheetObj.createRow(<row nunm>);


How to get row object:
--------------------------
Row row = sheetObj.getRow(<row num>);


How to create cell object:
--------------------------
row.createCell(<cell num>);

How to get cell:
---------------------------
Cell cell = row.getCell(<cell num>);



How to write data to cell?
----------------------------
cell.setCellValue(<data>);

How to read cell value?
-------------------------
String d =cell.getStringCellValue();
Date dateCellValue = cell.getDateCellValue();
double numericCellValue = cell.getNumericCellValue();

How to get all row nums?
--------------------------
//how to get all rows
int rowCount = sheetObj.getLastRowNum() - sheetObj.getFirstRowNum();


How to get all column nums?
--------------------------
int cells = row.getLastCellNum() - row.getFirstCellNum();
*/

public class ExcelUtils {

	public static void main(String[] args) throws IOException {
		List<String> excelColumns = ExcelUtils.getExcelColumns("C:\\test", "Inputdata.xlsx");
		
		for(String c: excelColumns) {
			System.out.println(c);
		}
	}

	public static List<String> getExcelColumns(String filePath, String fileName) throws IOException {
		FileInputStream inputStream = new FileInputStream(filePath + "\\" + fileName);
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		List<String> columns = new ArrayList<>();

		Workbook fileObj = null;
		if (fileExtensionName.equals(".xlsx")) {
			fileObj = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {
			fileObj = new HSSFWorkbook(inputStream);
		}
		
		Sheet sheetObj = fileObj.getSheetAt(0);
		int rowCount = sheetObj.getLastRowNum() - sheetObj.getFirstRowNum();
		for(int r=0;r<=rowCount;r++) {
			Row row = sheetObj.getRow(r);
			Cell cell = row.getCell(0);
			columns.add(cell.getStringCellValue().toUpperCase());
			
		}
		return columns;
	}
}