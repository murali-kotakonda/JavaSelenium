package test3.param;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test7 {

	@Test
	@Parameters(value = {"P3", "P4"})
	public void parameterTest(String myName,String password) {
		System.out.println("Parameterized value is : " + myName);
		System.out.println("Parameterized value is : " + password);
	}
}
