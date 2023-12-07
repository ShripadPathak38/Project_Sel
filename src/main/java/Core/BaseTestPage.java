package Core;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

public class BaseTestPage extends Listener {
	public int timeout =120;
	/**
	 * This class is used Base Methods that will used in overall framework like Click,Set,Wait
	 * **/
	public static WebDriver driver = WebDriverManager.getDriver();
	
	public WebElement findElement(By locator) {		
	    System.out.println("Finding element using locator: " + locator.toString() + " in " + timeout + " duration");
	    waitUntilElementIsPresent(Duration.ofSeconds(timeout), locator);
	    return driver.findElement(locator);
	}

	public void waitUntilElementIsPresent(Duration timeout, By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, timeout);
	    wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void Click(By locator) {
	    System.out.println("Clicking the element with locator: " + locator.toString());
	    WebElement element = findElement(locator);
	    element.click();
	}
	
	public void sendKeys(By locator, String text) {
	    System.out.println("Sending keys to the element with locator: " + locator.toString());
	    WebElement element = findElement(locator);
	    element.clear();
	    element.sendKeys(text);
	}
	
}
