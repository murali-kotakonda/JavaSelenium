package test5.depends;

import org.testng.annotations.Test;

/**
 depends:
-----------
dependsOnMethods
dependsOnGroups

if a test case  depends on another test case.
then we need to use any of the above two attributes.

 */
public class TestGroupDepends {

	  
	@Test(groups = { "init" })
	public void createAcc1() {
		System.out.println("createAcc1");
	}
	
	@Test(groups = { "init" })
	public void createAcc2() {
		System.out.println("createAcc2");
	}
	
	@Test(dependsOnGroups = { "init.*"})
	public void accountUpdate() {
		System.out.println("account Update");
	}

	  // accountUpdate() test case will run only after completion of the test cases that belongs to init group
		 
	
}
