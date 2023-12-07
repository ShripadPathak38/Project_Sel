package JsonUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class GetJsonData {
	/**
	 * This class is used to get all json data as it is  
	 * **/
    public List<Person> getRawJsonData() {
    	 try {
    	String filePath = "src/test/resources/data.json";
		String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
        
        ObjectMapper objectMapper = new ObjectMapper();

            List<Person> persons = Arrays.asList(objectMapper.readValue(jsonString, Person[].class));
            for (Person person : persons) {
                System.out.println(person);
            }
            return persons;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}