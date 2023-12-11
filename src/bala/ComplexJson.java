package bala;

import APIAutomation.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJson {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		JsonPath js=new JsonPath(payload.courseprice());
		
		//count the no of courses from response
		
		int size=js.getInt("courses.size()");
		System.out.println(size);
		
		//print the purchase amount from response
		
		int purchaseamount=js.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseamount);
		
		//print title of the first course from response
		
		String firsttitle=js.getString("courses[0].title");
		System.out.println(firsttitle);
		
		//print no of copy sold by RPA course from response
		
		int rpacopy=js.getInt("courses[2].copies");
		System.out.println(rpacopy);
		
		//Print All course titles and their respective Prices from response
		
		for(int i=0;i<size;i++)
		{
			String title=js.getString("courses["+i+"].title");
			
			int price=js.getInt("courses["+i+"].price");
			
			System.out.println(title);
			System.out.println(price);
			
			
		}
		
		
		//print no of copy sold by All RPA course from response
		for(int j=0;j<size;j++)
		{
		
			String title1=js.getString("courses["+j+"].title");
			if(title1.equalsIgnoreCase("RPA"))
			{
				int copy=js.get("courses["+j+"].copies");
				System.out.println(copy);
				
			}
			
		}

	}

}
