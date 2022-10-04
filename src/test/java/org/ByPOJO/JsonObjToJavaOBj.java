package org.ByPOJO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonObjToJavaOBj {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
  String jsonResponse="{\r\n"
  		+ "  \"age\" : 10,\r\n"
  		+ "  \"lname\" : \"Shatgar\",\r\n"
  		+ "  \"fname\" : \"Pratik\",\r\n"
  		+ "  \"All Ok\" : \"Good to go\",\r\n"
  		+ "  \"Address\" : \"Solapur\"\r\n"
  		+ "}";
  
  
  ObjectMapper mapObj =new ObjectMapper();
   PojoClass obj = mapObj.readValue(jsonResponse, PojoClass.class);
  System.out.println( obj.getAge());
  System.out.println( obj.getFName());
  System.out.println( obj.getLName());
  System.out.println( obj.getAllOk());
  
       }
	}


