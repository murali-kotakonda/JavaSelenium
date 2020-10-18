package test1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

 
/**
  understand @BeforeMethod , @AfterMethod , @Test.
 */
public class Ex10 {
	
	@BeforeMethod
	public void setup() {
		System.out.println("before method :: setup");
	}
	
	@AfterMethod
	public void close() {
		System.out.println("after method:: close");
	}
	
	@Test
	public void t1() {
		System.out.println("in t1");
	}
	
	@Test
	public void t2() {
		System.out.println("in t2");
	}
	
	@Test
	public void t3() {
		System.out.println("in t3");
	}
}
