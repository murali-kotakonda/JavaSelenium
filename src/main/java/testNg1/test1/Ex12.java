package testNg1.test1;

import org.testng.annotations.Test;

// By default, methods annotated by @Test are executed alphabetically. 
public class Ex12 {

		@Test
		public void test1() {
			System.out.println("test1");
		}

		@Test
		public void test5() {
			System.out.println("test5");
		}

		@Test
		public void test3() {
			System.out.println("test3");
		}

		@Test
		public void test2() {
			System.out.println("test2");
		}
}
