package RestAssuredSample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParsing {

	public static void main(String[] args)
	{
		JsonPath mJs = new JsonPath(APIPayload.CourseDtls());


		int mCourseCount = mJs.getInt("courses.size()");
		System.out.println("mCourseCount: "+ mCourseCount);
		
		int mPurchaseAmt = 0;
		//mPurchaseAmt = mJs.getInt("dashboard.purchaseAmount");
		//System.out.println("Purchse Amount: "+ mPurchaseAmt);

		 //courses[0].title
		 //courses[0].price
		 //courses[0].copies
		int TotalSoldAmount,mCourseAmt;
		TotalSoldAmount=0;
	
		String mCourseTitle="";

	    try {
            JSONObject jsonObject = new JSONObject(APIPayload.CourseDtls().toString());
            List<String> keys = getAllKeys(jsonObject);
            for (String key : keys) {
                System.out.println("Key: "+ key);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
		
		
		System.out.println("=============");
		/* System.out.println(mJs.get("courses.webAutomation[0].courseTitle"));
		System.out.println(mJs.get("courses.webAutomation[1].courseTitle"));
		System.out.println(mJs.get("courses.webAutomation[2].courseTitle"));
		System.out.println(mJs.get("courses.webAutomation[0].price"));
		*/
		
		for (int mCount=0; mCount < mCourseCount;mCount++)
		{
			  mCourseTitle=mJs.get("courses.webAutomation["+mCount+"].courseTitle");

			  System.out.println("Course Title: "+mCourseTitle + 
					  ", Price: " + mJs.get("courses.webAutomation["+mCount+"].price").toString());
			  
			  mCourseAmt = mJs.getInt("courses.webAutomation["+mCount+"].price") * mCount;
			  TotalSoldAmount = TotalSoldAmount + mCourseAmt;
		}
		
		System.out.println("=============");
		System.out.println("Total Sold Amount: "+TotalSoldAmount + " Purchase amount:"+mPurchaseAmt);
		//Assert.assertEquals(TotalSoldAmount, mPurchaseAmt);
	}

	public static List<String> getAllKeys(JSONObject jsonObject) throws JSONException {
        List<String> keys = new ArrayList<>();
        Iterator<?> iterator = jsonObject.keys();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            keys.add(key);
            Object value = jsonObject.get(key);
            if (value instanceof JSONObject) {
                keys.addAll(getAllKeys((JSONObject) value));
            } else if (value instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) value;
                for (int i = 0; i < jsonArray.length(); i++) {
                    Object arrayValue = jsonArray.get(i);
                    if (arrayValue instanceof JSONObject) {
                        keys.addAll(getAllKeys((JSONObject) arrayValue));
                    }
                }
            }
        }
        return keys;
    }
}