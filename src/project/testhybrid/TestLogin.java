package testhybrid;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import keyword.ex1.Action;
import keyword.ex1.KeyDrivenExcelUtils;
import keyword.ex2.KeyWordUtil;
import util.Commons;

/**
  Hybrid framework : DataDriven + Keyword Driven
  
  using the getDataFromDataprovider() fetch the Object[][] , each entry has one action object
  
 */
public class TestLogin {

	private KeyWordUtil keyword;
	
	private KeyDrivenExcelUtils utils ;
	
	private String excelFilePath = "C:\\test\\keywords2.xlsx";
	
	@BeforeTest
	public void setup() {
		keyword = new KeyWordUtil(Commons.getDriver());
		utils = new KeyDrivenExcelUtils(excelFilePath);
	}

	@AfterTest
	public void close() {
		keyword.close();
	}
	
	@DataProvider(name="testData")
	public Object[][] getDataFromDataprovider() throws IOException{
    	List<Action> testcases = utils.getActions();
    	Object[][] objects = new Object[testcases.size()][1];
		int i = 0;
		for (Action action : testcases) {
			objects[i++][0] = action;
		}
		return objects;
	}
	
	@Test(dataProvider = "testData")
	public void performLogin(Action action) throws IOException, InterruptedException {
		if(!action.getKeyword().contains("TEST_CASE"))
			keyword.perform(action);
	}
}