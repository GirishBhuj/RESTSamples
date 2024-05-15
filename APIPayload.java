package RestAssuredSample;

public class APIPayload
{
	public static String AddPlaceJsonPaylod(double mLat, double mLng, String mName, String mLanguage)
	{
		return "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -"+mLat+",\r\n" + 
				"    \"lng\": -"+mLng+"\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \""+mName+"\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"3423, side layout, cohen 39\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://rahulshettyacademy.com\",\r\n" + 
				"  \"language\": \""+mLanguage+"\"\r\n" + 
				"}\r\n" + 
				"";
	}
	
	public static String CourseJson()
	{
		//Refer REST_API_SampleJson.json for details Json content
		return "{\r\n" + 
				"  \"dashboard\": {\r\n" + 
				"    \"purchaseAmount\": 1162,\r\n" + 
				"    \"website\": \"rahulshettyacademy.com\"\r\n" + 
				"  },\r\n" + 
				"  \"courses\": [\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"Selenium Python\",\r\n" + 
				"      \"price\": 50,\r\n" + 
				"      \"copies\": 6\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"Cypress\",\r\n" + 
				"      \"price\": 40,\r\n" + 
				"      \"copies\": 4\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"RPA\",\r\n" + 
				"      \"price\": 45,\r\n" + 
				"      \"copies\": 10\r\n" + 
				"    },\r\n" + 
				"     {\r\n" + 
				"      \"title\": \"Appium\",\r\n" + 
				"      \"price\": 36,\r\n" + 
				"      \"copies\": 7\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    \r\n" + 
				"    \r\n" + 
				"  ]\r\n" + 
				"}\r\n" + 
				"";
	}
	
	public static String CourseDtls()
	{
		return "{\r\n"
				+ "    \"instructor\": \"RahulShetty\",\r\n"
				+ "    \"url\": \"rahulshettycademy.com\",\r\n"
				+ "    \"services\": \"projectSupport\",\r\n"
				+ "    \"expertise\": \"Automation\",\r\n"
				+ "    \"courses\": {\r\n"
				+ "        \"webAutomation\": [\r\n"
				+ "            {\r\n"
				+ "                \"courseTitle\": \"Selenium Webdriver Java\",\r\n"
				+ "                \"price\": \"50\"\r\n"
				+ "            },\r\n"
				+ "            {\r\n"
				+ "                \"courseTitle\": \"Cypress\",\r\n"
				+ "                \"price\": \"40\"\r\n"
				+ "            },\r\n"
				+ "            {\r\n"
				+ "                \"courseTitle\": \"Protractor\",\r\n"
				+ "                \"price\": \"40\"\r\n"
				+ "            }\r\n"
				+ "        ],\r\n"
				+ "        \"api\": [\r\n"
				+ "            {\r\n"
				+ "                \"courseTitle\": \"Rest Assured Automation using Java\",\r\n"
				+ "                \"price\": \"50\"\r\n"
				+ "            },\r\n"
				+ "            {\r\n"
				+ "                \"courseTitle\": \"SoapUI Webservices testing\",\r\n"
				+ "                \"price\": \"40\"\r\n"
				+ "            }\r\n"
				+ "        ],\r\n"
				+ "        \"mobile\": [\r\n"
				+ "            {\r\n"
				+ "                \"courseTitle\": \"Appium-Mobile Automation using Java\",\r\n"
				+ "                \"price\": \"50\"\r\n"
				+ "            }\r\n"
				+ "        ]\r\n"
				+ "    },\r\n"
				+ "    \"linkedIn\": \"https://www.linkedin.com/in/rahul-shetty-trainer/\"\r\n"
				+ "}";
	}
}