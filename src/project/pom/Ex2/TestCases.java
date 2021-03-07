package pom.Ex2;

import org.testng.annotations.Test;

public class TestCases
{
	EmailServices myRc = new EmailServices("firefox");
	/*protected void launchApplication()
	{
		System.out.println("RC :Launch Application from TC ");
	}*/
	//******************Test Cases****************
	/*@Test
	public  void composeAndSendAnEmail1()
	{
		System.out.println("#####Test Case :composeAndSendAnEmail ");
		launchApplication();
		loginToApplication();
		goToInbox();
		compose();
		send();
		logoutFromApplication();
		closeApplication();
	}*/
	@Test
	public  void composeAndSendAnEmail()
	{
		System.out.println("#####Test Case :composeAndSendAnEmail ");
		myRc.launchApplication();
		myRc.loginToApplication();
		myRc.goToInbox();
		myRc.compose();
		myRc.send();
		myRc.logoutFromApplication();
		myRc.closeApplication();
	}
	@Test
	public  void replyToAnEmail()
	{
		System.out.println("#####Test Case :replyToAnEmail ");
		myRc.launchApplication();
		myRc.loginToApplication();
		myRc.goToInbox();
		myRc.open();
		myRc.reply();
		myRc.logoutFromApplication();
		myRc.closeApplication();
	}
	@Test
	public  void forwardAnEmail()
	{
		System.out.println("Test Case :forwardAnEmail ");
		myRc.launchApplication();
		myRc.loginToApplication();
		myRc.goToInbox();
		myRc.open();
		myRc.forward();
		myRc.logoutFromApplication();
		myRc.closeApplication();
	}
	@Test
	public  void deleteAnEmail()
	{
		System.out.println("Test Case :deleteAnEmail ");
		myRc.launchApplication();
		myRc.loginToApplication();
		myRc.goToInbox();
		myRc.open();
		myRc.delete();
		myRc.logoutFromApplication();
		myRc.closeApplication();
	}
	
			

}
