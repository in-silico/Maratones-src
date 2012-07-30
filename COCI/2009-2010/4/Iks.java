import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Iks 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
	    	System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next()
		{
			while(st == null || !st.hasMoreTokens())
			{
				try { st = new StringTokenizer(br.readLine()); }
				catch(Exception e) { throw new RuntimeException(); }
			}
			return st.nextToken();
		}

		public int nextInt()
		{
			return Integer.parseInt(next());
		}
		
		public double nextDouble()
		{
			return Double.parseDouble(next());
		}
		
		public String nextLine()
		{
			st = null;
			try { return br.readLine(); }
			catch(Exception e) { throw new RuntimeException(); }
		}
		
		public boolean endLine()
		{
			try 
			{
				String next = br.readLine();
				while(next != null && next.trim().isEmpty())
					next = br.readLine();
				if(next == null)
					return true;
				st = new StringTokenizer(next);
				return !st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	public static void  main(String[] args)
	{
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		int[] numeros = new int[n];
		int[] primos = new int[1000001];
		for(int i = 0; i < n; i++)
			numeros[i] = sc.nextInt();
		for(int i = 0; i < n; i++)
			factorizar(numeros[i], primos);
		ArrayList <Integer> primosN = new ArrayList <Integer> ();
		ArrayList <Integer> primosV = new ArrayList <Integer> ();
		long gcd = 1;
		for(int i = 2; i < 1000001; i++)
		{
			if(primos[i] >= n)
			{
				primosN.add(i);
				for(int j = 0; j < primos[i] / n; j++)
					gcd *= i;
				primosV.add(primos[i] / n);
			}
		}
		int cuenta = 0;
		for(int i = 0; i < primosN.size(); i++)
		{
			int primo = primosN.get(i);
			int veces = primosV.get(i);
			for(int j = 0; j < n; j++)
			{
				int cuentaI = 0;
				while(numeros[j] % primo == 0)
				{
					numeros[j] /= primo;
					cuentaI++;
				}
				if(cuentaI >= veces)
					continue;
				cuenta += veces - cuentaI;
			}
		}
		System.out.println(gcd + " " + cuenta);
	}

	private static void factorizar(int i, int[] primos)
	{
		for(int j = 2; j * j <= i; j++)
		{
			while(i % j == 0)
			{
				i /= j;
				primos[j]++;
			}
		}
		if(i != 1)
			primos[i]++;
	}

}
