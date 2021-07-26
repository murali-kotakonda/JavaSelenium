package hybrid;

/**
  Hybrid framework : Data Driven + Keyword Driven
  
  using the getDataFromDataprovider() fetch the Object[][] , 
  each entry has one action object
  
  Every test case contains list of actions
  
  Dataprovider :  fetches 4 test case objects
   keeps all the actions inside the test case obj
   pass every test case obj to the test method
  
  KeywordExcelUtils:  --> returns list of action Objects

  KeywordUtils :-------> performs the each action

 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import keyword.Action;
import keyword.KeyDrivenExcelUtils;
import keyword.KeyWordUtil;
import util.Commons;


public class TestLogin {

	KeyWordUtil keywordUtil;
	KeyDrivenExcelUtils utils ;
	
	private String excelFilePath = "C:\\test\\keywords.xlsx";
	
	@BeforeTest
	public void setup() {
		keywordUtil = new KeyWordUtil(Commons.getChromeDriver());
		utils = new KeyDrivenExcelUtils(excelFilePath);
	}

	@AfterTest
	public void close() {
		keywordUtil.close();
	}
	
	//pass testcase obj to test method
	@DataProvider(name="hybridData")
	public Object[][] getDataFromDataprovider() throws IOException{
		List<TestCase>  testCases = getTestCases();
		Object[][] objects = new Object[testCases.size()][1];
		int i = 0;
		for (TestCase testcase : testCases) {
			objects[i++][0] = testcase;
		}
		return objects;
	}

	private List<TestCase>  getTestCases() {
		List<Action> actions = utils.getActions();
		int i = 0;
		List<TestCase> testcases = new ArrayList<>();
		TestCase testCase= null;
		for (Action action : actions) {
			if(action.getKeyword().contains("TEST_CASE")) {
				testCase = new TestCase();
				testcases.add(testCase);
			}
			testCase.add(action);
		}
		return testcases;
	}
	
	//receive the testcase obj
	//test case obj contains multiple actions
	@Test(dataProvider = "hybridData")
	public void performLogin(TestCase testCase) throws IOException, InterruptedException {
		List<Action> actions = testCase.getActions();
		for (Action action : actions) {
			keywordUtil.perform(action);
		}
	}
}
