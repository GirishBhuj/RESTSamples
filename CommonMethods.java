package RestAssuredSample;

import io.restassured.path.json.JsonPath;

public class CommonMethods
{
	public static JsonPath JsonParsing(String mResponse)
	{
		JsonPath mParsedJson = new JsonPath(mResponse);
		return mParsedJson;
	}
}