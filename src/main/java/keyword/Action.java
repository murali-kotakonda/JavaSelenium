package keyword;

public class Action {

	String keyword ;
	String description;
	String locatorType ;
	String locatorValue ;
	
	String testdata ;
	String assertionType ;
	String expectedValue ;
	
	public Action(String keyword, String description,String locatorType, String objectName,  String testdata, String assertionType,
			String expectedValue) {
		super();
		this.description = description;
		this.keyword = keyword;
		this.locatorValue = objectName;
		this.locatorType = locatorType;
		this.testdata = testdata;
		this.assertionType = assertionType;
		this.expectedValue = expectedValue;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getObjectName() {
		return locatorValue;
	}

	public void setObjectName(String objectName) {
		this.locatorValue = objectName;
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
		return  keyword + " " +description ;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
