package suiteEx;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test5 {
	
		// test case 1
		@Test
		public void t5() {
			System.out.println("Test5:in test case 1");
		}

		@BeforeClass
		public void beforeClass41() {
			System.out.println("Test5:in beforeClass");
		}

		@AfterClass
		public void afterClass41() {
			System.out.println("Test5:in afterClass");
		}

		@BeforeTest
		public void beforeTest41() {
			System.out.println("Test5:in beforeTest");
		}

		@AfterTest
		public void afterTest41() {
			System.out.println("Test5:in afterTest");
		}

		@BeforeSuite
		public void beforeSuite41() {
			System.out.println("Test5:in beforeSuite");
		}

		@AfterSuite
		public void afterSuite41() {
			System.out.println("Test5:in afterSuite");
		}
}
