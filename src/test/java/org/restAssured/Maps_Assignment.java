package org.restAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Maps_Assignment {

	static String url ="https://rahulshettyacademy.com";
	HashMap<String, String> h1 ;
	HashMap hp;
	String place_id;

	public static void main(String[] args) {

		Maps_Assignment obj = new Maps_Assignment();
		
		System.out.println("**********Post Method**************");
		obj.postMethod();
		
		System.out.println("**********Get Method*************");
		obj.getMethod(); 
		
		System.out.println("************Put Method**********");
        obj.putMethod();
        
        System.out.println("***********Get Method***********");
        obj.getMethod(); 
        
		System.out.println("**********Delete Method*********");
		obj.deleteMethod();

	}

	void postMethod() {

		String resource ="/maps/api/place/add/json";
		String payload ="{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "";

		RestAssured.baseURI=url;

		String response =
				given().body(payload).queryParam("key" , "qaclick123").
				when().post(resource).
				then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
		        .log().all().extract().response().asString();

		System.out.println("response ="+response);

		JsonPath js = new JsonPath(response);
		 place_id =js.getString("place_id");
		 h1 = new HashMap<String, String>();
		 h1.put("place_id", place_id);


		System.out.println("h1="+h1);

	}

	void deleteMethod()  {

		String resource ="/maps/api/place/delete/json";

		//		String payload ="{\r\n"   //everytime u have to use place_id of post method
		//				+ "    \"place_id\":\"e04031640290e25fb5a4e77f328647f0\"  \r\n"
		//				+ "}\r\n"
		//				+ "";

		//*** converting from map(h1) to Json format(Payload)
		String payload= null;
		try {
			payload = new ObjectMapper().writeValueAsString(h1);

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		RestAssured.baseURI=url;

		given().body(payload).queryParam("key" , "qaclick123").
		when().post(resource).
		then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.log().all();
	}


	void getMethod() {

		String resource ="/maps/api/place/get/json";
		RestAssured.baseURI= url;
		
		//everytime u have to use place_id of post method
	    //given().queryParams("place_id","de22ed332aa46d90134f57de0b0b6fa2").queryParams("key","qaclick123").
		
		given().queryParams(h1).queryParams("key","qaclick123").
		when().get(resource).
		then()
		.statusLine("HTTP/1.1 200 OK")
		.log().all();
	}


	void putMethod() {

		String resource ="/maps/api/place/update/json";
		RestAssured.baseURI=url;
	
//		String payload ="{\r\n"
//				+ "\"place_id\":\"de22ed332aa46d90134f57de0b0b6fa2\",\r\n"
//				+ "\"address\":\"70 winter walk, USA\",\r\n"
//				+ "\"key\":\"qaclick123\"\r\n"
//				+ "}\r\n"
//				+ "";
		
		hp = new HashMap();
		hp.put("place_id", place_id);
		hp.put("address","At post Solapur");
		hp.put("key", "qaclick123");
		
		String payload = null;
		
		try {
			payload = new ObjectMapper().writeValueAsString(hp);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		given().body(payload).
		when().put(resource).
		then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		
		.log().all();




	}
}
