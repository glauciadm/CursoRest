package br.api.rest;

import static io.restassured.RestAssured.get;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class OlaMundoTest {
	
	@Test
	public void testOlaMundo() {
		Response request = RestAssured.request(Method.GET, "http://restapi.wcaquino.me/ola");
		Assert.assertTrue(request.getBody().asString().equals("Ola Mundo!"));
		Assert.assertTrue(request.statusCode()==200);
		
		ValidatableResponse validacao = request.then();
		validacao.statusCode(200);
	}
	
	@Test
	public void outrasFormasRestAssured() {
		Response request = RestAssured.request(Method.GET, "http://restapi.wcaquino.me/ola");
		ValidatableResponse validacao = request.then();
		validacao.statusCode(200);
		
		get("http://restapi.wcaquino.me/ola").then().statusCode(200);
	
		RestAssured.given().
		when()
			.get("http://restapi.wcaquino.me/ola")
		.then()
			.statusCode(200);
	}
	
	@Test
	public void matchersHamcrest() {
		Assert.assertThat("Maria", Matchers.is("Maria"));
		Assert.assertThat(128, Matchers.isA(Integer.class));
		Assert.assertThat(128d, Matchers.isA(Double.class));
		Assert.assertThat(128d, Matchers.greaterThan(120d));
		Assert.assertThat(128d, Matchers.lessThan(130d));
		
		List<Integer> impares = Arrays.asList(1,3,5,7,9);
		assertThat(impares, Matchers.hasSize(5));
		assertThat(impares, Matchers.contains(1,3,5,7,9));
		assertThat(impares, Matchers.containsInAnyOrder(3,7,5,9,1));
		assertThat(impares, Matchers.hasItem(9));
		assertThat(impares, Matchers.hasItems(1,5));

		assertThat("Maria", Matchers.is(Matchers.not("João")));
		assertThat("Maria", Matchers.not("João"));
		assertThat("Maria", Matchers.anyOf(Matchers.is("Maria"), Matchers.is("Joaquina")));
		assertThat("Joaquina", Matchers.allOf(Matchers.startsWith("Joa"), Matchers.endsWith("ina"), Matchers.containsString("qui")));
				
		
	}
		
	
}
