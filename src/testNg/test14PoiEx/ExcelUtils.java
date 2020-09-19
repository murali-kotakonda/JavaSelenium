package test14PoiEx;

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

public class ExcelUtils {

	public static void main(String[] args) throws IOException {
		ExcelUtils readObj = new ExcelUtils();
		String filePath = "C:\\Project\\";
		List<String> readExcel = readObj.getExcelColumns(filePath, "Inputdata.xlsx");
		for(String s:readExcel) {
			System.out.println(s);
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