package pom.pages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	public class Workbook {

		public static void main(String args[]) throws IOException{

			//@DataProvider(name = "UserData")
			//public static void readExcel() throws InvalidFormatException, IOException {
		//public void excel() throws Exception {
				String filePath = "E:\\";           
				 String sheetName = "Sheet1";
		        // FileInputStream file= new FileInputStream(filePath);
					FileInputStream file = new FileInputStream(filePath + "\\" + "Book1.xlsx");

		        // @SuppressWarnings("resource")
				@SuppressWarnings("resource")
				XSSFWorkbook wb = new XSSFWorkbook(file);
		         XSSFSheet sheet = wb.getSheet(sheetName);
		         int rowCount = sheet.getLastRowNum();
		         int column = sheet.getRow(0).getLastCellNum();
		         Object[][] data = new Object[rowCount][column];
		         for (int i = 1; i <= rowCount; i++) {
		             XSSFRow row = sheet.getRow(i);
		             for (int j = 0; j < column; j++) {
		                 XSSFCell cell = row.getCell(j);
		                 DataFormatter formatter = new DataFormatter();
		                 String val = formatter.formatCellValue(cell);
		                 data[i - 1][j] = val;
		                 System.out.println(cell);
		             }
		         }	
		}
						

	}
