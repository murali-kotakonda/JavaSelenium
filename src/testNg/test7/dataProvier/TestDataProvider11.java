package  test7.dataProvier;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
public class TestDataProvider11 {

	@Test(dataProvider = "test1",dataProviderClass = TestDataProvider1.class)
	public void testData(String name) {
		System.out.println(name );
	}
}
