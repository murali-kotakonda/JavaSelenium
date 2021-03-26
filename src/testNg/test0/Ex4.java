package test0;

import org.testng.annotations.AfterClass;
  

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 /**
How to skip the test case?
use @Test(enabled = false) before the test method
 */
public class Ex4 {
	
	@Test
	public void test1() {
		System.out.println("running test1");
	}
	
	@Test(enabled = false)
	public void test2() {
		System.out.println("running test2");
	}
	
	@Test
	public void test3() {
		System.out.println("running test3");
	}
}
