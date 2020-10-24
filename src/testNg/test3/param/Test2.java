package test3.param;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 How to pass values from testng xml to test class?
  1.Write parameter with name and value in xml. 
    <parameter name = "userName" value="admin"/> 
  2.Write @Parameters(value = {"userName"}) before the test method
 
 */
public class Test2 {

	@Test
	@Parameters(value = {"userName", "password"})
	public void test1(@Optional("NA") String myName,String password) {
		System.out.println("test1::username value is : " + myName);
		System.out.println("test1::password value is : " + password);
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
	}

	
}
