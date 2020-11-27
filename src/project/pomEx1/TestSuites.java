package pomEx1;

import org.testng.annotations.Test;

public class TestSuites extends TestCases
{
	int empNum = 44;
	protected void launchApplication()
	{
		int num=22;
		System.out.println("Launch Application from TS ");
	}
	//*****************Test SUites************
	//That should not be static, should return only void,no arguments to the test
	@Test
	public void smoke()
	{
		int a = this.empNum;
		//int b = this.num;
		System.out.println("********** Smoke Suite");
		this.launchApplication();
		super.launchApplication();
		//composeAndSendAnEmail();
		//replyToAnEmail();
		//return 22;
	}
	@Test
	public void regression()
	{
		System.out.println("**********Regression Suite");
		composeAndSendAnEmail();
		replyToAnEmail();
		forwardAnEmail();
		deleteAnEmail();
	}

}
