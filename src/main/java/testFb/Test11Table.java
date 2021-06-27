package testFb;

public class Test11Table {
/*  
 from selenium.webdriver.common.keys import Keys

from seleniumEx.myBasetest import BaseTest
import time
from selenium.webdriver import ActionChains

class ScrollTest(BaseTest):

    def setUp(self):
        BaseTest.setUp(self)
        self.driver.get("http://localhost:8082/myapp/hover.html")
        self.driver.maximize_window()
        time.sleep(3)
    """
    <a href="https://www.fb.com">Click here</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="https://www.gmail.com">Click for Date</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="https://www.google.com">Send Data</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="form.html">Ex1</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="alert.html">Ex2</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    """
    def test1(self):
        link1 = self.driver.find_element_by_link_text("Click here")
        link2 = self.driver.find_element_by_link_text("Click for Date")
        link3 = self.driver.find_element_by_link_text("Send Data")
        link4 = self.driver.find_element_by_link_text("Ex1")
        link5 = self.driver.find_element_by_link_text("Ex2")

        action = ActionChains(self.driver)
        action.move_to_element(link1).perform()
        time.sleep(3)

        action = ActionChains(self.driver)
        action.move_to_element(link2).perform()
        time.sleep(3)

        action = ActionChains(self.driver)
        action.move_to_element(link3).perform()
        time.sleep(3)

        action = ActionChains(self.driver)
        action.move_to_element(link4).perform()
        time.sleep(3)

        action = ActionChains(self.driver)
        action.move_to_element(link5).perform()
        time.sleep(3)

    def test2(self):
        link1 = self.driver.find_element_by_link_text("Click here")
        action = ActionChains(self.driver)
        action.move_to_element(link1).click().perform()
        time.sleep(3)
        self.driver.back()


        link2 = self.driver.find_element_by_link_text("Click for Date")
        action = ActionChains(self.driver)
        action.move_to_element(link2).click().perform()
        time.sleep(3)
        self.driver.back()



        link3 = self.driver.find_element_by_link_text("Send Data")
        action = ActionChains(self.driver)
        action.move_to_element(link3).click().perform()
        time.sleep(3)
        self.driver.back()



        link4 = self.driver.find_element_by_link_text("Ex1")
        action = ActionChains(self.driver)
        action.move_to_element(link4).click().perform()
        time.sleep(3)
        self.driver.back()


        link5 = self.driver.find_element_by_link_text("Ex2")
        action = ActionChains(self.driver)
        action.move_to_element(link5).click().perform()
        time.sleep(3)
        self.driver.back()
 
 */
}
