package test1;

import org.testng.annotations.Test;

/**
  Open browser 
  - open  yahoo
  - open google
  - open amazon
 */
public class Ex11CommonDriverWithInheritence2 extends common.BaseTest{ 
	
	@Test
	public void verifyYah() {
		driver.get("https://www.yahoo.com");
	}
	
	@Test
	public void verifyGoogle() {
		driver.get("https://www.google.com");
	}
	
	@Test
	public void verifyAmozon() {
		driver.get("https://www.amazon.com");
	}

}
