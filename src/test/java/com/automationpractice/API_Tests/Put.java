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
 * UPDATE
 * 
 * ***/
public class Put {

	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath= "/api";
	}
	
	@Test
	public void updateUser() {
		User user = new User();
		user.setName("Elon_Musk");
		user.setJob("Send us to the stars");
		given().
		contentType(ContentType.JSON).
		when().
		body(user).
		put("/users/Elon_Musk/").
		then().
		assertThat().
		statusCode(200);
	}
	
	
	
	
	
	
	
}
