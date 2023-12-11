package POJO;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

public class Specbuilderexample
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
		
		
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
		addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		
		
		given().spec(req).
		body(add);
		
		ResponseSpecification res=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		
		when().post("/maps/api/place/add/json").then().spec(res);

	}

}
