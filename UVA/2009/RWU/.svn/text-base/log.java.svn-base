package UVA;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class log
{
	
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			if(n == 1)
			{
				System.out.println("0 0.00000000");
				continue;
			}
			int l = (int) Math.ceil(Math.log((n + 0.0) / 2));
			if(n == 2)
				l++;
			double x = 1 - ((n + 0.0) / (Math.exp(l)));
			long l1 = Math.round(x * 100000000);
			String s = Math.abs(l1) + "";
			while(s.length() < 9)
			{
				s = "0" + s;
			}
			System.out.println(l + " " + (l1 < 0 ? "-" : "") + s.substring(0, 1) + "." + s.substring(1));
		}
	}

}
