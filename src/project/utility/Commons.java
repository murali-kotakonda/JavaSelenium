package utility;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;

public class Commons {
	public static void checkEnabledAndDisplayed(WebElement... elements) {
		for (WebElement element : elements) {
		assertTrue(element.isDisplayed(), "element expeceted to display");
			assertTrue(element.isEnabled(), "element expected to enable");
		}

	}
}
