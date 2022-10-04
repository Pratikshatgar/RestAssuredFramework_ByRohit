package org.ByPOJO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaObjToJsonObj {

	public static void main(String[] args) throws JsonProcessingException {
		
		PojoClass obj = new PojoClass();
		obj.setAge(10);
		obj.setFName("Pratik");
		obj.setLName("Shatgar");
		
		ObjectMapper mapObj = new ObjectMapper();
		String jsonOBj =mapObj.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        System.out.println(jsonOBj);
	}

}
