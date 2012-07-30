package UVA;

import java.util.Scanner;

public class soda 
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		for(int j = 0; j < i; j++)
		{
			int a = sc.nextInt() + sc.nextInt();
			int c = sc.nextInt();
			int num = 0;
			while(a >= c)
			{
				int t = a / c;
				num += t;
				a %= c;
				a += t;
			}
			System.out.println(num);
		}
	}
}