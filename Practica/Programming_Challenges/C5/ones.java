package UVA;

import java.util.Scanner;

public class ones
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt())
		{
			int a = sc.nextInt();
			if(a == 0)
				continue;
			int l = 1;
			int k = 1;
			int n = 1;
			while(n < 20000)
			{
				l = k % a;
				if(l == 0)
				{
					System.out.println(n);
					break;
				}
				k = l * 10 + 1;
				n++;
			}
		}
	}
}
