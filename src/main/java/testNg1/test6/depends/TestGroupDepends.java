package testNg1.test6.depends;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGroupDepends {

	public class DependencyTestUsingAnnotation {

		@Test(groups = { "init" })
		public void createAcc1() {
			System.out.println("createAcc1");
		}

		@Test(dependsOnGroups = { "init.*" })
		public void processUpdate() {
			System.out.println("processUpdate");
		}

		@Test(groups = { "init" })
		public void createAcc2() {
			System.out.println("createAcc2");
		}
	}
}
