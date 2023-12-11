package EcommerseAPI;

import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class EcommerceAPI {

	public static void main(String[] args) 
	{
RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		
		
		LoginRequestPOJO loginrequest=new LoginRequestPOJO();
		loginrequest.setUserEmail("balkrushna@gmail.com");
		loginrequest.setUserPassword("Balkrushna@1995");
		
		RequestSpecification request=given().spec(req).body(loginrequest);
		LoginResponsePOJO response=request.when().post("/api/ecom/auth/login").then().extract().response().as(LoginResponsePOJO.class);
		
	
		
		
		
		

	}

}
