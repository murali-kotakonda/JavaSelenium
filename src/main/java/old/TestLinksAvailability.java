package old;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestLinksAvailability {
	 private static WebDriver driver = null;
	 	
	 @Test
	    public void linkTest() {
	        driver =DriverUtils.getDriver();
	        
	        driver.manage().window().maximize();
	        
	        driver.get("");
	        
	        
	        List<String> linkTexts = Arrays.asList("Employee,MyProfile,Department,Add New Employee");
	        
	        List<WebElement> links = driver.findElements(By.tagName("a"));
	        for(WebElement element: links){
	        	//String attribute = element.getAttribute("href");
	        	String text = element.getText();
	        	Assert.assertTrue("misisng link "+text,linkTexts.contains(text));
	       
	        	testLinkWorking(element);
	        }
	        
	        driver.quit();

	    }

	private void testLinkWorking(WebElement it) {
		   String url = it.getAttribute("href");
		   HttpURLConnection huc = null;
	        int respCode = 200;
	     
		    System.out.println(url);
		
		    Assert.assertTrue("Link url is missing..",url != null && !url.isEmpty());
		    
		    Assert.assertTrue("Link domain is wrong is missing..",url.startsWith("http://localhost:9090/Employee"));
		    
		    try {
		        huc = (HttpURLConnection)(new URL(url).openConnection());
		        
		        huc.setRequestMethod("HEAD");
		        
		        huc.connect();
		        
		        respCode = huc.getResponseCode();
		        
		        Assert.assertTrue("Link not working..",respCode==200);
		        
		    } catch (MalformedURLException e) {
		    } catch (IOException e) {
		    }
	}
}
