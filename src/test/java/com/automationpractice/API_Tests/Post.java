package com.automationpractice.API_Tests;


import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.BeforeClass;
import org.junit.Test;
import com.automationpractice.user.User;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

/**
 * 
 * CREATE
 * 
 * **/

public class Post {

	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath= "/api";
	}
	
	
	@Test
	public void createUser() {
		User user = new User();
		user.setName("Elon_Musk");
		user.setJob("All round clever fellow");
		given().
		contentType(ContentType.JSON).
		when().
		body(user).
		post("/users").
		then().
		assertThat().
		statusCode(201);
	}
	
	
	
	
}

