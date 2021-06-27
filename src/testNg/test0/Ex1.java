package test0;

import org.testng.annotations.Test;

/**
 How to write a test case?
 ans)
 use testng Annotation @Test and write a method
 
 In TestNg the method that has @Test is eligible for running.
 
 */
 
public class Ex1 {

	@Test
	public void test1() {
		System.out.println("running test1");
	}
	
	@Test
	public void test2() {
		System.out.println("running test2");
	}
	
	@Test
	public void test3() {
		System.out.println("running test3");
	}
}
