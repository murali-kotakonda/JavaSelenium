package hybrid;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.Commons;
import keywords.Action;
import keywords.ExcelUtils;
import keywords2.KeyWordUtil;

public class Login {

	KeyWordUtil keyword;
	ExcelUtils utils ;
	private String excelFilePath = "C:\\test\\keywords2.xlsx";
	
	@BeforeTest
	public void setup() {
		keyword = new KeyWordUtil(Commons.getDriver());
		utils = new ExcelUtils(excelFilePath);
	}

	@AfterTest
	public void close() {
		keyword.close();
	}
	
	@DataProvider(name="hybridData")
	public Object[][] getDataFromDataprovider() throws IOException{
    	List<Action> testcases = utils.getTestCases();
    	Object[][] objects = new Object[testcases.size()][1];
		int i = 0;
		for (Action action : testcases) {
			objects[i++][0] = action;
		}
		return objects;
	}
	
	@Test(dataProvider = "hybridData")
	public void performLogin(Action testCase) throws IOException, InterruptedException {
		if(!testCase.getTestStep().contains("TEST_CASE"))
		keyword.perform(testCase);
	}
}