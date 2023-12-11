package POJO;




import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.List;





public class outh {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		String url="https://rahulshettyacademy.com/getCourse.php?code=4%2F0AfJohXkStGWkHRANG3bj2gnu0XniPRfGdUejL2KyVHNfaFrY9lr_4uVJ4pJkZ1ZPyN62Wg&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none";		
		String str=url.split("code=")[1];
		String str1=str.split("&scope")[0];
		System.out.println(str1);
		
		String accessToknResponse=given().log().all().urlEncodingEnabled(false).
		queryParam("code", str1).
		queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
		queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").
		queryParam("redirect_uri","https://rahulshettyacademy.com/getCourse.php").
		queryParam("grant_type", "authorization_code").
		when().post("https://www.googleapis.com/oauth2/v4/token").then().log().all().extract().response().asString();
		
		JsonPath js=new JsonPath(accessToknResponse);
		String accesstoken=js.getString("access_token");
		System.out.println(accesstoken);
		
		
		
		getcoursepojo response=given().queryParam("access_token", accesstoken).expect().defaultParser(Parser.JSON).
		when().get("https://rahulshettyacademy.com/getCourse.php").as(getcoursepojo.class);
		
		System.out.println(response.getLinkedin());
		
		System.out.println(response.getInstructor());
		
		System.out.println(response.getCourses().getApi().get(1).getCourseTitle());
		
		List<Api> apicourses=response.getCourses().getApi();
		for(int i=0;i<apicourses.size();i++)
			
		{
			if(apicourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
					{
				System.out.println(apicourses.get(i).getPrice());
					}
					
		}
		
		
	}

}
