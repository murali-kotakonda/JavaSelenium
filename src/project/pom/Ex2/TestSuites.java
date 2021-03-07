package pom.Ex2;

import org.testng.annotations.Test;

public class TestSuites
{
	TestCases myTc = new TestCases();
	int empNum = 44;
	/*protected void launchApplication()
	{
		int num=22;
		System.out.println("RC :Launch Application from TS ");
	}*/
	//*****************Test SUites************
	//That should not be static, should return only void,no arguments to the test
	@Test
	public void smoke()
	{
		//int a = this.empNum;
		//int b = this.num;
		System.out.println("********** Smoke Suite");
		//this.launchApplication();
		//super.launchApplication();
		myTc.composeAndSendAnEmail();
		myTc.replyToAnEmail();
		//return 22;
	}
	@Test
	public void regression()
	{
		System.out.println("**********Regression Suite");
		myTc.composeAndSendAnEmail();
		myTc.replyToAnEmail();
		myTc.forwardAnEmail();
		myTc.deleteAnEmail();
	}

}
