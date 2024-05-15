package RestAssuredSample;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class OauthTokenCode {

	public static void main(String[] args)
	{
		String response = given().
				formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
				formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W").
				formParams("grant_type", "client_credentials").
				formParams("scope", "trust").when().log().all().
				post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

		System.out.println(response);
		JsonPath jsonPath = new JsonPath(response);
		
		String accessToken = jsonPath.getString("access_token");
		System.out.println(accessToken);

		String r2 = given().queryParams("access_token", accessToken).
				when().log().all().
				get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").
				asString();

		System.out.println(r2);	
	}
}