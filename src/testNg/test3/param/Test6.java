package test3.param;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test6 {

	@Test
	@Parameters(value = {"P1", "P2"})
	public void parameterTest(String myName,String password) {
		System.out.println("Parameterized value is : " + myName);
		System.out.println("Parameterized value is : " + password);
	}
}
