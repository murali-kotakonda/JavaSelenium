package test0;

/**
By default, methods annotated by @Test are executed alphabetically . 

if priority is specified for every test method then the methods are executed in the order of the priority.
- if two methods has the same priority then methods are executed in the alphabetical order of the method name.

*/
import org.testng.annotations.Test;


public class Ex14Priority {

		@Test(priority = 1)
		public void apple() {
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

		@Test(priority = 1)
		public void boycott() {
			System.out.println("in test2");
		}
}
