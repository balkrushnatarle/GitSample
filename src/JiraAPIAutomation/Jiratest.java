package JiraAPIAutomation;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.Assert;

import APIAutomation.reusable;

public class Jiratest {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		RestAssured.baseURI="http://Localhost:8080";
		
		//creating session API
		
		SessionFilter session=new SessionFilter();
		String response=given().header("Content-Type","application/json").log().all().body("{ \"username\": \"balatarle\",\r\n"
				+ " \"password\": \"Balkrushna@1995\" \r\n"
				+ " }").filter(session).
		when().post("/rest/auth/1/session").then().log().all().assertThat().statusCode(200).extract().response().asString();
		

		//Add Comment
		
		String expectedmessage="welcome to jira";
		
		String addcomment=given().log().all().header("Content-Type","application/json").pathParams("key","10000").body("{\r\n"
				+ "    \"body\": \""+expectedmessage+"\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(session).
		when().post("/rest/api/2/issue/{key}/comment").then().assertThat().statusCode(201).log().all().extract().response().asString();
		JsonPath js1=reusable.rowtojson(addcomment);
		String commentid=js1.get("id").toString();
		System.out.println(commentid);
		
		
		//Add Attachement
		
		given().log().all().header("X-Atlassian-Token","no-check").filter(session).
		header("Content-Type","multipart/form-data").pathParam("key","10000").
		multiPart("file",new File("D:\\balkrushna\\DemoProject\\src\\jsonfile\\bala.txt")).when().
		post("/rest/api/2/issue/{key}/attachments").then().log().all().statusCode(200);
		
		
		//Get Issue
		
		String issuedetail=given().filter(session).pathParam( "key", "10000").queryParam("fields", "comment").log().all().
		when().get("/rest/api/2/issue/{key}").
		then().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js=reusable.rowtojson(issuedetail);
		
		//comparing our comment id present in GET method response
		
		int size=js.getInt("fields.comment.comments.size()");
		for(int i=0;i<size;i++)
		{
			String issueid=js.get("fields.comment.comments["+i+"].id").toString();
			if(issueid.equalsIgnoreCase(commentid))
			{
				String message=js.get("fields.comment.comments["+i+"].body").toString();
				System.out.println(message);
				Assert.assertEquals(expectedmessage, message);
				
			}
		}
		
		

	}

}
