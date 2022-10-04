package org.ByPOJO;

import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeSerialization {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		RestAssured.baseURI="https://reqres.in/";
		String resource = "api/users/2";
		
		String responce =
		given().
		when().get(resource).
		then().extract().response().asString();
		
		System.out.println(responce);
		
		
		ObjectMapper objMap = new ObjectMapper();
		Pojo obj = objMap.readValue(responce, Pojo.class);		
		System.out.println("First name ="+obj.getFirst_name());

	}

}
