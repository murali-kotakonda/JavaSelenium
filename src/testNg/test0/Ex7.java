package test0;

import org.testng.annotations.Test;
 
/**
   By default, methods annotated by @Test are executed alphabetically . 
   - if priority is specified for every test method then the methods are executed in the order of the priority.
   - if two methods has the same priority then methods are executed in the alphabetical order of the method name.
 */
public class Ex7 {
	
	@Test(priority = 1)
	public void test3() {
		System.out.println("running test3");
	}
	
	@Test(priority = 2)
	public void test1() {
		System.out.println("running test1");
	}
	
	@Test(priority = 3)
	public void test2() {
		System.out.println("running test2");
	}
	
	@Test(priority = 1)
	public void test0() {
		System.out.println("running test0");
	}
	
	@Test(priority = 1)
	public void abc() {
		System.out.println("running abc");
	}
}
