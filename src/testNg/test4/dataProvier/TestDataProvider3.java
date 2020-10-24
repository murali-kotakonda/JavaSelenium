package  test4.dataProvier;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 How to pass multiple employee objs to the test case

 */
public class TestDataProvider3 {
	@DataProvider(name = "empData")
	public static Object[][] test() {
		return new Object[][] { 
			{ new Employee(2000, "user1", "HR") }, 
			{ new Employee(2001, "user2", "IT") } };
	}

	@Test(dataProvider = "empData")
	public void testMethod(Employee emp) {
		System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getDeptName());
	}
}
