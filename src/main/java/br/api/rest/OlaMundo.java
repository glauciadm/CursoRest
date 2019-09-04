package br.api.rest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class OlaMundo {
	public static void main(String[] args) {
		Response request = RestAssured.request(Method.GET, "http://restapi.wcaquino.me/ola");
		System.out.println(request.getBody().asString().equals("Ola Mundo!"));
		System.out.println(request.statusCode()==200);
		
		ValidatableResponse validacao = request.then();
		validacao.statusCode(200);
	}
}
