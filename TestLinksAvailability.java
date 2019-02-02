package project;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import util.DriverUtils;

public class TestLinksAvailability {
	 private static WebDriver driver = null;
	 	
	 @Test
	    public void linkTest() {
	        driver =DriverUtils.getDriver();
	        
	        driver.manage().window().maximize();
	        
	        driver.get("");
	        
	        List<WebElement> links = driver.findElements(By.tagName("a"));
	        List<String> linkText = Arrays.asList("");
	        for(WebElement element: links){
	        	String attribute = element.getAttribute("href");
	        	String text = element.getText();
	        	Assert.assertTrue("misisng link "+text,linkText.contains(text));
	       
	        	testLinkWorking(element);
	        }
	        
	        
	        driver.quit();

	    }

	private void testLinkWorking(WebElement it) {
		   String url = it.getAttribute("href");
		   HttpURLConnection huc = null;
	        int respCode = 200;
	     
		    System.out.println(url);
		
		    if(url == null || url.isEmpty()){
		    	System.out.println("URL is either not configured for anchor tag or it is empty");
		        return;
		    }
		    
		    if(!url.startsWith("baseurl")){
		        System.out.println("URL belongs to another domain, skipping it.");
		        return;
		    }
		    
		    try {
		        huc = (HttpURLConnection)(new URL(url).openConnection());
		        
		        huc.setRequestMethod("HEAD");
		        
		        huc.connect();
		        
		        respCode = huc.getResponseCode();
		        
		        if(respCode >= 400){
		            System.out.println(url+" is a broken link");
		        }
		        else{
		            System.out.println(url+" is a valid link");
		        }
		            
		    } catch (MalformedURLException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
	}
}
