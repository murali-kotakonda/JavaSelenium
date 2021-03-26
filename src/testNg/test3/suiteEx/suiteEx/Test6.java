package suiteEx;


import org.testng.annotations.Test;

/**
 How to run only selected test methods?
 solution)
 write the following tags in testng.xml
      <methods>  
			<include name="test.*"/>  
		</methods> 


How to exlude run for selected test methods?
 solution)
 write the following tags in testng.xml
      <methods>  
			<exclude name="test.*"/>  
		</methods> 
 */
public class Test6 {
		// test case 1
		@Test
		public void testCase1() {
			System.out.println("in test case 1");
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
