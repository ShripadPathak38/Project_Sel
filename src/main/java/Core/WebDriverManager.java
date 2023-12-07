package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
	/**
	 * This class usually create first and main instance of chromedriver and from here we can share that driver instance in overall framework
	 * **/
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
    	if (driver.get() == null) {
    		WebDriver appDriver = new ChromeDriver();
     		driver.set(appDriver);
            
    	}
    	return driver.get();
    }
}
