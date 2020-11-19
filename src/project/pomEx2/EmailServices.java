package pomEx2;

public class EmailServices
{
	/*public ReusableComponents()
	{
		System.out.println("Tests will run on default Browser chrome");
	}*/
	public EmailServices(String browser)
	{
		System.out.println("Tests Will run on browser :" + browser);
	}
	
	//*************Reusable Components***********************
	protected void launchApplication()
	{
		System.out.println("RC :Launch Application from RC ");
	}
	protected  void loginToApplication()
	{
		System.out.println("RC :Login To Application ");
	}
	protected  void compose()
	{
		System.out.println("RC :Compose Mail ");
	}
	protected  void goToInbox()
	{
		System.out.println("RC :Go To Inbox  ");
	}
	void send()
	{
		System.out.println("RC :Send the Mail  ");
	}
	void logoutFromApplication()
	{
		System.out.println("RC :Logout From Application ");
	}
	public  void closeApplication()
	{
		System.out.println("RC :Close Application ");
	}
	
	public  void open()
	{
		System.out.println("RC :Open The Mail ");
	}
	public  void reply()
	{
		System.out.println("RC :Reply to the Mail ");
	}
	public  void forward()
	{
		System.out.println("RC :Forward the Mail ");
	}
	public  void delete()
	{
		System.out.println("RC :Delete the Mail  ");
	}


}
