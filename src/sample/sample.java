package sample;

import java.util.HashSet;
import java.util.Set;

public class sample 
{
	int number;
	String firstdigit=" ";
	String seconddigit=" ";
	String thirddigit=" ";
	String result;
	String result1;
	public void number()
	{
	
		
		
		for(int i=0;i<200;i++) 
		{
			
			String str=String.valueOf(i);
			if(str.length()==3)
			{
				
				
				int firstdigit=Character.getNumericValue(str.charAt(0));
				int seconddigit=Character.getNumericValue(str.charAt(1));
				int thirddigit=firstdigit+seconddigit;
				
				String result=firstdigit+""+seconddigit+""+thirddigit;
				
				
				System.out.println(result);
		
				
			}
	
		}
		
	}
	public static void main(String args[])
	{
		sample s=new sample();
		s.number();
	}
}
