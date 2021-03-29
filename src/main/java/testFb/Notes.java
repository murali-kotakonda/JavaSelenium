package testFb;

/**

Using selenium we need to work on web page elements.
Steps:
------------
1.get the web element object for the page element using driver.

How to get web element objects:
-----------------------------------------
depends on the html code of the page element.

in selenium locating the web element we have following Options:
------------------------------------------------------------------
1.By Id
2.By name
3.By Tag name
4.By partial Tag
5.By xpath
6.By css
7.By class name

findElement() 
– finds a single web element and returns as a WebElement object.
- Find Element command throws NoSuchElementException if it does not find the element matching the criteria.
- Find Element command returns the web element that matches the first most element within the web page

findElements() – returns a list of WebElement objects matching the locator criteria.
- Find Elements command returns a list of web elements that match the criteria.
- Find Elements command returns an empty list if there are no elements matching the criteria




Input Box/password/text area:	
sendKeys()	used to enter values onto text boxes
clear()	used to clear text boxes of its current value

Links:
click()	used to click on the link and wait for page load to complete before proceeding to the next command.

Submit Button:
submit()	 use the submit() method on any element within the form

Check Box, Radio Button:
click()	used to toggle the element on/off


Text Box:
--------------------
 1.How to get the web element for the text field using name?
  <input type="text" id="myname" name="uName" />
   WebElement item = driver.findElement(By.name("uName"));  
 
 2.How to get the web element for the text field using id?
  <input type="text" id="myname" name="uName" />
   WebElement item = driver.findElement(By.id("myname"));  
 
 3.How to check if the  web element is displayed?
 use "item.isDisplayed()"  
   -returns true if element is displayed
   -returns false if element is not displayed
  
 4.How to check if the  web element is enabled?
 use "item.isEnabled()"
   -returns true if element is Enabled
   -returns false if element is not Enabled
 
 5.How to enter the text to the text-field/password/text area/popup?
 	item.sendKeys("kumar");
 	
 6.How to clear the text for the text field?
 item.clear();
 
 7.How to check if the web element is text box?  
    <input type="text" id="myname" name="uName" />
   call   item.getAttribute("type") method
   
   ex:
    String type = item.getAttribute("type") ;
    // type should be "text"
  
  8.How to check if the web element is password?  
    <input type="password" id="myname" name="uName" />
      String type = item.getAttribute("type") ;
    // type should be "password"
  
  9.How to check if the web element is hidden?  
     <input type="hidden" id="myname" name="uName" />
        String type = item.getAttribute("type") ;
    // type should be "hidden"
  
  10.How to check if the web element is radio?
   <input type="radio" id="myname" name="uName" />
        String type = item.getAttribute("type") ;
    // type should be "radio"
   
  11.How to check if the web element is checkbox?
    <input type="checkbox" id="myname" name="uName" />
       String type = item.getAttribute("type") ;
    // type should be "checkbox"
    
  
  
 <input type="text" name="uName1" readonly="readonly" value="kumar" class="text-class" id="uNameID">
 12. How to get all the attributes of the web element?
  
  WebElement element = driver.findElement(By.name("uName1"));
  
  
   System.out.println(element.getAttribute("type")); // text
   System.out.println(element.getAttribute("name"));  //uName1
   System.out.println(element.getAttribute("readonly")); //true
   System.out.println(element.getAttribute("value"));  //kumar
   System.out.println(element.getAttribute("class"));   //text-class
   System.out.println(element.getAttribute("id")); //uNameID
  
  
*/

public class Notes {

	
	
	
}
