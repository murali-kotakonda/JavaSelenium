package old.framework;

import org.openqa.selenium.WebDriver;

public class Test extends Page{
	
	static Registration rg;
	static Page pg;
	
	
	public static Page page;
	
	static WebDriver driver;
	

	public static void main(String[] args) throws InterruptedException {
		
		rg = new Registration();
		rg.registration();
		
		page.setup();
		driver = Page.driver;
		driver.get(page.reg_Url);
		waiting();

	}

}
