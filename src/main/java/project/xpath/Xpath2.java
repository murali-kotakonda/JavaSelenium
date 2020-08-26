package project.xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import util.Commons;

public class Xpath2 {
public static void main(String[] args) {
	/*
	  <form method="POST" action="https://accounts.lambdatest.com/register">
<input type="hidden" name="_token" value="W4D7bCygQ4abq2Xa3ckZ2rwG3Wk7f9enPXIIPeuF"> 
<div class="col-sm-12 google-sign-form"><p class="signup-titel" style="text-align: center;">SIGN UP FOR FREE</p></div> <div class="col-sm-12 google-sign-form">
<input type="text" placeholder="Organization/Company Name" name="organization_name" value="" class="form-control sign-up-input-2 ">
 <input type="text" placeholder="Full Name*" name="name" value="" class="form-control sign-up-input-2 ">
 <input type="email" placeholder="Work Email*" name="email" value="" class="form-control sign-up-input-2 "> 
<input type="password" placeholder="Desired Password*" name="password" class="form-control sign-up-input-2 "> <input type="phone" placeholder="Phone*" name="phone" value="" class="form-control sign-up-input-2 "> <p class="terms-cond"><label for="terms_of_service" class="woo">
<input type="checkbox" name="terms_of_service" id="terms_of_service" value="1" class="form-check-input" style="position: relative; margin-left: 0px;"> &nbsp; I agree to the <a target="_blank" href="https://www.lambdatest.com/terms-of-service">Terms
                                    of Service</a>
                                and <a target="_blank" href="https://www.lambdatest.com/privacy">Privacy Policy</a></label></p> <button type="submit" class=" btn sign-up-btn-2 btn-block">Signup for Free</button></div>
 <div class="col-sm-12 link-sect"><p class="login-in-link test-left">Already have an account? <a href="/login">Login</a></p></div></form>

	 */
	
     WebDriver driver=Commons.getDriver();
     driver.get("");
     //Relative xpath for organization field
     driver.findElement(By.xpath("//input[@name='organization_name']")).sendKeys("Lambdatest Org");
     //Relative xpath for full name field
     driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Sadhvi Singh");
}
}
