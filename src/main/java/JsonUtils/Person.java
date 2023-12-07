package JsonUtils;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	/**
	 * This class is treated as a object for fetching data with columns  
	 * **/
    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private int age;

    @JsonProperty("gender")
    private String gender;

    @Override
    public String toString() {
        return "{\"name\": \"" + name + "\", \"age\": " + age + ", \"gender\": \"" + gender + "\"}";
    }

}
