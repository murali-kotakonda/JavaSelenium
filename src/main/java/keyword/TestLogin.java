package keyword;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
	
	@Test
	public void performLogin() throws IOException, InterruptedException {
		List<Action> actions = utils.getActions();
		for(Action action : actions) {
			if(!action.getKeyword().contains("TEST_CASE#")) {
				keywordUtil.perform(action);	
			}else {
				System.out.println("Test case started :"+ action.getDescription());
			}
		}
	}
	}

