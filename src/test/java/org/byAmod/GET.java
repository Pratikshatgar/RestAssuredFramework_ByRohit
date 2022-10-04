package org.byAmod;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.junit.Assert;

public class GET {

	public static void main(String[] args) {
		
		withoutStaticImport();
//		withStaticImport();
	}

	public static void withoutStaticImport() {

//		RestAssured.baseURI ="https://restful-booker.herokuapp.com/";
//		String resourse ="booking/350";
	
		String rp =
		RestAssured.		
		given()
		   .log().all()
		   .baseUri("https://restful-booker.herokuapp.com")
		   .basePath("/booking")   //passing the parameter 'id'
		// .pathParam("id",350)        // assign the value
		.when()
		    .get()
		.then()
		    .log().all()
		    .statusCode(200)
		    .statusLine("HTTP/1.1 200 OK")
	//	    .body("lastname",Matchers.equalTo("Jackson"))
	//	    .body("bookingid",Matchers.hasSize(7971))
		    .extract().response().asString();

		JsonPath js = new JsonPath(rp);
		List<Object>ls=js.getList("bookingid");
		System.out.println("total count ="+ls.size());
//		String actFname = js.getString("firstname");
//		Assert.assertEquals(actFname, "Tyler");
	}
	
	
	public static void withStaticImport() {

		String rp =		
		given()
		   .log().all()
		   .baseUri("https://restful-booker.herokuapp.com/")
		   .basePath("booking/{id}")   //passing the parameter 'id'
		   .pathParam("id",350)        // assign the value
		.when()
//		    .get(resourse)
		    .get()
		.then()
		    .log().all()
		    .statusCode(200)
		    .statusLine("HTTP/1.1 200 OK")
		    .body("lastname",equalTo("Jackson"))
		    .extract().response().asString();

		JsonPath js = new JsonPath(rp);
		String actFname = js.getString("firstname");
		Assert.assertEquals(actFname, "Tyler");
	}
}
