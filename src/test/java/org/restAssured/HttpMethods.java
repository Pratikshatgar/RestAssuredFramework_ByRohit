package org.restAssured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpMethods {

	String url ="https://reqres.in/";

	void getMethod() 
	{
		RestAssured.baseURI = url ;
		String resource = "api/users?page=2";

		given().log().all().
		when().get(resource).
		then().log().all();	
	}

	void postMethod() throws JsonProcessingException
	{
		RestAssured.baseURI=url;
		String resource ="/api/users";

		String payload = " {\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";

//		HashMap<Object,Object> h1 = new HashMap<Object,Object>();
//		h1.put("name","Pratik");
//		h1.put("job","QA");
//		ObjectMapper objMap = new ObjectMapper();
//		String payload = objMap.writeValueAsString(h1);
		
		given().body(payload).log().all().
		when().post(resource).
		then().log().all();	
	}

	void putMethod() {
		RestAssured.baseURI=url;

		String resource = "/api/users/2";

		String payload = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";

		given().body(payload).log().all().
		when().put(resource).
		then().log().all();

	}

	void patchMethod() {
		RestAssured.baseURI=url;

		String resource = "/api/users/2";

		String payload = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";

		given().body(payload).log().all().
		when().patch(resource).
		then().log().all();

	}

	void deleteMethod() {
		RestAssured.baseURI=url;

		String resource = "/api/users/2";


		given().log().all().
		when().delete(resource).
		then().log().all();

	}



	public static void main(String[] args) throws JsonProcessingException {

		HttpMethods obj = new HttpMethods();
		//	obj.getMethod();
		  obj.postMethod();
		//	obj.putMethod();
		//  obj.patchMethod();
		//obj.deleteMethod();

	}

}
