package com.automationpractice.API_Tests;

import org.junit.BeforeClass;
import org.junit.Test;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * 
 * READ
 * 
 * **/

public class Get {

	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath= "/api";
	}
	
	@Test
	public void readUser2() {
		
		Response response = given().					
		when().
		get("/users/2");
		System.out.println(response.body().prettyPrint());
	
		given().					
		when().
		get("/users/2").
		then()
		.assertThat()
		.statusCode(200);	
	}
}
