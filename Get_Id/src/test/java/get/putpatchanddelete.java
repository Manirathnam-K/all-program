package get;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;


	public class putpatchanddelete {

	    // PUT request
	    @Test
	    public void putTest() {
	        JSONObject request = new JSONObject();
	        request.put("name", "morpheus");
	        request.put("job", "teacher");

	        baseURI = "https://reqres.in";

	        given()
	            .header("Content-Type", "application/json")
	            .body(request.toJSONString())
	            .header("x-api-key", "reqres-free-v1")
	        .when()
	            .put("/api/users/2")
	        .then()
	            .statusCode(200)
	            .log().all();
	    }

	    // PATCH request
	    @Test
	    public void patchTest() {
	        JSONObject request = new JSONObject();
	        request.put("job", "zion resident");

	        baseURI = "https://reqres.in";

	        given()
	            .header("Content-Type", "application/json")
	            .header("x-api-key", "reqres-free-v1")
	            .body(request.toJSONString())
	        .when()
	            .patch("/api/users/2")
	        .then()
	            .statusCode(200)
	            .log().all();
	    }

	    // DELETE request
	    @Test
	    public void delete() {
	        baseURI = "https://reqres.in";

	        given()
	            .header("Content-Type", "application/json")
	            .header("x-api-key", "reqres-free-v1")
	        .when()
	            .delete("/api/users/2")
	        .then()
	            .statusCode(204)   // No Content
	            .log().all();
	    }
	}
	

