package test1;



/**
  A test class :
- has some test methods has priority
- some test methods does not has priority

what is the order of execution?
solution?
1)1st preference is given to test method that does not have priority.
2)2nd  preference is given to test method that  has priority.

Explanation:
First preference: Non-prioritized methods:
Second preference: Prioritized methods

 */

import org.testng.annotations.Test;

public class Ex15PriorityAndNonPrio {
	
	@Test
	public void c_method() {
		System.out.println("I'm in method C");
	}

	@Test
	public void b_method() {
		System.out.println("I'm in method B");
	}

	@Test(priority = 1)
	public void a_method() {
		System.out.println("I'm in method A");
	}

	@Test(priority = 3)
	public void e_method() {
		System.out.println("I'm in method E");
	}

	@Test(priority = 2)
	public void d_method() {
		System.out.println("I'm in method D");
	}
}
