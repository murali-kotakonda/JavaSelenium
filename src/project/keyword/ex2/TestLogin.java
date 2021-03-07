package keyword.ex2;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import keyword.ex1.Action;
import keyword.ex1.ExcelUtils;
import util.Commons;

public class TestLogin {

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
	
	@Test
	public void performLogin() throws IOException, InterruptedException {
		List<Action> testcases = utils.getActions();
		for(Action testCase : testcases) {
			if(!testCase.getKeyword().contains("TEST_CASE#")) {
				keyword.perform(testCase);
			}else {
				System.out.println(testCase.getKeyword() +" started");
			}
		}
	}
}