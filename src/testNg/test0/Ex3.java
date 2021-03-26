package test0;

import org.testng.annotations.AfterClass;

/* 
@Test - for every test method.
if we have 6 test methods
@Test will execute for 6 times

 
 @BeforeMethod - is executed before every test method. 
if we have 6 test methods, then "@BeforeMethod" will execute for 6 times

@AfterMethod - is executed before after test method.
if we have 6 test methods, then "@AfterMethod" will execute for 6 times

@BeforeClass - is executed one time before any operation.

@AfterClass - is executed one time after all operations.

 * */

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Ex3 {

	@BeforeClass
	public void beforeclz() {
		System.out.println("In BeforeClass");
	}
	
	@AfterClass
	public void afterclz() {
		System.out.println("In AfterClass");
	}
	
	@BeforeMethod
	public void before() {
		System.out.println("In before");
	}
	
	@AfterMethod
	public void after() {
		System.out.println("in after ");
	}
	
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
/*   
In BeforeClass

In before
running test1
in after 

In before
running test2
in after 

In before
running test3
in after 

In AfterClass

*/