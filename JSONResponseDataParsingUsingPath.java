package RestAssuredSample;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;



public class JSONResponseDataParsingUsingPath {

	//@Test(priority=1)
	void testJsonResponse()
	{
		//Appoach1	
		/* given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/store")
		
		.then()
			.statusCode(200)
			.header("Content-Type","application/json")
			.body("book[3].title",equalTo("The Lord of the Rings"))
			.log().all();
		*/

		//Approach2
		Response res= 	given()
						.contentType(ContentType.JSON)
						.when()
						.get("http://localhost:3000/store")
						.then().log().all().extract().response();
		
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"),"application/json");

		String bookname=res.jsonPath().get("book[3].title").toString();
		Assert.assertEquals(bookname,"The Lord of the Rings");		
	}

	@Test(priority=2)
	void JsonDataParsing()
	{
        String jsonString = "{ \"instructor\": \"RahulShetty\", \"url\": \"rahulshettycademy.com\", \"services\": \"projectSupport\","
        		+ " \"expertise\": \"Automation\", \"courses\": { \"webAutomation\": [ { \"courseTitle\": \"Selenium Webdriver Java\", "
        		+ "\"price\": \"50\" }, { \"courseTitle\": \"Cypress\", \"price\": \"40\" }, { \"courseTitle\": \"Protractor\", \"price\": "
        		+ "\"40\" } ], \"api\": [ { \"courseTitle\": \"Rest Assured Automation using Java\", \"price\": \"50\" }, { \"courseTitle\":"
        		+ " \"SoapUI Webservices testing\", \"price\": \"40\" } ], \"mobile\": [ { \"courseTitle\": \"Appium-Mobile Automation using"
        		+ " Java\", \"price\": \"50\" } ] }, \"linkedIn\": \"https://www.linkedin.com/in/rahul-shetty-trainer/\" }";

        JsonPath jsonPath = new JsonPath(jsonString);

        System.out.println("Book title : " + jsonPath.getString("courses.webAutomation[1].courseTitle"));
        System.out.println("Price : " + jsonPath.getString("courses.webAutomation[1].price"));
        
	}
	
	//@Test(priority=2)
	void testJsonResponseBodyData()
	{	
		Response res=
				given()
					.contentType(ContentType.JSON)
				.when()
					.get("http://localhost:3000/store");

		//using JSONObject class
		JSONObject jo=new JSONObject(res.asString()); //converting response to JSON Object
		
		//print all titles of books
		/*for(int i=0; i<jo.getJSONArray("book").length();i++)
		{
			String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(bookTitle);
		}*/
		
		//search for title of the book in json  - validation 1
		boolean status=false;
		
		for(int i=0; i<jo.getJSONArray("book").length();i++) {
			String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			
			if(bookTitle.equals("The Lord of the Rings"))
			{
				status=true;
				break;
			}
		}
		
		Assert.assertEquals(status,true);
		
		
		//validate total price of books   - validation 2
		
		double totalprice=0;
		for(int i=0; i<jo.getJSONArray("book").length();i++) {
			String price=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
			
			totalprice=totalprice+Double.parseDouble(price);
		}
		
		System.out.println("total price of books is:"+ totalprice);
		Assert.assertEquals(totalprice,53.92);	
	}	
}