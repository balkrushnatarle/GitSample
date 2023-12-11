package sample;

public class sample1 
{
	
	
	public static boolean display(int i)
	{
		String number=String.valueOf(i);
		
		if(number.length()!=3)
		{
			return false;
		}
		
		int firstDigit=Character.getNumericValue(number.charAt(0));
		int secondDigit=Character.getNumericValue(number.charAt(1));
		int thirdDigit=Character.getNumericValue(number.charAt(2));
		return thirdDigit==(firstDigit+secondDigit);
	}

	
	

	public static void main(String[] args) 
	{
		for(int i=0;i<=200;i++)
		{
			if(display(i))
			{
				System.out.println(i);
			}
		}

	}

}
