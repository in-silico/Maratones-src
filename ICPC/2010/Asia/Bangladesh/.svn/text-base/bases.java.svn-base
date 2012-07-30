import java.util.ArrayList;
import java.util.Scanner;


public class bases
{
	static int[] primos =
	{	     
			  2,      3,      5,      7,     11,     13,     17,     19,     23,     29, 
		     31,     37,     41,     43,     47,     53,     59,     61,     67,     71, 
		     73,     79,     83,     89,     97,    101,    103,    107,    109,    113, 
		    127,    131,    137,    139,    149,    151,    157,    163,    167,    173, 
		    179,    181,    191,    193,    197,    199,    211,    223,    227,    229, 
		    233,    239,    241,    251,    257,    263,    269,    271,    277,    281, 
		    283,    293,    307,    311,    313,    317,    331,    337,    347,    349, 
		    353,    359,    367,    373,    379,    383,    389,    397,    401,    409, 
		    419,    421,    431,    433,    439,    443,    449,    457,    461,    463, 
		    467,    479,    487,    491,    499
	};
	
	static class Primo
	{
		int p;
		int cuenta;
		long b;
		
		public Primo(int p, int cuenta, long b) {
			this.p = p;
			this.cuenta = cuenta;
			this.b = b;
		}
	}
	
	public static long numeroBases(long m, long n)
	{
		long numero = 1;
		long suma = 0;
		long actual = 0;
		while((actual = (n / (numero *= m))) > 0)
			suma += actual;
		return suma;
	}
	
	public static ArrayList <Primo> buscar(long n, long k)
	{
		ArrayList <Primo> encontrados = new ArrayList <Primo> ();
		for(int p : primos)
		{
			if(p > n)
				break;
			long b = numeroBases(p, n);
			long f = b / k;
			long i = f;
			int cuenta = 0;
			if(f != 0)
			{
				while(i != 0 && (b / i--) == k)
					cuenta++;
				encontrados.add(new Primo(p, cuenta, f));
			}
		}
		return encontrados;
	}
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++)
		{
			long acum = 0;
			ArrayList <Primo> posibles = buscar(sc.nextLong(), sc.nextLong());
			for(Primo p : posibles)
			{
				long acumTemp = 1;
				for(Primo q : posibles)
				{
					if(p.p != q.p)
					{
						acumTemp *= (q.b + 1);
						acumTemp %= 1000000007L;
					}
				}
				acumTemp *= p.cuenta;
				p.b -= p.cuenta;
				acumTemp %= 1000000007L;
				acum += acumTemp;
				acum %= 1000000007L;
			}
			System.out.println("Case " + i + ": " + acum);
		}

	}
}
