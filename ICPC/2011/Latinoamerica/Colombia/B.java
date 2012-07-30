import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
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
	
	static BigInteger[] dpFactorial = new BigInteger[100];
	
	public static BigInteger factorial(int n)
	{
		if(dpFactorial[n] != null)
			return dpFactorial[n];
		if(n == 0)
			return dpFactorial[n] = BigInteger.ONE;
		return dpFactorial[n] = factorial(n - 1).multiply(BigInteger.valueOf(n));
	}

	public static BigInteger combinatoria(int k, int n)
	{
		return factorial(n).divide(factorial(n - k).multiply(factorial(k)));
	}
	
	static BigInteger[][] dp = new BigInteger[100][100];
	static int[] tamSets = new int[100];
	static int k;
	
	public static BigInteger dp(int set, int faltantes)
	{
		if(dp[set][faltantes] != null)
			return dp[set][faltantes];
		if(set == k)
			return dp[set][faltantes] = faltantes == 0 ? BigInteger.ONE : BigInteger.ZERO;
		int limite = Math.min(faltantes, tamSets[set]);
		BigInteger resultado = BigInteger.ZERO;
		for(int i = 0; i <= limite; i++)
			resultado = resultado.add(combinatoria(i, faltantes).multiply(dp(set + 1, faltantes - i)));
		return dp[set][faltantes] = resultado;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int m = sc.nextInt();
			k = sc.nextInt();
			if(m == 0 && k == 0)
				return;
			for(int i = 0; i <= k; i++)
				for(int j = 0; j <= m; j++)
					dp[i][j] = null;
			for(int i = 0; i < k; i++)
				tamSets[i] = sc.nextInt();
			System.out.println(dp(0, m));
		}
	}
}