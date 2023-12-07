import java.util.List;

import org.checkerframework.checker.units.qual.mPERs;
import org.testng.annotations.Test;

import Core.BaseTestPage;
import JsonUtils.GetJsonData;
import JsonUtils.JsonReader;
import Pages.MainPage;

public class Test_Assgnment extends BaseTestPage{
	/**
	 * This class is treated as test class and here we are writing our tests scripts  
	 * **/
	@Test
	public void Assignment() {
		JsonReader jsonReader = new JsonReader();
		jsonReader.GetSpecificColumnJsonData();
		List<String>namesList =  jsonReader.names;
		List<String>gendersList =  jsonReader.genders;
		List<Integer>agesList =  jsonReader.ages;
		
		
		MainPage mainPage = new MainPage();
		mainPage.ClickTableData();
		mainPage.EnterTableData(new GetJsonData().getRawJsonData());
		mainPage.ClickRefreshTable();
		mainPage.ValidateNamesInTable(namesList);
		mainPage.ValidateAgesInTable(agesList);
		mainPage.ValidateGendersInTable(gendersList);
		
	}
}
