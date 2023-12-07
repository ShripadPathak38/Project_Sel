package Core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class Listener {
	/**
	 * This class is used for Listener, means main purpose of this is to perform operation before and after every test runs like opening browser,closing browser,connections etc
	 * **/
	protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverManager.getDriver();
        driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
           driver.close();
           driver.quit();
        }
    }

}
