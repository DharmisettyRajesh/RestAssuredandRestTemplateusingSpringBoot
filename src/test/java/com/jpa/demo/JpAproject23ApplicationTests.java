package com.jpa.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

@SpringBootTest
class JpAproject23ApplicationTests {

	@org.testng.annotations.Test
	void contextLoads() {
		RestAssured.baseURI = "http://localhost:9090";
		RestAssured.given().get("/getall").then().statusCode(200).log().body();
		System.out.println("ok");
	}
    @org.testng.annotations.Test
    public void TestforPost()
    {
    	RestAssured.baseURI = "http://localhost:9090";
		JSONObject req = new JSONObject();

		req.put("id", 6);
		req.put("name", "Bhaskar");
		System.out.println("req" + req);
		Response res = RestAssured.given().contentType(ContentType.JSON)
				.header("Content-Type", "application/json")
				.body(req.toJSONString()).when().post("/addperson").then().extract().response();
		System.out.println("res==>" + res.asString());
		

    }
    @org.testng.annotations.Test
    public void TestforPut()
    {
    	RestAssured.baseURI = "http://localhost:9090";
		JSONObject req = new JSONObject();
		req.put("id", 4);
		req.put("name", "Swethak Dunna");
		System.out.println("req" + req);
		Response res = RestAssured.given().contentType(ContentType.JSON)
				.header("Content-Type", "application/json")
				.body(req.toJSONString()).when().put("/updateperson").then().extract().response();
		System.out.println("res==>" + res.asString());

    }
    @org.testng.annotations.Test
    public void TestforDelete()
    {
    	RestAssured.baseURI = "http://localhost:9090";
		JSONObject req = new JSONObject();
		req.put("id", 3);
		System.out.println("req" + req);
		Response res = RestAssured.given().contentType(ContentType.JSON)
				.header("Content-Type", "application/json")
				.body(req.toJSONString()).when().delete("/deletebyid").then().extract().response();
		System.out.println("res==>" + res.asString());

    }
}
