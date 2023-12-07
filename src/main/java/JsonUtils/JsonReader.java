package JsonUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonReader {
	/**
	 * This class is used to get json data from specific column like name, age,gender  
	 * **/
	public List<String> names = new ArrayList<>();
    public List<String> genders = new ArrayList<>();
    public List<Integer> ages = new ArrayList<>();
	public void GetSpecificColumnJsonData(){
        
		String filePath = "src/test/resources/data.json";
		try {
		String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));

        JSONArray jsonArray = new JSONArray(jsonString);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            String name = jsonObject.getString("name");
            String gender = jsonObject.getString("gender");
            int age = jsonObject.getInt("age");
            names.add(name);
            genders.add(gender); 
            ages.add(age);
	}
}
		catch(Exception e) {
			System.out.println("!! Error Error !!");
		}
	}
}
