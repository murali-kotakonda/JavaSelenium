package testkeywords;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Commons;

public class Login {

	KeyWordUtil keyword;
	ExcelUtils utils ;
	private String excelFilePath = "C:\\test\\keywords.xlsx";
	
	@BeforeTest
	public void setup() {
		keyword = new KeyWordUtil(Commons.getDriver());
		utils = new ExcelUtils(excelFilePath);
	}

	@AfterTest
	public void close() {
		keyword.close();
	}
	
	@Test
	public void performLogin() throws IOException, InterruptedException {
		List<Action> testcases = utils.getTestCases();
		for(Action testCase : testcases) {
			if(!testCase.getTestStep().contains("TEST_CASE#")) {
				keyword.perform(testCase);
			}else {
				System.out.println(testCase.getTestStep() +" started");
			}
		}
	}
}