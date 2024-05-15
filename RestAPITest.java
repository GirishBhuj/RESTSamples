package RestAssuredSample;

import io.restassured.RestAssured;
import io.restassured.path.json.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class RestAPITest {

	public static void main(String[] args)
	{
		//given - All input details
		//when - Submit the API - resource, http method
		//Then - validate the response
		
		//Add address
		RestAssured.baseURI = "https://www.rahulshettyacademy.com";
		
		String mResponse = 
			given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type","application/json")
				.body(APIPayload.AddPlaceJsonPaylod
						(38.383494, 33.427362, "Sanjay Kawade", "Marathi"))
			.when().post("maps/api/place/add/json")
			.then().log().all().assertThat().statusCode(200).
		body("scope", equalTo("APP"),"status",equalTo("OK"))
		.header("server", "Apache/2.4.52 (Ubuntu)")
		.extract().response().asString();
		
		//Convert string to Json and parse Json response
		//JsonPath mPayloadReq = new JsonPath(APIPayload.AddPlaceJsonPaylod());
		JsonPath mPayloadReq = CommonMethods.JsonParsing(APIPayload.
				AddPlaceJsonPaylod(38.383489, 33.427343, "Sanjay Kawade", "Marathi"));
	
		// Dot used after location as lng is under location
		float mLangitude = mPayloadReq.get("location.lng"); 
		
		// Dot used after location as lat is under location
		float mLitude = mPayloadReq.get("location.lat"); 
		String mPhoneNumber = mPayloadReq.getString("phone_number");
		String mName = mPayloadReq.getString("name");
		
		/*
		System.out.println("Input Json Langitude "+mLangitude);
		System.out.println("Input Json Litude "+mLitude);
		System.out.println("Input Json Phone number "+mPhoneNumber);
		System.out.println("Input Json Name "+mName);
		*/		
		
		//Extract Place ID from response
		System.out.println("Response "+mResponse);
		
		//JsonPath mJson = new JsonPath(mResponse);
		JsonPath mJson = CommonMethods.JsonParsing(mResponse);
		String mPlaceID = mJson.getString("place_id");
		String mRef = mJson.getString("reference");
		
		//System.out.println("Response PlaceID "+mPlaceID);
		//System.out.println("Response Reference "+mRef);
		
		
		//Update address
		String newAddress = "162, Ganesh peth, Pune";
		
		given().log().all().queryParam("key", "qaclick123").
		header("Content-Type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+mPlaceID+"\",\r\n" + 
				"\"address\":\""+newAddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}")
		.when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).
		body("msg", equalTo("Address successfully updated"));

		//Get address
		String mGetPlaceResponse = given().log().all()
				.queryParam("key", "qaclick123")
				.queryParam("place_id",mPlaceID)
				.when().get("maps/api/place/get/json")
				.then().assertThat().log().all().statusCode(200).
				extract().response().asString();
		
		//Parsing above Get requests Json path
		//JsonPath mJsonResponse=new JsonPath(mGetPlaceResponse);
		JsonPath mJsonResponse = CommonMethods.JsonParsing(mGetPlaceResponse);
			    
		JsonPath   js = new JsonPath(mGetPlaceResponse);
		String value = js.get("location.longitude").toString();
		System.out.println("Value "+ value);
		
		String actualAddress =mJsonResponse.getString("address");
		//System.out.println(actualAddress);
	
		Assert.assertEquals(actualAddress, newAddress);

		//System.out.println(mGetPlaceResponse);
	}
}