package org.ByPOJO;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Serialization {

	public static void main(String[] args) throws JsonProcessingException {

		Serialization obj = new Serialization();
	//	obj.byHashMap();
	//	obj.byPojoMethod();
		obj.nestedJsonPayload();
	//	obj.multiJsonPayload();

	}

	public void byPojoMethod() throws JsonProcessingException {
		Pojo pobj = new Pojo();
		pobj.setName("Pratik");
		pobj.setJob("QA Engg");

		ObjectMapper objMap = new ObjectMapper();
		String payload =   objMap.writeValueAsString(pobj);

		System.out.println(payload);

		RestAssured.baseURI ="https://reqres.in/";
		String resource = "/api/users";

		given().body(payload).log().all().
		when().post(resource).
		then().log().all();
	}
	
	public void byHashMap() throws JsonProcessingException {

		HashMap<Object,Object> h1 = new LinkedHashMap<Object,Object>();
		h1.put("name","Pratik");
		h1.put("job","QA");
		ObjectMapper objMap = new ObjectMapper();
		String payload = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(h1);

		System.out.println("Payload ="+payload);

		RestAssured.baseURI ="https://reqres.in/";
		String resource = "/api/users";

		given().body(payload).
		when().post(resource).
		then().log().all();
		
	

	}
	 // nested Json payload by using LinkedHashMap
	public void nestedJsonPayload() throws JsonProcessingException {
		
		HashMap<String,Object> h1 = new LinkedHashMap<String,Object>();
		h1.put("first_name","Pratik");
		h1.put("last_name","Shatgar");
		h1.put("Role","QA");
		
		HashMap<String,Object> address = new LinkedHashMap<String,Object>();
		address.put("street","404 not found");
		address.put("pin", "1234");
		address.put("state","MH");
		
		h1.put("Address",address);
		
		ObjectMapper objMap = new ObjectMapper();
		String payload = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(h1);
		System.out.println("Payload ="+payload);
		
		RestAssured.baseURI ="https://reqres.in/";
		String resource = "/api/users";
		String response =
		given().body(payload).log().all().
		when().post(resource).
		then().extract().response().asPrettyString();;
		System.out.println("Response ="+response);
		

	}
	// multi Json Payload by using Arraylist and Hashmap
	 public void multiJsonPayload() throws JsonProcessingException {
		 HashMap<String,Object> h1 = new LinkedHashMap<String,Object>();
			h1.put("first_name","Pratik");
			h1.put("last_name","Shatgar");
			h1.put("Role","QA");
			
			HashMap<String,Object> address = new LinkedHashMap<String,Object>();
			address.put("street","404 not found");
			address.put("pin", "1234");
			address.put("state","MH");
			
			ArrayList<Object> allData = new ArrayList<Object>();
			allData.add(h1);
			allData.add(address);
			
			ObjectMapper objMap = new ObjectMapper();
			String payload = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(allData);
			System.out.println("Payload ="+payload);
			
			RestAssured.baseURI ="https://reqres.in/";
			String resource = "/api/users";
			String response =
			given().body(payload).log().all().
			when().post(resource).
			then().extract().response().asPrettyString();;
			System.out.println("Response ="+response);
	 }
	
}
