package test3.param;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test2 {

	@Test
	@Parameters(value = {"userName", "password"})
	public void test1(String myName,String password) {
		System.out.println("test1::username value is : " + myName);
		System.out.println("test1::password value is : " + password);
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
	}

	
}
