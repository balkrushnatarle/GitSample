package APIAutomation;

import io.restassured.path.json.JsonPath;

public class reusable 
{
public static JsonPath rowtojson(String response)
{

	JsonPath js=new JsonPath(response);
	return js;
	
	
}
}
