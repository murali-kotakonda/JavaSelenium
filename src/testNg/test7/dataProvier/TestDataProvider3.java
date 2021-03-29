package  test7.dataProvier;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 How to pass multiple employee objs to the test case

 */
public class TestDataProvider3 {

	
	@DataProvider(name = "empData")
	public static Object[][] data() {
		return new Object[][] {
			{ new Employee(2000, "user1", "HR1")   }, 
			{ new Employee(2001, "user2", "HR2")   }, 
			{ new Employee(2002, "user3", "HR3")    }, 
			{ new Employee(2003, "user4", "HR4")   },
			{ new Employee(2004, "user5", "HR5")    },
			{ new Employee(2005, "user6", "HR6")  },
			{ new Employee(2006, "user7", "HR7")    }
			};
	}

	@Test(dataProvider = "empData")
	public void testMethod(Employee emp) {
		System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getDeptName());
	}
}
