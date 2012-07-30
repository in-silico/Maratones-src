package UVA;

import java.io.IOException;
import java.util.Scanner;

public class primary 
{
	public static void reverse(char[] b) 
	{
		   int left  = 0;          // index of leftmost element
		   int right = b.length-1; // index of rightmost element
		  
		   while (left < right) {
		      // exchange the left and right elements
		      char temp = b[left]; 
		      b[left]  = b[right]; 
		      b[right] = temp;
		     
		      // move the bounds toward the center
		      left++;
		      right--;
		   }
	}

	
	public static void main(String [] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			char [] n1 = (sc.nextLong() + "").toCharArray();
			char [] n2 = (sc.nextLong() + "").toCharArray();
			if(n1[0] == '0' && n1.length == 1 && n2[0] == '0' && n2.length == 1 && !sc.hasNextLong())
			{
				return;
			}
			reverse(n1);
			reverse(n2);
			int min = Math.min(n1.length, n2.length);
			int carry = 0;
			int acum = 0;
			for(int i = 0; i < min; i++)
			{
				int res = n1[i] + n2[i] + carry - '0' - '0';
				carry = res >= 10 ? 1 : 0;
				if(carry > 0)
					acum++;
			}
			if(n1.length > n2.length)
			{
				for(int i = n2.length; i < n1.length; i++)
				{
					carry = n1[i] + carry - '0' >= 10 ? 1 : 0;
					if(carry > 0)
						acum++;
				}
			}
			else if(n2.length > n1.length)
			{
				for(int i = n1.length; i < n2.length; i++)
				{
					carry = n2[i] + carry - '0' >= 10 ? 1 : 0;
					if(carry > 0)
						acum++;
				}
			}
			if(acum == 0)
			{
				System.out.println("No carry operation.");
			}
			else if(acum == 1)
			{
				System.out.println("1 carry operation.");
			}
			else
			{
				System.out.println(acum + " carry operations.");
			}
 		}
	}

}
