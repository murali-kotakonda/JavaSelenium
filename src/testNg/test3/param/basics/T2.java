package parameter;
 

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class T2 {
	
	@BeforeMethod
	@Parameters(value = {"userName"})
	public void before(String name) {
		System.out.println(name);
	}
	
	@Test
	public void t3() {
		System.out.println("In t3");
	}

	@Test
	public void t4() {
		System.out.println("In t4");
	}

}
