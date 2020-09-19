package test14PoiReqEx;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

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
		for (int r = 0; r <= rowCount; r++) {
			Row row = sheetObj.getRow(r);
			Cell cell = row.getCell(0);
			columns.add(cell.getStringCellValue().toUpperCase());
		}
		return columns;
	}

	public static void writeExcel(String filePath, String fileName, String sheetName, Map<String, List<String>> map)
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

		workObj.removeSheetAt(1);
		Sheet sheet = workObj.createSheet(sheetName);
		int rowCount = 0;
		int columnCount = 0;
		for (Entry<String, List<String>> entry : map.entrySet()) {
			Row newRow = createRow(sheet, rowCount++);
			Cell cell = createCell(newRow, columnCount);
			cell.setCellValue("Missing columns from :" + entry.getKey());

			for (String data : entry.getValue()) {
				newRow = createRow(sheet, rowCount++);
				cell = createCell(newRow, columnCount);
				cell.setCellValue(data);
			}
			rowCount = 0;
			columnCount = 1;

		}

		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		workObj.write(outputStream);
		outputStream.close();
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