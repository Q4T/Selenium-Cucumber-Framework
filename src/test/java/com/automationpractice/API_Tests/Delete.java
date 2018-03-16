package com.automationpractice.API_Tests;

import static com.jayway.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.automationpractice.user.User;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;





public class Delete {

	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath= "/api";
	}
	
	@Test
	public void deleteUser() {
		User user = new User();
		user.setName("Elon_Musk");
		user.setJob("Send us to the stars");
		given().
		contentType(ContentType.JSON).
		when().
		body(user).
		delete("/users/Elon_Musk/").
		then().
		assertThat().
		statusCode(204);
	}
	
	
}
