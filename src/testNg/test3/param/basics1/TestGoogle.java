package test3.param.basics1;

 
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test1.MyBaseTest;

public class TestGoogle extends MyBaseTest{

	@Test 
	@Parameters(value = {"url"})
	public void test1(String url) throws InterruptedException {
		driver.get(url);
		Thread.sleep(3000);
	}

}
