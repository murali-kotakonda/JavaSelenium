package test0;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//@BeforeTest : methods under this annotation will be executed prior to the first test case in the TestNG file.
//@AfterTest :methods under this annotation will be executed after all test cases in the TestNG file are executed.
//@BeforeMethod :methods under this annotation will be executed prior to each method in each test case.
//@AfterMethod  :methods under this annotation will be executed after each method in each test case.

/**
@Test - for every test method.
if we have 6 test methods
@Test will execute for 6 times


@BeforeMethod - is executed before every test method. 
if we have 6 test methods, then "@BeforeMethod" will execute for 6 times


@AfterMethod - is executed before after test method.
if we have 6 test methods, then "@AfterMethod" will execute for 6 times


@BeforeTest  - 1 time before every TestClass. 
@AfterTest   - 1 time after every TestClass.


Req:
A test class has
- one @BeforeTest method
- one @AfterTest method
- one  @BeforeMethod method
- one @AfterMethod method
- three @Test  methods

print the order of execution??
o/p:
before Test

before method
In T1
after method


before method
In T2
after method

before method
In T3
after method

after Test
*/

public class Ex16Annotations {

	@BeforeTest
	public static void testBeforeTest() {
		System.out.println("before Test");
	}
	
	@AfterTest
	public static void testafterClass() {
		System.out.println("after Test");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("after method");
	}

	@Test 
	public void T1() {
		System.out.println("In T1");
	}

	@Test 
	public void T2() {
		System.out.println("In T2");
	}

	@Test 
	public void T3() {
		System.out.println("In T3");
	}
}