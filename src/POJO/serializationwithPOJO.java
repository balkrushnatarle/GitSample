package POJO;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class serializationwithPOJO
{

	public static void main(String[] args) 
	{
		AddPlacePojo add=new AddPlacePojo();
		add.setAccuracy(50);
		add.setName("Frontline house");
		add.setPhone_number("(+91) 983 893 3937");
		add.setAddress("29, side layout, cohen 09");
		add.setWebsite("http://google.com");
		add.setLanguage("French-IN");
		LocationPojo lat=new LocationPojo();
		add.setLocation(lat);
		List<String>str=new ArrayList<String>();
		str.add("shoe park");
		str.add("shop");
		add.setTypes(str);
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().queryParam("key","qaclick123").header("Content-Type","application/json").
		body(add).when().post("/maps/api/place/add/json").then().assertThat().statusCode(200);

	}

}
