package support;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static String[] footerMsgs = { "Note:", 
			"* Mills that have been struck off from our mill list are those which our suppliers reflect in their submitted list, however have been suspended from our supply chain. We will continue to reflect these changes as they get updated", 
			"** Direct suppliers: Cargill contracts directly with the mill.",
			"** Indirect suppliers: Cargill does not contract with the mill. Instead, Cargill sources from the mill through an intermediary. Cargill’s contractual relationship is with the intermediary (e.g. a third-party crusher,refinery or another trader).",
			"Cargill works hard to ensure that action is taken to remove suspended mills from your supply chain. It can take time for this to be reflected in your supply chain data due to existing contracts and/or traceability reporting cycles of our suppliers.",
			"If you have further questions on enquires about suspended mills, please reach out to your Cargill Sustainability contact. please reach out to your Cargill Sustainability contact."};

	static String[] columnNames = { "No", "Parent Company", "Mill Name", "Country", "State/Province", "Latitude",
			"Longitude", "UML ID", "Mill Classification**", "Quarter" };
	
	static int[] columnWidths = { 7,25,12,12,12,12,12,12,12,12 };
	
	public static File getFile(MillsListResponse response) throws IOException, FileNotFoundException {
		List<MillListEntity> list = response.getMillListEntities();

		// create workbook
		Workbook workObj = new XSSFWorkbook();

		// create sheet
		Sheet sheet = workObj.createSheet("output");
		int rowCount = 0;
		int columnCount = 0;
		
		for ( int i = 0; i < columnWidths.length; i++) {
			sheet.setColumnWidth(i, columnWidths[i]*256);
		}
		
		//write headers
		Row row = createRow(sheet, rowCount++);
		for (String column : columnNames) {
			writeBoldData(row, column, columnCount++);
		}

		//write rows
		int i = 1;

		for (MillListEntity entity : list) {
			Row newRow = createRow(sheet, rowCount++);
			columnCount = 0;
			writeData(newRow, (i++), columnCount++);
			writeData(newRow, entity.getParentCompany(), columnCount++);
			writeData(newRow, entity.getMillName(), columnCount++);
			writeData(newRow, entity.getCountry(), columnCount++);
			writeData(newRow, entity.getStateOrProvience(), columnCount++);
			writeData(newRow, entity.getLatitude(), columnCount++);
			writeData(newRow, entity.getLongitude(), columnCount++);
			writeData(newRow, entity.getUmlId(), columnCount++);
			writeData(newRow, entity.getMillClassification(), columnCount++);
			writeData(newRow, entity.getAllQuarter(), columnCount++);
		}
		writeData(createRow(sheet, rowCount++), "",0);
		
		//write footer
		for(String footerMsg : footerMsgs) {
			Row newRow = createRow(sheet, rowCount++);
			writeBoldData(newRow, footerMsg, 0);
		}
		
		FileOutputStream outputStream = new FileOutputStream("data.xlsx");
		workObj.write(outputStream);
		outputStream.close();

		File file = new File("data.xlsx");
		return file;
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
	
	private static void writeData(Row newRow, Object column, int columnCount) {
		Cell cell = createCell(newRow, columnCount);
		if (column instanceof String) {
            cell.setCellValue((String) column);
        } else if (column instanceof Integer) {
            Workbook workbook = newRow.getSheet().getWorkbook();
            
            
            
    		CellStyle cellStyle = workbook.createCellStyle();
    	    cellStyle.setAlignment(HorizontalAlignment.LEFT);
    	    
    	    // fill foreground color ...
    	    cellStyle.setFillForegroundColor(IndexedColors.RED.index);
            // and solid fill pattern produces solid grey cell fill
    	    cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    	    
    	    cell.setCellValue((Integer) column);
        	cell.setCellStyle(cellStyle);
        }
	}
	
	private static void writeBoldData(Row newRow, String column, int columnCount) {
		Workbook workbook = newRow.getSheet().getWorkbook();
		CellStyle cellStyle = workbook.createCellStyle();
	    Font font = workbook.createFont();
	    font.setBold(true);
	    cellStyle.setFont(font);
	    cellStyle.setAlignment(HorizontalAlignment.LEFT);
	    
		Cell cell = createCell(newRow, columnCount);
		cell.setCellValue(column);
		cell.setCellStyle(cellStyle);
	}

}
