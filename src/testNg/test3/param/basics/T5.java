package parameter;
 

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class T5 {
	
	@Test
	@Parameters(value = {"username"})
	public void test5_1(String name) {
		System.out.println("In test5_1 with "+ name);
	}

	@Test
	@Parameters(value = {"username"})
	public void test5_2(String name) {
		System.out.println("In test5_2 with "+ name);
	}

}
