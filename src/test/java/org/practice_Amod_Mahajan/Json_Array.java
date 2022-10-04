package org.practice_Amod_Mahajan;
import java.util.List;

import io.restassured.path.json.JsonPath;

public class Json_Array {

	public static void main(String[] args) {
	String payload=
			       "{\r\n"
				+ "	\"id\": \"0001\",\r\n"
				+ "	\"type\": \"donut\",\r\n"
				+ "	\"name\": \"Cake\",\r\n"
				+ "	\"ppu\": 0.55,\r\n"
				+ "	\"batters\":\r\n"
				+ "		{\r\n"
				+ "			\"batter\":\r\n"
				+ "				[[\r\n"
				+ "					{ \"id\": \"1001\", \"type\": \"Regular\" },\r\n"
				+ "					{ \"id\": \"1002\", \"type\": \"Chocolate\" },\r\n"
				+ "					{ \"id\": \"1003\", \"type\": \"Blueberry\" },\r\n"
				+ "					{ \"id\": \"1004\", \"type\": \"Devil's Food\" }\r\n"
				+ "				],\r\n"
				+ "				[\r\n"
				+ "					{ \"id\": \"1005\", \"type\": \"Regular\" },\r\n"
				+ "					{ \"id\": \"1006\", \"type\": \"Chocolate\" },\r\n"
				+ "					{ \"id\": \"1007\", \"type\": \"Blueberry\" },\r\n"
				+ "					{ \"id\": \"1008\", \"type\": \"Devil's Food\" }\r\n"
				+ "				]]\r\n"
				
				+ "		},\r\n"
				+ "	\"topping\":\r\n"
				+ "		[\r\n"
				+ "			{ \"id\": \"5001\", \"type\": \"None\" },\r\n"
				+ "			{ \"id\": \"5002\", \"type\": \"Glazed\" },\r\n"
				+ "			{ \"id\": \"5005\", \"type\": \"Sugar\" },\r\n"
				+ "			{ \"id\": \"5007\", \"type\": \"Powdered Sugar\" },\r\n"
				+ "			{ \"id\": \"5006\", \"type\": \"Chocolate with Sprinkles\" },\r\n"
				+ "			{ \"id\": \"5003\", \"type\": \"Chocolate\" },\r\n"
				+ "			{ \"id\": \"5004\", \"type\": \"Maple\" }\r\n"
				+ "		]\r\n"
			
				+ "}";
	
	
	JsonPath js = new JsonPath(payload);
	System.out.println( js.getInt("id"));  //1
	System.out.println( js.getString("name"));//cake
	
	System.out.println( js.get("batters.batter[0][1]")); //{id=1002, type=Chocolate}
	System.out.println( js.get("batters.batter.type[0][2]"));//Blueberry
	System.out.println( js.get("batters.batter.id[0][2]")); //1003
	System.out.println( js.get("batters.batter[0].id[2]")); //1003
	
	System.out.println("=======================================");
	
	List<Object>all=  js.get("batters.batter");
	System.out.println(all.size()); //2
	
	List<Object>list1=  (List<Object>) all.get(1);
	System.out.println(list1.size()); //4
	
	System.out.println(list1.get(2)); //{id=1007, type=Blueberry}
	
	System.out.println("=======================================");
	
//	List<List<Object>>allList=  js.getList("batters.batter");
	List<List<Object>>allList=  js.get("batters.batter"); //stored in List<List<Object>>
	System.out.println(allList.size());//2
	System.out.println(allList.get(1).size());//4
	System.out.println("=======================================");
	
	List<Object>alltop = js.get("topping");
	System.out.println(alltop);
	System.out.println(alltop.get(1)); //{id=5002, type=Glazed}
	
	System.out.println(js.get("topping.id[0]")); //5001
	System.out.println(js.get("topping.type[6]")); //Maple
	

	
	
	

	}
       
	
}
