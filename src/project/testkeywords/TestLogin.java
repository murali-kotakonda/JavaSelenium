package testkeywords;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Commons;

public class TestLogin {

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
		List<Action> actions = utils.getActions();
		for(Action action : actions) {
			if(!action.getKeyword().contains("TEST_CASE#")) {
				System.out.println(action.getDescription());
				keyword.perform(action);
			}else {
				System.out.println(action.getKeyword() +" started");
			}
		}
	}
}