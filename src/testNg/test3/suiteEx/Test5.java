package test3.suiteEx;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test5 {
		// test case 1
		@Test
		public void testCase1() {
			System.out.println("in test cOase 1");
		}

		// test case 2
		@Test
		public void testCase2() {
			System.out.println("in test case 2");
		}

		
		@Test 
		public void m1() {
			System.out.println("in test case 3");
		}

		@Test 
		public void m2() {
			System.out.println("in test case 3");
		}
		
}
