package support;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static File getFile(MillsListResponse response)
			throws IOException, FileNotFoundException {
		List<MillListEntity> list = response.getMillListEntities();
		File file = new File("C:\\data.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		
		//create workbook
		Workbook workObj  = new XSSFWorkbook(inputStream);
		
		//create sheet
		Sheet sheet = workObj.getSheet("output");
		
		int rowCount = 0;
        int columnCount =0;
        String[] columnNames = {"All quater","Country","Latitude","Longitude","MillClassification",
        		"MillName","ParentCompany", "SeqNo" ,"StateOrProvience" , "SuspendedMill",
        		"UmlId"};
        Row row = createRow(sheet,rowCount++);
        for(String column : columnNames) {
        	writeData(row,column,columnCount++);
        }
        //write to cell
        for(MillListEntity entity : list) {
        	Row newRow = createRow(sheet,rowCount++);
        	columnCount=0;
        	writeData(newRow,entity.getAllQuarter(),columnCount++);
        	writeData(newRow,entity.getCountry(),columnCount++);
        	writeData(newRow,entity.getLatitude(),columnCount++);
        	writeData(newRow,entity.getLongitude(),columnCount++);
        	writeData(newRow,entity.getMillClassification(),columnCount++);
        	writeData(newRow,entity.getMillName(),columnCount++);
        	writeData(newRow,entity.getParentCompany(),columnCount++);
        	writeData(newRow,entity.getSeqNo(),columnCount++);
        	writeData(newRow,entity.getStateOrProvience(),columnCount++);
        	writeData(newRow,entity.getSuspendedMill(),columnCount++);
        	writeData(newRow,entity.getUmlId(),columnCount++);
        }
       
        //close resources
        inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		workObj.write(outputStream);
		outputStream.close();
		
		return file;
	}
	
	private static void writeData(Row newRow,String column, int columnCount) {
		Cell cell = createCell(newRow,columnCount);
		cell.setCellValue(column); 
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
