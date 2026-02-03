package get;

import static io.restassured.RestAssured.*;
//import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APIget {
    @Test
    public void APIget1() {
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.asString());
        System.out.println(response.getBody());
        System.out.println(response.getHeader("content-type"));
        int StatusCode = response.getStatusCode();
        Assert.assertEquals(StatusCode, 200);
    }

    @Test
    public void APIget2() {
        baseURI= "https://reqres.in";
        	given()
            .when()
            .get("/api/users?page=2")
            .then()
            .statusCode(200)
            .header("content-type", "application/json; charset=utf-8")
        	.log().all();
        
    }
}