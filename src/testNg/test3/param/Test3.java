package test3.param;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test3 {

	@Parameters("url")
	@BeforeMethod
	public void before(String url) {
		System.out.println(url);
	}
	
	/*
	 * @BeforeMethod
	 * 
	 * @Parameters(value = {"userName", "password"}) public void before(String
	 * myName,String password) { System.out.println("befor class value is : " +
	 * myName); System.out.println("before class value is : " + password); }
	 */	

	
	@Test
	@Parameters(value = {"userName", "password"})
	public void t1(String myName,String password) {
		System.out.println("userName  : " + myName);
		System.out.println("password   : " + password);
	}
	
	@Test
	public void t2() {
		System.out.println("T2 running");
	}
}
