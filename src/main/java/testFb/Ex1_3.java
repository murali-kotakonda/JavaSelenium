package testFb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ex1_3 extends MyAppBaseTest{

	@BeforeMethod
	public void openForm() {
		//open the form.html
		driver.get(URL + "form.html");
		
	}
	
	@Test
	public void testFn() {
		//test 1st name
		getTextField(By.name("uName")).sendKeys("raj kumar");
		
		//test middle name
		WebElement element = getTextField(By.name("uName1"));
		Assert.assertEquals(element.getAttribute("readonly"), "true");
		Assert.assertEquals(element.getAttribute("value"), "kumar");
		
		
		// test last name
		getTextField(By.name("LName")).sendKeys("varma");

		// test surName
		WebElement surName = driver.findElement(By.name("uName2"));
		Assert.assertEquals(surName.getAttribute("type"), "text", "Invalid field type.Expected text");
		Assert.assertFalse(surName.isEnabled(), "uName2 should be disabled");
		Assert.assertTrue(surName.isDisplayed(), "uName2 should be displayed");
		
		 //test password
		getPasswordField(By.name("password")).sendKeys("Raju1234345");
		
		//test radio
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
 
		//test checkbox
		WebElement passport = getCheckBox(By.name("proof1"),false); 
		WebElement voter =getCheckBox(By.name("proof2"),false); 
		WebElement pan = getCheckBox(By.name("proof3"),true ); 
		
		pan.click();
		passport.click();
		voter.click();


		//test address
		WebElement address = driver.findElement(By.name("address"));

		checkEnabledAndDisplayed(address);

		Assert.assertEquals(address.getAttribute("cols"), "80", "invalid no of cols");
		address.sendKeys("#51/15 a-51, panathur road, bangalore.");

		 //test upload
		WebElement uploadElement = driver.findElement(By.name("fileupload"));

		checkEnabledAndDisplayed(uploadElement);
		Assert.assertEquals(uploadElement.getAttribute("type"), "file", "invalid type.");
		Assert.assertEquals(uploadElement.getAttribute("accept"), "image/*", "invalid accept.");

		uploadElement.sendKeys("C:\\test\\test1.txt");
		

		// test dropdown
		WebElement cities = getDropDown(By.name("city"), 4, "Bangalore");
		Select select = new Select(cities);
		select.selectByVisibleText("Chennai");
		select.selectByIndex(1);
		select.selectByValue("mum");
		
		
		//test multi dropdown
		WebElement citizen =  getMultiDropDown(By.name("citizen"), 4, "");
		Select selectCitizen = new Select(citizen);	
		
		//select the values in dropdown
		selectCitizen.selectByVisibleText("India");
		selectCitizen.selectByIndex(1);
		selectCitizen.selectByValue("US");
		
		//deselect the values in dropdown
		selectCitizen.deselectByVisibleText("India");
		selectCitizen.deselectByIndex(1);
		selectCitizen.deselectByValue("US");
		selectCitizen.selectByVisibleText("India");
		
		// submit
		WebElement submit = driver.findElement(By.name("submit"));
		submit.submit();
		
	}
}