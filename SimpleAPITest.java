package RestAssuredSample;

import static io.restassured.RestAssured.given;

import com.jayway.jsonpath.JsonPath;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SimpleAPITest {

	public static void main(String[] args) throws InterruptedException
	{
		JsonObject mBody = new JsonObject();
		mBody.add("user", "girish");
		//mBody.get("user")
		int mEmpID = 124;

		String sessionId ="sfdelkjelr";
		
		/*
		Response response = 
				given()
	    		  	.baseUri("http://www.example.com")
	    		  	.auth()
					.basic("postman", "password")
	                .contentType(ContentType.JSON)
	                .pathParam("path", "value")
	                .formParam("formParam1", "value1")
	                .queryParam("queryParam1", "queryValue1")
	                .header("header1", "Bearer yourAccessToken")
	                .cookie("sessionId", sessionId)
	                .body(mBody.toString())
				.when()
	                .post("/endpoint/{employeeID}",mEmpID)
	            .then()
	                .assertThat()
	                .statusCode(200)
	                .extract()
	                .response();

	    String resp=response.asString();
		JsonPath   js = new JsonPath(resp);
		return js.get(key).toString();
		*/
		
		
		
		/* Response response = given()
    		  	.baseUri("http://rahulshettyacademy.com")
                .contentType(ContentType.JSON)
                .queryParam("place_id", "919d3a23c3ad8af7f4445147678ae1de")
                .queryParam("key", "qaclick123")
                .body(mBody.toString())
                .when()
                .get("maps/api/place/get/json")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

		String resp=response.asString();
		JsonPath   js = new JsonPath(resp);
		return js.get(key).toString();

			System.out.println(response.getStatusCode());
			System.out.println(response.getHeader("server"));

			*/
		
		// https://goessner.net/articles/JsonPath/index.html#e2

		
		/* String response = given().
				formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
				formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W").
				formParams("grant_type", "client_credentials").
				formParams("scope", "trust")
				.when()
					//.log()
					//.all()
					.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		
		String accessToken = JsonPath.read(response,"access_token");
		String r2 = given().queryParams("access_token", accessToken).
				when()
				//.log()
				//.all()
				.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
				.asString();	

		String price = JsonPath.read(r2,"$.courses.mobile[0].price"); // Using Path expr
		System.out.println("Book value: "+ price);
		*/
		
		/*
			given()
				.contentType("application/json")
				.body(data.toString()
			.when()
				.post("http://localhost:3000/students")
			.then()
				.statusCode(201)
				.body("name",equalTo("Scott"))
				.body("courses[0]",equalTo("C"))
				.body("courses[1]",equalTo("C++"))
				.header("Content-Type","application/json; charset=utf-8")
				.log()
				.all(); 
		 */
		
		// Basic auth

		try
		{
		String response = given()
				.auth()
				.basic("postman", "password")
				.when()
				.get("https://postman-echo.com/basic-auth")
				.then().assertThat().statusCode(200).extract().response().asString();
	
		System.out.println(response);

		//String mstr = JsonPath.read(response,".");

		}
		catch (AssertionError ae) {
			System.out.println("Assertion error "+ ae.getMessage());
		}

	}
}
