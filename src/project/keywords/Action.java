package keywords;

public class Action {

	String testStep ;
	String locatorType ;
	String objectName ;
	
	String testdata ;
	String assertionType ;
	String expectedValue ;
	
	public Action(String testStep, String locatorType, String objectName,  String testdata, String assertionType,
			String expectedValue) {
		super();
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
		return  testStep ;
	}

}
