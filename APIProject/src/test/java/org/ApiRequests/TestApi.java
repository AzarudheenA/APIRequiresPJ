package org.ApiRequests;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestApi {
	@Test(priority = 1)
	public void GetBBd() {
		  Response response = RestAssured.given().baseUri("https://reqres.in/").when().get("/api/users?page=2");
				String res = response.asPrettyString();
		System.out.println(res);
		int actualstatusCode = response.getStatusCode();
		int expectedstatuscode=200;
		System.out.println("<=====>"+actualstatusCode + "= actual status code"+"<=====>");
		Assert.assertEquals(actualstatusCode, expectedstatuscode,"Get Method not match status code differs");
		
	}
	@Test(priority = 2)

	public void PostBDD() {
		Response response = RestAssured.given().baseUri("https://reqres.in/").header("Content-Type", "application/json")
				.body("{\n" + "    \"name\": \"shuu\",\n" + "    \"job\": \"winner\"\n" + "}").when().post("api/users/");
		String res = response	.asPrettyString();
		System.out.println("Post response string" + res);
		int actualstatusCode = response.getStatusCode();
		int expectedstatuscode=201;
		System.out.println("<=====>"+actualstatusCode + "= actual status code"+"<=====>");
		Assert.assertEquals(actualstatusCode, expectedstatuscode,"Get Method not match status code differs");
		
	}

	@Test(priority = 3)
	public void PUTBDD() {
		Response response = RestAssured.given().baseUri("https://reqres.in/").header("Content-Type", "application/json")
				.body("{\n" + "    \"name\": \"kisffhore\",\n" + "    \"job\": \"Indian\"\n" + "}").when()
				.put("api/users/2");
		System.out.println(response.asPrettyString());
		int actualstatusCode = response.getStatusCode();
		int expectedstatuscode=200;
		System.out.println("<=====>"+actualstatusCode + "= actual status code"+"<=====>");
		Assert.assertEquals(actualstatusCode, expectedstatuscode,"Get Method not match status code differs");
	}

	@Test(priority = 4)
	public void DeletBDD() {
		Response response = RestAssured.given().baseUri("https://reqres.in/").when().delete("api/users/2");
		System.out.println(response.asPrettyString());
		int actualstatusCode = response.getStatusCode();
		int expectedstatuscode=204;
		System.out.println("<=====>"+actualstatusCode + "= actual status code"+"<=====>");
		Assert.assertEquals(actualstatusCode, expectedstatuscode,"Get Method not match status code differs");
	}

}
	
	


