package testFb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ex1_21 extends MyAppBaseTest{

	@BeforeMethod
	public void openForm() {
		//open the form.html
		driver.get(URL + "form.html");
		
	}
	
	//<input type="text" id="myname" name="uName">
	@Test
	public void testFn() {
		//get web element 
		getTextField(By.name("uName")).sendKeys("raj kumar");
		
	}
	
	//<input type="text" name="uName1" readonly="readonly" value="kumar">
	@Test
	public void testMiddleName() {
		WebElement element = getTextField(By.name("uName1"));
		
		// How to assert the readonly
		Assert.assertEquals(element.getAttribute("readonly"), "true");
		
		// How to assert the value
		Assert.assertEquals(element.getAttribute("value"), "kumar");
	}
	
	//<input type="text" name="LName" size="30" width="30">
	@Test
	public void testLastName() {
	  //get web element obj
	  getTextField(By.name("LName")).sendKeys("varma");
		
		//How to check width
		// Assert.assertEquals(element.getAttribute("width") , "30");
		 
		 //How to check size
		// Assert.assertEquals(element.getAttribute("size") , "30");
		 
	}
	
	//<input type="text" name="uName2" disabled="disabled">
	@Test
	public void testSn() {
		WebElement element = driver.findElement(By.name("uName2"));
		
		//How to check if the field is text field
		Assert.assertEquals(element.getAttribute("type"),"text", "Invalid field type.Expected text");
	
		//How to check if the text field is disabled
		Assert.assertFalse(element.isEnabled(),"uName2 should be disabled");
		
		//How to check if the text field is displayed
		Assert.assertTrue(element.isDisplayed(),"uName2 should be displayed");
		
	}
	
	//<input type="password" name="password">
	@Test
	public void testPassword() {
		getPasswordField(By.name("password")).sendKeys("Raju1234345");
		
	}
	
	// <input type="radio" name="gender" id="mRadio" value="male" checked> Male<br>
	   //  <input type="radio" name="gender" id="fRadio" value="female"> Female<br>
		// <input type="radio" name="gender" id="oRadio" value="other"> Other
	/**
       How to check if the webelemnt is selected or not?
       solution)
       item.isSeleected() --> returns true/false
       applicable : radio , checkbox , dropdown  
     
	 */
	@Test
	public void testRadio() {
		WebElement mRadio = getRadio(By.id("mRadio"),true); 
		WebElement fRadio =getRadio(By.id("fRadio"),false); 
		WebElement oRadio = getRadio(By.id("oRadio"),false); 
		
		// how to select radio button
		oRadio.click();
		sleep(2);
		
		fRadio.click();
		sleep(2);
		
		mRadio.click();
		sleep(2);
				
	}
	
	//<input type="checkbox" name="proof1" value="passport">passport &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	//<input type="checkbox" name="proof2" value="voter">voter &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	//<input type="checkbox" name="proof3" value="pan" checked> pan<br>
	
	@Test
	public void testCheckBox1() {
		WebElement passport = getCheckBox(By.name("proof1"),false); 
		WebElement voter =getCheckBox(By.name("proof2"),false); 
		WebElement pan = getCheckBox(By.name("proof3"),true ); 
		
		// unchek pan
		pan.click();
		
		
		// unchek pan
		passport.click();
		
		
		// unchek pan
		voter.click();
		
		
	}
	
	// <textarea name="address" rows="5" cols="80"></textarea>
	@Test
	public void testTextArea() throws InterruptedException {
		WebElement address = driver.findElement(By.name("address"));

		checkEnabledAndDisplayed(address);

		Assert.assertEquals(address.getAttribute("cols"), "80", "invalid no of cols");
		address.sendKeys("#51/15 a-51, panathur road, bangalore.");

		
	}
		
		//Upload image :<input type="file" name="fileupload" accept="image/*" />
	@Test
	public void testUpload() {
		WebElement uploadElement = driver.findElement(By.name("fileupload"));

		checkEnabledAndDisplayed(uploadElement);
		Assert.assertEquals(uploadElement.getAttribute("type"), "file", "invalid type.");
		Assert.assertEquals(uploadElement.getAttribute("accept"), "image/*", "invalid accept.");

		uploadElement.sendKeys("C:\\test\\test1.txt");
		
	}
		
		//	<br> <input type="submit" name="submit" value="submit" />
		@Test
		public void submit() {
			WebElement submit = driver.findElement(By.name("submit"));
			submit.submit();
		}
		
	/*	<select name="city">
		<option value="hyd">Hyderabad</option>
		<option value="bang" selected="selected">Bangalore</option>
		<option value="chen">Chennai</option>
		<option value="mum">Mumbai</option>
		</select>
	*/
	@Test
	public void testDropdown() throws InterruptedException {
		WebElement cities =  getDropDown(By.name("city"), 4, "Bangalore");
		
		Select select = new Select(cities);	
				
		select.selectByVisibleText("Chennai");
		
		
		select.selectByIndex(1);
		
		
		select.selectByValue("mum");
		
	}
		
		
		/*<select name="citizen" multiple="">
		<option value="IN">India</option>
		<option value="PAK">Pakistan</option>
		<option value="US">America</option>
		<option value="AUS">Australia</option>
	  </select>
	*/
	
	@Test
	public void testMultiDropdown() throws InterruptedException {
		WebElement citizen =  getMultiDropDown(By.name("citizen"), 4, "");
		Select select = new Select(citizen);	
		
		//select the values in dropdown
		select.selectByVisibleText("India");
		
		select.selectByIndex(1);
		
		select.selectByValue("US");
		
		//deselect the values in dropdown
		select.deselectByVisibleText("India");
		
		select.deselectByIndex(1);
		
		select.deselectByValue("US");
		
		select.selectByVisibleText("India");
		
	}
}