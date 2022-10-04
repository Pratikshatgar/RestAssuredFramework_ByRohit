package org.byAmod;

import io.restassured.RestAssured;

public class Path_query_Param {

	public static void main(String[] args) {
//		pathParam();
//		queryParam();
		test();

	}
	public static void pathParam() {
	//	https://reqres.in/api/user/7
     String resource ="api/user/{Pratik}";
		
		String res =
		RestAssured
		  .given()
		     .baseUri("https://reqres.in/")
		     .basePath(resource)
		     .pathParam("Pratik", 7).log().all()
		     
		  .when()
		      .get()
		  .then()
		       .extract().response().asPrettyString();
		
		System.out.println(res);
	}

	public static void queryParam() {
	 // https://reqres.in/api/user/?id=7
		String resource="api/user/";
		String res=
		RestAssured
		  .given()
		     .baseUri("https://reqres.in/")
		     .basePath(resource)
		     .queryParam("id",7).log().all()
		  .when()
		     .get()
		  .then()
		     .extract().response().asPrettyString();
		
		System.out.println(res);
	}
	
	public static void test() {
		String resource="public-api/users/";
		String res=
		RestAssured
		.given()
		   .baseUri("https://gorest.co.in/")
		//   .basePath(resource)
		   .queryParam("gender", "male")
		   .queryParam("status", "active").log().all()
		.when()
		   .get(resource)
		.then()
		.extract().response().asPrettyString();
		System.out.println(res);
	}
}
