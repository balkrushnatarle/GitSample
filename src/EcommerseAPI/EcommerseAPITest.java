package EcommerseAPI;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;

import org.testng.Assert;

public class EcommerseAPITest {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		//Login call request
		
		String Actualmessage="Product Deleted Successfully";
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		
		
		LoginRequestPOJO loginrequest=new LoginRequestPOJO();
		loginrequest.setUserEmail("balkrushna@gmail.com");
		loginrequest.setUserPassword("Balkrushna@1995");
		
		RequestSpecification request=given().spec(req).body(loginrequest);
		LoginResponsePOJO response=request.when().post("/api/ecom/auth/login").then().extract().response().as(LoginResponsePOJO.class);
		String token=response.getToken();
		String userid=response.getUserID();
		
		//Create Product call
		
		
		RequestSpecification addproductbasereq=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorisation",token).build();
		
		RequestSpecification addproduct=given().log().all().spec(request).
		param(" productName", " laptop").
		param("productAddedBy", userid).
		param("productCategory", "fashion").
		param("productSubCategory", "shirts").
		param("productPrice", "11500").
		param("productDescription", "Addidas Originals").
		param("productFor", "women").multiPart("productImage",new File("Pictures//nature.png"));
		
		String  addproductresponse=addproduct.when().post("/api/ecom/product/add-product").then().extract().response().asString();
		JsonPath path=new JsonPath(addproductresponse);
		
		String message=path.getString("productId");
		String productid=path.getString("message");
		
	//create order
		
		RequestSpecification createorderreq=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorisation",token).setContentType(ContentType.JSON).build();
		
		
		OrdersPOJO orderdetails=new OrdersPOJO();
		orderdetails.setCountry("india");
		orderdetails.setProductOrderedId(productid);
		
		
		
		CreateOrderPOJO order=new CreateOrderPOJO();
		ArrayList<OrdersPOJO>orderlist=new ArrayList<OrdersPOJO>();
		orderlist.add(orderdetails);
		
		order.setOrders(orderlist);
		
		
		RequestSpecification createorder=given().spec(createorderreq).body(order);
		
		String createorderresponse=createorder.when().post("/api/ecom/order/create-order").then().extract().response().asString();
		
		JsonPath js=new JsonPath(createorderresponse);
		String orderid=js.getString("orders");
		
		//view order
		
		
		//deleting product
		
		RequestSpecification delete=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorisation",token).build();
		
		RequestSpecification deletereq=given().spec(delete).pathParam("productId", productid);
		
		String deleteresponse=deletereq.when().delete("/api/ecom/product/delete-product/{productID}").then().statusCode(200).extract().response().asString();
		
		JsonPath js2=new JsonPath(deleteresponse);
		String expectedresponsemsg=js2.getString(message);
		
		Assert.assertEquals(Actualmessage,expectedresponsemsg);
		
		
		
		
	
		
		
		
		

	}

}
