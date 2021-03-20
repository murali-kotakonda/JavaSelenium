package testhybrid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import keyword.ex1.Action;
import keyword.ex1.KeyDrivenExcelUtils;
import keyword.ex2.KeyWordUtil;
import util.Commons;

public class TestLogin2 {

	KeyWordUtil keyword;
	KeyDrivenExcelUtils utils ;
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
	
	@Test(dataProvider = "hybridData")
	public void performLogin(TestCase testCase) throws IOException, InterruptedException {
		for(Action action: testCase.getActions())
			keyword.perform(action);
	}
}