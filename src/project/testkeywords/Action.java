package testkeywords;

public class Action {

	String testStep ;
	String description;
	String locatorType ;
	String objectName ;
	
	String testdata ;
	String assertionType ;
	String expectedValue ;
	
	public Action(String testStep, String description,String locatorType, String objectName,  String testdata, String assertionType,
			String expectedValue) {
		super();
		this.description = description;
		this.testStep = testStep;
		this.objectName = objectName;
		this.locatorType = locatorType;
		this.testdata = testdata;
		this.assertionType = assertionType;
		this.expectedValue = expectedValue;
	}

	public String getTestStep() {
		return testStep;
	}

	public void setTestStep(String testStep) {
		this.testStep = testStep;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getLocatorType() {
		return locatorType;
	}

	public void setLocatorType(String locatorType) {
		this.locatorType = locatorType;
	}

	public String getTestdata() {
		return testdata;
	}

	public void setTestdata(String testdata) {
		this.testdata = testdata;
	}

	public String getAssertionType() {
		return assertionType;
	}

	public void setAssertionType(String assertionType) {
		this.assertionType = assertionType;
	}

	public String getExpectedValue() {
		return expectedValue;
	}

	public void setExpectedValue(String expectedValue) {
		this.expectedValue = expectedValue;
	}

	@Override
	public String toString() {
		return  testStep + " " +description ;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
