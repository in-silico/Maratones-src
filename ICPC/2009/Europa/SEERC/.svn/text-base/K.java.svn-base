import java.util.Scanner;


public class K 
{
	static int n, k;
	
	public static int solucion(int m, int e)
	{
		if(n == 1)
			return -1;
		if(m == 0)
			return e % n != 0 ? 0 : -1;
		if(m == 1)
			return (e + 1) % n != 0 ? 1 : -1;
		if(k == 1)
			return (m + e) % n != 0 ? m : -1;
		if(m <= k)
		{
			if(n == 2)
			{
				if(m % 2 == 0)
				{
					if(e % 2 == 0)
						return -1;
					else
						return 2;
				}
				else
				{
					if(e % 2 == 0)
						return 1;
					else
						return -1;
				}
			}
			else
			{
				if(m % n == 0)
				{
					if((e + 2) % n == 0)
						return 3;
					else
						return 2;
				}
				else
				{
					if((e + 1) % n == 0)
						return 2;
					else
						return 1;
				}
			}
		}
		else
		{
			int mejor = -1;
			int primero = k;
			for(int i = 0; i < 100000 && primero > 0; i++, primero--)
			{
				if(primero % n == 0)
					continue;
				int div = m / primero;
				int res = solucion(m % primero, div);
				if(m % primero + 1 <= k && primero != 1 && (primero - 1) % n != 0)
				{
					int res1 = solucion(m % primero + 1, div);
					if(res1 != -1 && (res == 0 || res1 < res))
						res = res1;
				}
				if(res != -1 && (mejor == -1 || res + div < mejor))
					mejor = res + div;
			}
			return mejor;
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int caso = 0; caso < t; caso++)
		{
			n = sc.nextInt();
			int m = sc.nextInt();
			k = sc.nextInt();
			System.out.println(solucion(m, 0));
		}
	}
}