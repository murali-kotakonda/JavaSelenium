package test0;

import org.testng.annotations.Test;
 
/**
  How to specify the priority for the test method?
  solution)
  write @Test(priority = 4) before the method
  priority value should start from 0 to infinity.
  
   By default, methods annotated by @Test are executed alphabetically . 
    if priority is specified for every test method then the methods are executed in the order of the priority.
 */

    /**
 
 How to specify the priority for the test method?
- write @Test(priority = 4) before the method
  priority value should start from 0 to infinity.
   
   @Test(priority = 4)
   public void test2() {
	  System.out.println("test2");
   }
   
    By default, methods annotated by @Test are executed alphabetically . 
    if priority is specified for every test method then the methods are executed in the order of the priority.
    
 */

    
public class Ex6 {
	
	@Test(priority = 1)
		public void test1() {
			System.out.println("in test1");
		}

		@Test(priority = 2)
		public void test5() {
			System.out.println("in test5");
		}

		@Test(priority = 3)
		public void test3() {
			System.out.println("in test3");
		}

		@Test(priority = 4)
		public void test2() {
			System.out.println("in test2");
		}
}
