package testNg1.test14Poi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteRowWise {
	public static void main(String... strings) throws IOException {
		String[] valueToWrite = { "60000", "Mythri Tech", "25" , "hello" };
		WriteRowWise objExcelFile = new WriteRowWise();
		String filePath = "C:\\Project";
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