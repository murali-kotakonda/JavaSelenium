package parameter;
 

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class T3 {
	
	@BeforeMethod
	@Parameters(value = {"userName","password"})
	public void before(String name,String password) {
		System.out.println(name);
		System.out.println(password);
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
