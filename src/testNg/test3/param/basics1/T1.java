package test3.param.basics1;

/**
   How to pass values from testng xml to test class?
   
    1.changes in the testng.xml:
        Write parameter with name and value in xml. 
    	<parameter name = "userName" value="admin"/> 
        
        -Where can we write the parameter Tag?
    	 A)  Global level (it is available to all the tests)
	    	write <parameter>  tag inside the <suite> 
	    	ex:
	    	<suite name="Test1">
					<parameter name = "userName" value="admin"/> 
			</suite>
		B) specific to Test
		   write <parameter>  tag inside the <test> 
	    	ex:
	    	<suite name = "empDemo">
   						<test name = "register">
								<parameter name = "userName" value="admin"/> 
						</test>
			</suite>
    	
    2.changes in the Test class
        Write @Parameters(value = {"userName"}) 
       
       -Where can we write the @Parameters annotations?
        solution)
        1.Along with @BeforeMethod, 
        2.Along with @BeforeTest
        3.Along with @Test

 */

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class T1 {
	
	@BeforeMethod
	@Parameters(value = {"userName"})
	public void before(String name) {
		System.out.println(name);
	}
	
	@Test
	public void t1() {
		System.out.println("In t1");
	}

	@Test
	public void t2() {
		System.out.println("In t2");
	}

}
