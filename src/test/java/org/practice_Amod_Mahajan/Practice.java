package org.practice_Amod_Mahajan;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class Practice {

	

	public static void main(String[] args) {
		String res=
		RestAssured
		.given()
		.baseUri("https://dummyjson.com/products")
	//	.basePath("pratik")
	//	.body(payload)
	//	.auth().basic("uname","pass")
	//	.pathParam("pratik", rohit)
	//	.queryParam(null, null)


		.when()
		.get()
		.then()
      .statusCode(200)
  //    .body("products.id",Matchers.equalTo(null))
		.log()
	//	.ifValidationFails(LogDetail.HEADERS, true)
		.all()
      .extract().response().asPrettyString();
  
		JsonPath js = new JsonPath(res);
	List<Object> obj =	js.getList("products.title");
	Boolean flag =false;
	for(int i=0; i<obj.size();i++) {
		if(js.getList("products.title").get(i).equals("iPhone 9")) {
//			System.out.println(js.getList("products.title").get(i));
			flag =true;
			break;
			
		}
	}
	Assert.assertTrue(flag);

	
	
	}

}
