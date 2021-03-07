package pom.pages;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataFromExel{
	public static void main(String args[]) throws IOException{
	 
	//@DataProvider(name = "UserData")
	// public static Object[][] readExcel() throws InvalidFormatException, IOException {
		String filePath = "D:\\TestData.xlsx";
		 String sheetName = "Sheet1";
         FileInputStream file= new FileInputStream(filePath);
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
                 System.out.println(val);
             }
         }
         System.out.println(data);
		//return data;
	 }
	
	/*@Test(dataProvider = "UserData")
	  public void read(String username, String password) {
		  System.out.println(username + ":" + password);
	  }*/
}