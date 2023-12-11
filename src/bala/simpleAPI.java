package bala;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.Assert.*;

import APIAutomation.payload;
import APIAutomation.reusable;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class simpleAPI {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String str=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(new String(Files.readAllBytes(Paths.get("D:\\balkrushna\\DemoProject\\src\\jsonfile\\addplace.json"))))
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		JsonPath js=new JsonPath(str);
		String placeid=js.getString("place_id");
		System.out.println(placeid);
		String newaddress="nashik maharashtra india 422003";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\r\n"
				+ "    \"place_id\":\""+placeid+"\",\r\n"
				+ "    \"address\":\""+newaddress+"\",\r\n"
				+ "    \"key\":\"qaclick123\"\r\n"
				+ "    }")
		.when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		
		
		String getresponse=given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id",placeid).when().get("maps/api/place/get/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1=reusable.rowtojson(getresponse);
		String actualaddress=js1.getString("address");
		System.out.println(actualaddress);
		
		Assert.assertEquals(actualaddress, newaddress);
		
		
		
	}

}
