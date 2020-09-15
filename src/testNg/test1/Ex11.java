package test1;

import org.testng.annotations.Test;

// By default, methods annotated by @Test are executed alphabetically. 
public class Ex11 {
		@Test
		public void One() {
			System.out.println("This is the Test Case number One");
		}

		@Test
		public void Two() {
			System.out.println("This is the Test Case number Two");
		}

		@Test
		public void Three() {
			System.out.println("This is the Test Case number Three");
		}

		@Test
		public void Four() {
			System.out.println("This is the Test Case number Four");
		}
}
