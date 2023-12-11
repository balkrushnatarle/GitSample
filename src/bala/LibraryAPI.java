package bala;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import APIAutomation.payload;
import APIAutomation.reusable;

public class LibraryAPI {

	@Test(dataProvider="booksdata")
	public static void addapi(String str,String str1)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().header("Content-Type","application/json").
		body(payload.addbook(str,str1)).
		when().post("Library/Addbook.php").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		
		JsonPath js=reusable.rowtojson(response);
		String id=js.get("ID");
		System.out.println(id);
		
		
		
		given().queryParam("ID",id).
		when().get("Library/GetBook.php")
		.then().log().all().statusCode(200);
		
		
		
	
			given().header("Content-Type","application/json").body(payload.deletebook(id)).
			when().post("Library/DeleteBook.php").
			then().log().all().assertThat().statusCode(200).extract().response().asString();
			
	
			
			
			
			
		
		
		}
	
	@DataProvider(name="booksdata")
	public Object[][] getdata()
	{
		return new Object[][] {{"vishal","01"},{"vishal","02"},{"vishal","03"},{"vishal","04"}};
		
	}
	
	//@Test(dataProvider="booksdata")
	

}
