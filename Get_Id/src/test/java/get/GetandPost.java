package get;

import org.json.simple.JSONObject;
import io.restassured.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.*;

public class GetandPost {
	@Test
	public void get() {
		baseURI = "https://reqres.in";
		given().get("/api/users?page=2")
		.then().statusCode(200)
		.body("data.id[1]", equalTo(8)).log().all();
	}
	
	@Test
	public void post() {
		//Map<String, Object> data = new HashMap<String, Object>();
		JSONObject Request = new JSONObject();
		Request.put("name", "morpheus");
		Request.put("job","Teacher");
		
		baseURI = "https://reqres.in/api";

		given().
		header("Content-Type","application/json").
		header("x-api-key", "reqres-free-v1").
		contentType("contentType.json").accept("application.json").
		body(Request.toJSONString()).	
		when().
		post("/users").
		then().
		statusCode(201).
		log().all();
	}
	
}
