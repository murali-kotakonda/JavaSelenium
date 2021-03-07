package pom.Ex1;

public class EmailServices {
	
	public EmailServices() {
		System.out.println("Default Constructor in EmailServices");
	}

	public EmailServices(String browser) {
		System.out.println("Default Constructor in EmailServices");
	}

	protected void launchApplication() {
		System.out.println(" :Launch Application from RC ");
	}

	protected void loginToApplication() {
		System.out.println("  :Login To Application ");
	}

	protected void compose() {
		System.out.println("Compose Mail ");
	}

	protected void goToInbox() {
		System.out.println("Go To Inbox  ");
	}

	void send() {
		System.out.println("Send the Mail  ");
	}

	void logoutFromApplication() {
		System.out.println("Logout From Application ");
	}

	public void closeApplication() {
		System.out.println("Close Application ");
	}

	public void open() {
		System.out.println("Open The Mail ");
	}

	public void reply() {
		System.out.println("Reply to the Mail ");
	}

	public void forward() {
		System.out.println("Forward the Mail ");
	}

	public void delete() {
		System.out.println("Delete the Mail  ");
	}
}
