package test3.param.basics1;
 

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class T4 {
	
	@Test
	@Parameters(value = {"userName","password"})
	public void test4_1(String name,String password) {
		System.out.println("In test4_1 with "+ name + " - "+ password);
	}

	@Test
	@Parameters(value = {"userName","password"})
	public void test4_2(String name,String password) {
		System.out.println("In test4_2 with "+ name + " - "+ password);
	}

}
