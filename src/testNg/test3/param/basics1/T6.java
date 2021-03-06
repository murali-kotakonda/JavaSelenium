package test3.param.basics1;
 

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class T6 {
	
	@Test
	@Parameters(value = {"url"})
	public void test6_1(String url) {
		System.out.println("In test6_1 with "+ url);
	}

	@Test
	@Parameters(value = {"url"})
	public void test6_2(String url) {
		System.out.println("In test6_2 with "+ url);
	}

}
