import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.StringTokenizer;


public class D 
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
	
	static int n;
	static HashSet <Integer> numeros = new HashSet <Integer> ();
	static int k;
	static int[] coeficientes = new int[20];
	
	static long modpow(int a, int b)
	{
		if(b == 0)
			return 1;
		if(b == 1)
			return a;
		long res = modpow(a, b / 2);
		res *= res;
		res %= n;
		return ((b & 1) == 1 ? res * a : res) % n;
	}
	
	static int evaluar(int x)
	{
		long res = 0;
		for(int i = 0; i <= k; i++)
		{
			long parcial = coeficientes[i];
			parcial *= modpow(x, i);
			parcial %= n;
			res += parcial;
			res %= n;
		}
		return (int) res % n;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			n = sc.nextInt() + 1;
			int m = sc.nextInt();
			if(n == 1 && m == 0)
				return;
			numeros.clear();
			k = sc.nextInt();
			for(int i = 0; i <= k; i++)
				coeficientes[i] = sc.nextInt();
			for(int i = 0; i <= m; i++)
				numeros.add(evaluar(i));
			System.out.println(numeros.size());
		}
		
	}
	
}
