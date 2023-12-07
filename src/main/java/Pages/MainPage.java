package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Core.BaseTestPage;
import JsonUtils.Person;

public class MainPage extends BaseTestPage{
	/**
	 * This class is used as POM(Page object module) and here we have written locators and required API's 
	 * **/
	private By GetBtnTableData() {
		return By.xpath(".//summary[contains(text(),'Table Data')]");
	}
	
	public MainPage ClickTableData() {
		Click(GetBtnTableData());
		return this;
	}
	
	
	private By GetInputData() {
		return By.xpath(".//p//textarea");
	}
	
	public MainPage EnterTableData(List<Person> person ) {
		sendKeys(GetInputData(), person.toString().replace("Person",""));
		return this;
	}
	
	private By GetBtnRefreshTable() {
		return By.xpath(".//button[@id='refreshtable']");
	}
	
	public MainPage ClickRefreshTable() {
		Click(GetBtnRefreshTable());
		return this;
	}
	
	private By GetNamesInTable() {
		return By.xpath(".//tr//td[1]");
	}
	
	private By GetNamesInAges() {
		return By.xpath(".//tr//td[2]");
	}
	
	private By GetGendersInTable() {
		return By.xpath(".//tr//td[3]");
	}
	
	public MainPage ValidateNamesInTable(List<String> names) {
		List<WebElement> namesElement = driver.findElements(GetNamesInTable());
		
		for(int i=0;i<names.size();i++) {
			String actualName = namesElement.get(i).getText();
            String expectedName = names.get(i);
            Assert.assertEquals(actualName, expectedName, "Name at index " + i + " does not match");
		}
		return this;
	}
	
	public MainPage ValidateAgesInTable(List<Integer> ages) {
		List<WebElement> agesElement = driver.findElements(GetNamesInAges());
		
		for(int i=0;i<ages.size();i++) {
			String actualAge = agesElement.get(i).getText();
            Integer expectedage = ages.get(i);
            Assert.assertEquals(actualAge, expectedage.toString(), "Age at index " + i + " does not match");
		}
		return this;
	}
	
	public MainPage ValidateGendersInTable(List<String> genders) {
		List<WebElement> gendersElement = driver.findElements(GetGendersInTable());
		
		for(int i=0;i<genders.size();i++) {
			String actualGender = gendersElement.get(i).getText();
            String expectedgender = genders.get(i);
            Assert.assertEquals(actualGender, expectedgender, "Gender at index " + i + " does not match");
		}
		return this;
	}
}
