package bala;
import org.testng.Assert;

import APIAutomation.payload;
import io.restassured.path.json.JsonPath;

public class sumvalidation 
{
	//Verify if Sum of all Course prices matches with Purchase Amount
	
	public static void main(String args[])
	{
	
		
		int sum=0;
	
		JsonPath js=new JsonPath(payload.courseprice());
		int count=js.getInt("courses.size()");
		int purchaseamount=js.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseamount);
		
		for(int i=0;i<count;i++)
		{
			int price=js.getInt("courses["+i+"].price");
			int copies=js.getInt("courses["+i+"].copies");
			int amount=price*copies;
			System.out.println(amount);
			
			sum=sum+amount;
		
			
		}
		System.out.println(sum);
		Assert.assertEquals(purchaseamount,sum);
		
	}
		
	
}