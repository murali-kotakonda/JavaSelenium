package test1;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex3PriorityAndNonPrio {
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
	public WebDriver driver;

	/*Explanation:

		First preference: Non-prioritized methods: ‘c’ and ‘b’: Based on alphabetical order ‘b’ was executed first and then ‘c’.

		Second preference: Prioritized methods: ‘a’, ‘e’ and ‘d’: ‘e’ was executed first as it was having highest priority(0). As the priority of ‘a’ and ‘d’ methods were same, testng considered the alphabetical order of their methods names. So, between them, ‘a’ was executed first and then ‘d’.
		*/
	
	@Test
	public void c_method() {
		System.out.println("I'm in method C");
	}

	@Test
	public void b_method() {
		System.out.println("I'm in method B");
	}

	@Test(priority = 6)
	public void a_method() {
		System.out.println("I'm in method A");
	}

	@Test(priority = 0)
	public void e_method() {
		System.out.println("I'm in method E");
	}

	@Test(priority = 6)
	public void d_method() {
		System.out.println("I'm in method D");
	}
}
