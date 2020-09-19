package test2.suiteEx;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test41 {
	public class TestngAnnotation {
		// test case 1
		@Test
		public void testCase41() {
			System.out.println("in test case 1");
		}

		// test case 2
		@Test
		public void testCase41_2() {
			System.out.println("in test case 2");
		}

		
		@Test(enabled = false) // then the test case that is not ready to test is bypassed
		public void testCase41_3() {
			System.out.println("in test case 3");
		}

		@BeforeMethod
		public void beforeMethod41() {
			System.out.println("in beforeMethod");
		}

		@AfterMethod
		public void afterMethod41() {
			System.out.println("in afterMethod");
		}

		@BeforeClass
		public void beforeClass41() {
			System.out.println("in beforeClass");
		}

		@AfterClass
		public void afterClass41() {
			System.out.println("in afterClass");
		}

		@BeforeTest
		public void beforeTest41() {
			System.out.println("in beforeTest");
		}

		@AfterTest
		public void afterTest41() {
			System.out.println("in afterTest");
		}

		@BeforeSuite
		public void beforeSuite41() {
			System.out.println("in beforeSuite");
		}

		@AfterSuite
		public void afterSuite41() {
			System.out.println("in afterSuite");
		}
	}
}
