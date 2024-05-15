package RestAssuredSample;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ReadJSONFile {

	public static void main(String[] args) throws IOException
	{		
		//Add address
		RestAssured.baseURI = "https://www.rahulshettyacademy.com";
		
		String mJsonFilePath = System.getProperty("user.dir")+"\\src\\resources\\"
				+ "AddPlaceJSON.json";
		
		String mResponse =
				given()
					.log()
					.all()
					.queryParam("key", "qaclick123")
					.header("Content-Type","application/json")
					.body(new String(Files.readAllBytes(Paths.get(mJsonFilePath))))
				.when()
					.post("maps/api/place/add/json")
				.then()
					.log()
					.all()
					.assertThat()
					.statusCode(200)
					.body("scope", equalTo("APP"),"status",equalTo("OK"))
					.header("server", "Apache/2.4.52 (Ubuntu)")
					.extract()
					.response()
					.asString();
	 
		//Extract Place ID from response
		System.out.println("Response "+mResponse);
		
		//JsonPath mJson = new JsonPath(mResponse);
		JsonPath mJson = CommonMethods.JsonParsing(mResponse);
		String mPlaceID = mJson.getString("place_id");
		String mRef = mJson.getString("reference");
		
		System.out.println("Response PlaceID "+mPlaceID);
		System.out.println("Response Reference "+mRef);
	}
}