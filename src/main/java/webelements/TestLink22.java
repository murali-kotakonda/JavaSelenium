package webelements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Commons;

public class TestLink22 {

	public static void main(String[] args) {
		//<a href="Test1.html">open for Next page</a><br/>
		//<a href="https://www.gmail.com">click here for next link</a>

		WebDriver driver = Commons.getDriver();
		driver.get(Commons.URL);

		WebElement l1 = driver.findElement(By.linkText("open for Next page"));
		WebElement l2 = driver.findElement(By.partialLinkText("click here"));
		//Commons.checkEnabledanddisplayed("open for Next page", l1);
		//Common.checkEnabledanddisplayed("click here for next link", l2);

		if (!l1.getAttribute("href").endsWith("Test1.html")) {
			System.out.println("invalid url/link for l1");
		}
		if (!l2.getAttribute("href").endsWith("gmail.html")) {
			System.out.println("invalid url/link for l2");
		}

		l2.click();

		if (!driver.getTitle().equals("Google")) { // get the title
			System.out.println("wrong page");
		}
		driver.navigate().back();
		l2 = driver.findElement(By.linkText("click here for next link"));
		l2.click();

		if (!driver.getTitle().equals("page for 3.html")) { // get the title
			System.out.println("wrong page");
		}

		driver.navigate().back();
		
		
		
        List<String> linkTexts = Arrays.asList("open for Next page","click here for next link");
        
        List<WebElement> links = driver.findElements(By.tagName("a"));
        if(links.size()!=2) {
        	System.out.println("invalid no of links");
        }
        
        for(WebElement element: links){
        	String text = element.getText();
        	Assert.assertTrue("misisng link "+text,linkTexts.contains(text));
        	testLinkWorking(element);
        }
		driver.close();

	}
	
	
	private static void testLinkWorking(WebElement it) {
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
