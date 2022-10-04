package org.restAssured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class Dummy_Json {

	String url ="https://dummyjson.com/products";

	public static void main(String[] args) {
		Dummy_Json obj = new Dummy_Json();
		//	obj.getAllProducts();
		//	obj.getSingleProduct();
		//    obj.searchProduct();
		obj.limitAndSkip();
		//	obj.getProductCat();
		//	obj.getProdOfCatogories();
		//	obj.get_PostData();
		//	obj.updateProduct();
		//	obj.deleteProduct();
		//	obj.authProduct();

	}
	void getAllProducts() {
		String resource ="";
		RestAssured.baseURI = url;

		String response=
				given().
				when().get(resource).
				then()
				.statusCode(200)
				.extract().response().asString();

		System.out.println(response);
	}

	void getSingleProduct() {
		String resource ="/1";
		RestAssured.baseURI =url;

		given().
		when().get(resource).
		then()
		.statusCode(200)
		.log().all();
	}

	void searchProduct() {
		String resource ="/search";
		RestAssured.baseURI=url;

		given().queryParam("q","phone").
		when().get(resource).
		then()
		.statusCode(200)
		.log().all();
	}

	void limitAndSkip(){
		String resource ="?skip=5&limit=10";
		RestAssured.baseURI =url;

		given().queryParam("select","title").
		when().get(resource).
		then()
		.statusCode(200)
		.log().all();
	}

	void getProductCat() {
		String resource ="/category/smartphones";
		RestAssured.baseURI=url;

		given().
		when().get(resource).
		then()
		.statusCode(200)
		.log().all();
	}

	void getProdOfCatogories () {
		String resource ="/add";

		String payload ="{\r\n"
				+ "				    \"title\": \"BMW Pencil\"\r\n"
				+ "				    \r\n"
				+ "				  }";

		RestAssured.baseURI=url;

		given().body(payload).
		when().post(resource).
		then()
		.statusCode(200)
		//	.body("title",equalTo("BMW Pencil"))
		.assertThat().body("id",equalTo(101))
		.log().all();
	}


	void get_PostData() {
		String resource ="/101";
		RestAssured.baseURI=url;

		given().
		when().get(resource).
		then()
		.statusCode(200)
		.log().all();
	}

	void updateProduct() {
		String resource ="/1";

		String payload ="{\r\n"
				+ "				    \"title\": \"Audi\"\r\n"
				+ "				    \r\n"
				+ "				  }";

		RestAssured.baseURI=url;

		given().body(payload).
		when().put(resource).
		then()
		.statusCode(200)
		.log().all();
	}

	void deleteProduct() {
		String resource = "/1";
		RestAssured.baseURI =url;

		given().
		when().delete(resource).
		then()
		.statusCode(200)
		.body("isDeleted",equalTo(true))
		.log().all();
	}

	void authProduct() {
		String resource ="/auth/products";
		RestAssured.baseURI ="https://dummyjson.com/";

		given().auth().basic("UserName","Password"). //give preference to auth in given()
		when().get(resource).
		then()
		.statusCode(403)
		.body("message",equalTo("Authentication Problem"))
		.log().all();
	}
}
