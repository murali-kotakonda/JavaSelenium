package  test7.dataProvier;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 Dataprovider:
---------------
Req:
test the same test case with multiple and different data
assume we need to test for 100 times

 will you write 100 test cases?
 will you run the test case using a loop?
 
 
ex: search in google , but every time with different data

solution: 
- use data provider

providing the custom data to the test-case

impact:
----------
the test case will run based on the no of data you provide
   
 
changes:
-----------
1.provide a dataprovider method that returns Object[][] that contains the different data to be tested.
2.How to pass dataprovider  to the test case


1.write a method that provides the data
  
  @DataProvider(name = "myData")
	public static Object[][] data() {
		return new Object[][] {
			{ "admin1" }, 
			{ "admin2" }, 
			{ "admin3" }, 
			{ "admin4" },
			{ "admin5" } };
	}
  
2.How to pass data to the test case
  @Test(dataProvider = "myData")
	public void testData(String name) {
		System.out.println(name );
	}
	
 */
public class TestDataProvider1 {

	@DataProvider(name = "test1")
	public static Object[][] data() {
		return new Object[][] {
			{ "admin1" }, 
			{ "admin2" }, 
			{ "admin3" }, 
			{ "admin4" },
			{ "admin5" } };
	}

	@Test(dataProvider = "test1")
	public void testData(String name) {
		System.out.println(name );
	}
}
